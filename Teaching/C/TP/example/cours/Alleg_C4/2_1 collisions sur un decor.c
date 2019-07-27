/**************************************************************************
COLLISIONS DECOR:
						Un sprite (vaisseau spatial) se déplace vers la souris (cliquer)
						Le déplacement se fait sur un décor avec des murs présents
						sur une carte de collision (bitmaps invisible au joueur)
						Les murs ( blancs ) bloquent le déplacement...
						Un objectif ( rouge ) permet de charger une jauge.

						La détection des contacts est faite avec des getpixels
						sur les bords de l'élément : on compte les getpixels
						qui retournent une couleur particulière (mur ou autre)

**************************************************************************/

#include <allegro.h>

/****************************/
/*		 STRUCTURE ACTEUR		 */
/****************************/

// données personnelles de chaque acteur qui se déplace
typedef struct acteur {
	int x, y;				 // coordonnée (du coin sup. gauche)
	int precx, precy; // coordonnées précédent le déplacement
	int dx, dy;			 // vecteur deplacement
	int tx, ty;			 // tailles : horizontal/vertical
	BITMAP *img;			// image de l'acteur
} t_acteur;

/****************************/
/*		 FONCTIONs UTILEs		 */
/****************************/

// Fonction détectant un contact avec couleur sur
// l'ensemble des pixels du rectangle encadrant l'acteur
// Retourne le nombre de pixels du bord en contact avec couleur
//	ce qui peut s'interpréter comme un booléen au niveau de l'appelant
//	ou être utilisé pour évaluer quantitativement la longueur du contact.
int contactBordActeur(t_acteur *acteur, BITMAP *bmp, int couleur) {
	int ncontact;
	int xb, yb;

	ncontact = 0;

	// Bords gauches et droits
	for (yb = 0; yb < acteur->ty; yb++) {
		if (getpixel(bmp, acteur->x, acteur->y + yb) == couleur)
			ncontact++;
		if (getpixel(bmp, acteur->x + acteur->tx, acteur->y + yb) == couleur)
			ncontact++;
	}

	for (xb = 0; xb < acteur->tx; xb++) {
		if (getpixel(bmp, acteur->x + xb, acteur->y) == couleur)
			ncontact++;
		if (getpixel(bmp, acteur->x + xb, acteur->y + acteur->ty) == couleur)
			ncontact++;
	}

	return ncontact;
}

// Donner à l'acteur un déplacement pour qu'il se rapproche de la souris
void versSourisActeur(t_acteur *acteur) {
	// vecteur déplacement = vecteur centre_vaisseau->souris
	acteur->dx = mouse_x - (acteur->x + acteur->tx / 2);
	acteur->dy = mouse_y - (acteur->y + acteur->ty / 2);
	// mais il faut limiter la vitesse : borner les valeurs obtenues
	if (acteur->dx > 5)
		acteur->dx = 5;
	if (acteur->dx < -5)
		acteur->dx = -5;
	if (acteur->dy > 5)
		acteur->dy = 5;
	if (acteur->dy < -5)
		acteur->dy = -5;
}

// Chargement "sécurisé" d'une image :
// interrompt le programme avec un message si problème...
BITMAP *load_bitmap_check(char *nomImage) {
	BITMAP *bmp;
	bmp = load_bitmap(nomImage, NULL);
	if (!bmp) {
		allegro_message("pas pu trouver %s", nomImage);
		exit(EXIT_FAILURE);
	}
	return bmp;
}

/******************************************/
/* PROGRAMME PRINCIPAL										*/
/* initialisation puis boucle de jeu			*/
/******************************************/

