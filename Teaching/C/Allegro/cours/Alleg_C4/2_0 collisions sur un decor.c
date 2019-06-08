/**************************************************************************
COLLISIONS DECOR:
						Un élément rectangulaire se déplace vers la souris (cliquer)
						Le déplacement se fait sur un décor avec des murs
						les murs (blanc) bloquent le déplacement...
						les autres couleurs sont ignorées (graphisme de fond)...

						La détection des collisions est faite avec des getpixels
						sur les coins de l'élément : si le getpixel retourne une
						couleur de mur on bloque le déplacement.

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
	int couleur;			// couleur de l'élément graphique
} t_acteur;

/******************************************/
/* PROGRAMME PRINCIPAL										*/
/* initialisation puis boucle de jeu			*/
/******************************************/

int main() {

	// Un acteur (à créer)
	t_acteur *acteur;

	// BITMAP servant de buffer d'affichage (double buffer)
	BITMAP *page;

	// Image de fond, seulement pour visualiser
	BITMAP *decor;

	// couleur des murs ( ! ne PAS utiliser makecol AVANT d'être en mode graphique
	// ! )
	int couleurMur;

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
	decor = load_bitmap("images/fond_murs.bmp", NULL);
	if (!decor) {
		allegro_message("pas pu trouver images/fond_murs.bmp");
		exit(EXIT_FAILURE);
	}

	// on sait que les murs seront blancs...
	couleurMur = makecol(255, 255, 255);

	// Allocation et initialisation des paramètres de l'acteur :
	acteur = (t_acteur *)malloc(1 * sizeof(t_acteur));
	acteur->tx = 99;
	acteur->ty = 38;
	acteur->x = 300;
	acteur->y = 260;
	acteur->dx = 0;
	acteur->dy = 0;
	acteur->couleur = makecol(50, 200, 50);

	// Boucle de jeu
	while (!key[KEY_ESC]) {
		// effacer buffer en appliquant décor	(pas de clear_bitmap)
		blit(decor, page, 0, 0, 0, 0, SCREEN_W, SCREEN_H);

		// GESTION INTERFACE si clique le vaisseau part vers la souris
		if (mouse_b & 1) {
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

		// ENREGISTRER POSITION ACTUELLE
		acteur->precx = acteur->x;
		acteur->precy = acteur->y;

		// DETERMINER NOUVELLE POSITION
		acteur->x += acteur->dx; // équivalent à acteur->x = acteur->x + acteur->dx;
		acteur->y += acteur->dy; // équivalent à acteur->y = acteur->y + acteur->dy;

		// SI COLLISION AVEC LE DECOR ALORS ON REVIENT SUR LA POSITION PRECEDENT LE
		// DEPLACEMENT
		//	ici on regard directement sur le buffer (page) mais on pourrait
		//	regarder plutôt directement sur le decor...
		if (getpixel(page, acteur->x, acteur->y) == couleurMur ||
				getpixel(page, acteur->x + acteur->tx, acteur->y) == couleurMur ||
				getpixel(page, acteur->x, acteur->y + acteur->ty) == couleurMur ||
				getpixel(page, acteur->x + acteur->tx, acteur->y + acteur->ty) ==
						couleurMur) {
			acteur->x = acteur->precx;
			acteur->y = acteur->precy;
		}

		// AFFICHAGE NOUVELLEs POSITIONs SUR LE BUFFER
		rectfill(page, acteur->x, acteur->y, acteur->x + acteur->tx,
						 acteur->y + acteur->ty, acteur->couleur);

		// AFFICHAGE DU BUFFER MIS A JOUR A L'ECRAN
		blit(page, screen, 0, 0, 0, 0, SCREEN_W, SCREEN_H);

		// ON FAIT UNE PETITE PAUSE
		rest(10);
	}

	return 0;
}
END_OF_MAIN();
