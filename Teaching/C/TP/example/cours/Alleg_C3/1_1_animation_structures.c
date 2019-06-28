/**************************************************************************
ANIMATION : 10 éléments graphiques bougent à l'écran
						avec 3 formes et 2 comportements
						(rebond simple ou changement de direction au hasard)

						Par rapport au 1_0 on a juste ajouté
						des champs à la structure et quelques
						lignes dans les sous programmes

						MAIN ET PROTTYPES IDENTIQUES AU 1_0
			 ( plus d'intervention sur le programme principal
				 pour modifier des aspects de "détails" )
**************************************************************************/

#include <allegro.h>
#include <time.h>

// Nombre d'acteurs fixe :
//		le tableau d'acteurs sera déclaré et utilisé en "automatique"
//		t_acteur tab[NACTEUR];

// Une constante est nécessaire car on ne peut pas
// (en principe en C standard) utiliser une taille variable
// pour déclarer un tableau automatique.
#define NACTEUR 10

/****************************/
/*		 STRUCTURE ACTEUR		 */
/*	devra aller dans un .h	*/
/****************************/

// données personnelles de chaque acteur qui se déplace
typedef struct acteur {
	// coordonnée (du coin sup. gauche)
	int posx, posy;

	// vecteur deplacement
	int depx, depy;

	// tailles : horizontal/vertical
	int tx, ty;

	// couleur de l'élément graphique
	int couleur;

	// type :	 0 rectangle	 1 ellipse	 2 triangle
	//					( codes arbitraires : convention )
	int type;

	// comportement :	 0 inertie		 1 inertie + changements aléatoires
	//									( codes arbitraires : convention )
	int comportement;

} t_acteur;

/*****************************/
/*		 PROTOTYPES						*/
/*	devront aller dans un .h */
/*****************************/

// Allouer et initialiser un acteur
t_acteur *creerActeur();

// Remplir un tableau avec des acteurs créés
void remplirTabActeurs(t_acteur *tab[NACTEUR]);

// Actualiser un acteur (bouger ...)
void actualiserActeur(t_acteur *acteur);

// Gérer l'évolution de l'ensemble des acteurs
void actualiserTabActeurs(t_acteur *tab[NACTEUR]);

// Dessiner un acteur sur une bitmap bmp
void dessinerActeur(BITMAP *bmp, t_acteur *acteur);

// Dessiner l'ensemble des acteurs sur une bitmap bmp
void dessinerTabActeurs(BITMAP *bmp, t_acteur *tab[NACTEUR]);

/******************************************/
/* PROGRAMME PRINCIPAL										*/
/* initialisation puis boucle d'animation */
/******************************************/

int main() {
	// Le tableau regroupant tous les acteurs
	// c'est un tableau de pointeurs sur structures t_acteurs
	t_acteur *mesActeurs[NACTEUR];

	// BITMAP servant de buffer d'affichage (double buffer)
	BITMAP *page;

	// On va utiliser du hasard
	srand(time(NULL));

	// Lancer allegro et le mode graphique
	allegro_init();
	install_keyboard();

	set_color_depth(desktop_color_depth());
	if (set_gfx_mode(GFX_AUTODETECT_WINDOWED, 800, 600, 0, 0) != 0) {
		allegro_message("prb gfx mode");
		allegro_exit();
		exit(EXIT_FAILURE);
	}

	// CREATION DU BUFFER D'AFFICHAGE à la taille de l'écran
	page = create_bitmap(SCREEN_W, SCREEN_H);
	clear_bitmap(page);

	// Initialisation aléatoire des paramètres des acteurs :
	// remplir le tableau avec des acteurs alloués et initialisés
	remplirTabActeurs(mesActeurs);

	// Boucle d'animation (pas d'interaction)
	while (!key[KEY_ESC]) {
		// 1) EFFACER POSITIONs ACTUELLEs SUR LE BUFFER
		//		ON EFFACE TOUT LE BUFFER ! (c'est plus simple)
		clear_bitmap(page);

		// 2) DETERMINER NOUVELLEs POSITIONs
		actualiserTabActeurs(mesActeurs);

		// 3) AFFICHAGE NOUVELLEs POSITIONs SUR LE BUFFER
		dessinerTabActeurs(page, mesActeurs);

		// 4) AFFICHAGE DU BUFFER MIS A JOUR A L'ECRAN
		blit(page, screen, 0, 0, 0, 0, SCREEN_W, SCREEN_H);

		// 5) ON FAIT UNE PETITE PAUSE à chaque fois sinon ça va trop vite...
		rest(20);
	}

	return 0;
}
END_OF_MAIN();