int main() {

	t_acteur *acteur; // Un acteur (à créer)
	BITMAP *page;		 // BITMAP buffer d'affichage
	BITMAP *decor;		// Image de fond, seulement pour visualiser
	BITMAP *murs;		 // Image de fond, seulement pour les collisions
	int jauge = 1000; // Pour évaluer une jauge de carburant
	int ncontact;		 // Pour évaluer le degré de contact avec couleur spéciale

	// Lancer allegro et le mode graphique
	allegro_init();
	install_keyboard();
	install_mouse();

	set_color_depth(desktop_color_depth());
	if (set_gfx_mode(GFX_AUTODETECT_WINDOWED, 800, 600, 0, 0) != 0) {
		allegro_message("prb gfx mode");
		allegro_exit();
		exit(EXIT_FAILURE);
	}

	// Montrer la souris à l'écran
	show_mouse(screen);

	// CREATION DU BUFFER D'AFFICHAGE à la taille de l'écran
	page = create_bitmap(SCREEN_W, SCREEN_H);
	clear_bitmap(page);

	// charger image de fond
	decor = load_bitmap_check("images/fond_decor.bmp");

	// charger image de murs
	murs = load_bitmap_check("images/fond_murs.bmp");

	// Allocation et initialisation des paramètres de l'acteur :
	acteur = (t_acteur *)malloc(1 * sizeof(t_acteur));
	acteur->tx = 99;
	acteur->ty = 38;
	acteur->x = 300;
	acteur->y = 260;
	acteur->dx = 0;
	acteur->dy = 0;
	acteur->img = load_bitmap_check("images/spaceship_small.bmp");

	// Boucle de jeu
	while (!key[KEY_ESC]) {
		// Effacer buffer en appliquant décor
		blit(decor, page, 0, 0, 0, 0, SCREEN_W, SCREEN_H);

		// GESTION INTERFACE si cliquer alors le vaisseau part vers la souris
		if (mouse_b & 1)
			versSourisActeur(acteur);

		// ENREGISTRER POSITION ACTUELLE
		acteur->precx = acteur->x;
		acteur->precy = acteur->y;

		// DETERMINER NOUVELLE POSITION
		acteur->x += acteur->dx; // équivalent à acteur->x = acteur->x + acteur->dx;
		acteur->y += acteur->dy; // équivalent à acteur->y = acteur->y + acteur->dy;

		// SI COLLISION AVEC LE DECOR ALORS ON REVIENT SUR LA POSITION PRECEDENT LE
		// DEPLACEMENT
		//	ici on regard uniquement sur la carte de collision (murs) invisible pour
		//	l'utilisateur
		if (contactBordActeur(acteur, murs, makecol(255, 255, 255))) {
			acteur->x = acteur->precx;
			acteur->y = acteur->precy;

			// Souvent on accroche en dx ou dy mais on souhaite pouvoir "glisser" sur
			// l'autre axe donc on va essayer de voir si sur un seul axe ça ne passe
			// pas...
			acteur->x += acteur->dx; // juste dx ?
			if (contactBordActeur(acteur, murs, makecol(255, 255, 255)))
				acteur->x = acteur->precx; // ça ne passe toujours pas
			acteur->y += acteur->dy;		 // juste dy ?
			if (contactBordActeur(acteur, murs, makecol(255, 255, 255)))
				acteur->y = acteur->precy; // ça ne passe toujours pas
		}

		// SI CONTACT AVEC AUTRE COULEUR SPECIALE SUR CARTE DE COLLISION...
		ncontact = contactBordActeur(acteur, murs, makecol(255, 0, 0));
		if (ncontact != 0) {
			jauge += ncontact;
			if (jauge > 79199)
				jauge = 79199;
		}

		// AFFICHAGE NOUVELLEs POSITIONs SUR LE BUFFER
		draw_sprite(page, acteur->img, acteur->x, acteur->y);
		rectfill(page, 4, 4, 796, 24, makecol(0, 0, 0));
		rectfill(page, 4, 4, 4 + jauge / 100, 24, makecol(0, 255, 0));
		rect(page, 4, 4, 796, 24, makecol(255, 255, 0));

		// AFFICHAGE DU BUFFER MIS A JOUR A L'ECRAN
		blit(page, screen, 0, 0, 0, 0, SCREEN_W, SCREEN_H);

		// ON FAIT UNE PETITE PAUSE
		rest(10);
	}

	return 0;
}
END_OF_MAIN();