/************************************************/
/*		 DEFINITIONS DES SOUS-PROGRAMMES					*/
/*	devront aller dans un autre .c : acteurs.c	*/
/************************************************/

// Allouer et initialiser (aléatoirement) un acteur
t_acteur *creerActeur() {
	// pointeur sur l'acteur qui sera créé (et retourné)
	t_acteur *acteur;

	// Création (allocation)
	acteur = (t_acteur *)malloc(1 * sizeof(t_acteur));

	// Initialisation

	acteur->tx = rand() % 40 + 40;
	acteur->ty = rand() % 40 + 40;

	// Position aléatoire (on tient compte de la taille...)
	acteur->posx = rand() % (SCREEN_W - acteur->tx);
	acteur->posy = rand() % (SCREEN_H - acteur->ty);

	// Vitesse aléatoire symétrique
	// avec composantes horizontales et verticales non nulles
	do {
		acteur->depx = rand() % 21 - 10;
		acteur->depy = rand() % 21 - 10;
	} while (acteur->depx == 0 || acteur->depy == 0);

	// Type au hasard 0, 1, 2
	acteur->type = rand() % 3;

	// Comportement au hasard (0 ou 1)
	acteur->comportement = rand() % 2;

	// Pour mieux visualiser on associe 2 domiantes couleurs distinctes
	// aux 2 comportement (mais ce n'est pas obligé)
	if (acteur->comportement == 0)
		acteur->couleur =
				makecol(rand() % 64 + 196, rand() % 40 + 40, rand() % 40 + 40);
	else
		acteur->couleur =
				makecol(rand() % 40 + 40, rand() % 64 + 196, rand() % 40 + 40);

	// on retourne cet acteur fraichement créé
	// ( en fait on retourne le POINTEUR sur lui )
	return acteur;
}

// Remplir un tableau avec des (pointeurs sur) acteurs créés
void remplirTabActeurs(t_acteur *tab[NACTEUR]) {
	int i;

	// On "accroche" NACTEUR nouveaux acteurs
	// à chaque case du tableau
	for (i = 0; i < NACTEUR; i++)
		tab[i] = creerActeur();
}

// Actualiser un acteur (bouger ...)
void actualiserActeur(t_acteur *acteur) {

	// prise en compte comportement
	// ( proba de changement de déplacement seulement si comportement 1 )
	if (acteur->comportement == 1) {
		// Une chance sur 20
		if (rand() % 20 == 0) {
			// Nouveau vecteur déplacement
			acteur->depx = rand() % 11 - 5;
			acteur->depy = rand() % 11 - 5;
		}
	}

	// contrôle des bords : ici on décide de rebondir sur les bords
	if ((acteur->posx < 0 && acteur->depx < 0) ||
			(acteur->posx + acteur->tx > SCREEN_W && acteur->depx > 0))
		acteur->depx = -acteur->depx;

	if ((acteur->posy < 0 && acteur->depy < 0) ||
			(acteur->posy + acteur->ty > SCREEN_H && acteur->depy > 0))
		acteur->depy = -acteur->depy;

	// calculer nouvelle position
	// nouvelle position = position actuelle + deplacement
	acteur->posx = acteur->posx + acteur->depx;
	acteur->posy = acteur->posy + acteur->depy;
}

// Gérer l'évolution de l'ensemble des acteurs
void actualiserTabActeurs(t_acteur *tab[NACTEUR]) {
	int i;

	for (i = 0; i < NACTEUR; i++)
		actualiserActeur(tab[i]);
}

// Dessiner un acteur sur une bitmap bmp
void dessinerActeur(BITMAP *bmp, t_acteur *acteur) {
	// Prise en compte du type
	// 0 rectangle	 1 ellipse	 2 triangle
	switch (acteur->type) {
	case 0:
		rectfill(bmp, acteur->posx, acteur->posy, acteur->posx + acteur->tx,
						 acteur->posy + acteur->ty, acteur->couleur);
		break;
	case 1:
		ellipsefill(bmp, acteur->posx + acteur->tx / 2,
								acteur->posy + acteur->ty / 2, acteur->tx / 2, acteur->ty / 2,
								acteur->couleur);
		break;
	case 2:
		triangle(bmp, acteur->posx, acteur->posy + acteur->ty,
						 acteur->posx + acteur->tx / 2, acteur->posy,
						 acteur->posx + acteur->tx, acteur->posy + acteur->ty,
						 acteur->couleur);
		break;
	}
}

// Dessiner sur une bitmap l'ensemble des acteurs
void dessinerTabActeurs(BITMAP *bmp, t_acteur *tab[NACTEUR]) {
	int i;

	for (i = 0; i < NACTEUR; i++)
		dessinerActeur(bmp, tab[i]);
}
