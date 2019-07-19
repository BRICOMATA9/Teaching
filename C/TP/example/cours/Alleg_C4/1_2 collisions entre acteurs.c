/**************************************************************************
COLLISIONS: 10 éléments rectangulaires bougent à l'écran
						ils rebondissent sur les bords de l'écran
						et entrent en collision les uns avec les autres

						Ce code reprend largement le code 1_0 et 1_1 du cours 3
						on a modifié essentiellement la fonction actualiserTabActeurs
						pour détecter et réagir aux collisions.

						La détection proprement dite des collisions est faite
						par une fonction auxilliaire : collisionActeurs

						On peut interagir :
						Cliquer à la souris sur un rectangle pour le bloquer
						ou lui donner une vitesse (drag and throw)
						Espace pour figer tout le monde
						Entrée pour relancer tout le monde avec nouveaux mouvements

**************************************************************************/

#include <allegro.h>
#include <time.h>

// Ici nombre d'acteurs fixe

#define NACTEUR 10

/****************************/
/*		 STRUCTURE ACTEUR		 */
/*	devra aller dans un .h	*/
/****************************/

// données personnelles de chaque acteur qui se déplace
typedef struct acteur {
	int x, y;		// coordonnée (du coin sup. gauche)
	int dx, dy;	// vecteur deplacement
	int tx, ty;	// tailles : horizontal/vertical
	int couleur; // couleur de l'élément graphique
} t_acteur;

/*****************************/
/*		 PROTOTYPES						*/
/*	devront aller dans un .h */
/*****************************/

// Fonctions principales (appelées depuis le main)

// Allouer et initialiser un acteur
t_acteur *creerActeur();

// Remplir un tableau avec des acteurs créés
void remplirTabActeurs(t_acteur *tab[NACTEUR]);

// Actualiser un acteur (bouger ...)
void actualiserActeur(t_acteur *acteur);

// Gérer l'évolution de l'ensemble des acteurs
void actualiserTabActeurs(t_acteur *tab[NACTEUR]);

// Gérer la possibilité de bouger un acteur à la souris
void interfaceTabActeurs(t_acteur *tab[NACTEUR]);

// Dessiner un acteur sur une bitmap bmp
void dessinerActeur(BITMAP *bmp, t_acteur *acteur);

// Dessiner l'ensemble des acteurs sur une bitmap bmp
void dessinerTabActeurs(BITMAP *bmp, t_acteur *tab[NACTEUR]);

// Fonctions annexes

// (ré)initialiser vecteur déplacement aléatoire avec composantes non nulles
void vecDepAleaActeur(t_acteur *acteur);

// Déterminer si les rectangles de 2 acteurs s'intersectent
// Retourne 0 si pas de collision
// Si collision alors retourne une valeur selon la position de a2 par rapport à
// a1 1 : plutôt à droite	 2 : plutôt à gauche	 3 : plutôt en bas	 4 : plutôt
// en haut
int collisionActeurs(t_acteur *a1, t_acteur *a2);

/******************************************/
/* PROGRAMME PRINCIPAL										*/
/* initialisation puis boucle de jeu			*/
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

	// Initialisation aléatoire des paramètres des acteurs :
	// remplir le tableau avec des acteurs alloués et initialisés
	remplirTabActeurs(mesActeurs);

	// Boucle de jeu
	while (!key[KEY_ESC]) {
		// EFFACER POSITIONs ACTUELLEs SUR LE BUFFER
		clear_to_color(page, makecol(96, 96, 96));

		// GESTION INTERFACE
		interfaceTabActeurs(mesActeurs);

		// DETERMINER NOUVELLEs POSITIONs
		actualiserTabActeurs(mesActeurs);

		// AFFICHAGE NOUVELLEs POSITIONs SUR LE BUFFER
		dessinerTabActeurs(page, mesActeurs);

		// AFFICHAGE DU BUFFER MIS A JOUR A L'ECRAN
		blit(page, screen, 0, 0, 0, 0, SCREEN_W, SCREEN_H);

		// ON FAIT UNE PETITE PAUSE
		rest(10);
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

	acteur->tx = rand() % 140 + 40;
	acteur->ty = rand() % 140 + 40;

	// Position aléatoire (on tient compte de la taille...)
	acteur->x = rand() % (SCREEN_W - acteur->tx);
	acteur->y = rand() % (SCREEN_H - acteur->ty);

	// Initialiser vecteur déplacement aléatoire
	vecDepAleaActeur(acteur);

	// Couleur dominante verte
	acteur->couleur =
			makecol(rand() % 40 + 40, rand() % 64 + 192, rand() % 40 + 40);

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
	// contrôle des bords : ici on décide de rebondir sur les bords
	if ((acteur->x < 0 && acteur->dx < 0) ||
			(acteur->x + acteur->tx > SCREEN_W && acteur->dx > 0))
		acteur->dx = -acteur->dx;

	if ((acteur->y < 0 && acteur->dy < 0) ||
			(acteur->y + acteur->ty > SCREEN_H && acteur->dy > 0))
		acteur->dy = -acteur->dy;

	// calculer nouvelle position
	// nouvelle position = position actuelle + deplacement
	acteur->x = acteur->x + acteur->dx;
	acteur->y = acteur->y + acteur->dy;
}

// Gérer l'évolution de l'ensemble des acteurs
void actualiserTabActeurs(t_acteur *tab[NACTEUR]) {
	int i, j, cote;

	// Contrôle des collisions : si on entre en collision avec un autre
	// et que la collision tend à nous rapprocher alors on rebondit
	for (i = 0; i < NACTEUR; i++)
		for (j = i + 1; j < NACTEUR; j++)
			if ((cote = collisionActeurs(tab[i], tab[j]))) {
				if ((cote == 1 && tab[i]->dx < 0) || (cote == 2 && tab[i]->dx > 0))
					tab[i]->dx = -tab[i]->dx;
				if ((cote == 3 && tab[i]->dy < 0) || (cote == 4 && tab[i]->dy > 0))
					tab[i]->dy = -tab[i]->dy;
				if ((cote == 1 && tab[j]->dx > 0) || (cote == 2 && tab[j]->dx < 0))
					tab[j]->dx = -tab[j]->dx;
				if ((cote == 3 && tab[j]->dy > 0) || (cote == 4 && tab[j]->dy < 0))
					tab[j]->dy = -tab[j]->dy;
			}

	// Gérer les déplacements habituels...
	for (i = 0; i < NACTEUR; i++)
		actualiserActeur(tab[i]);
}

// Gérer la possibilité de bouger un acteur à la souris
void interfaceTabActeurs(t_acteur *tab[NACTEUR]) {
	int i, mmx, mmy;
	t_acteur *acteur;

	// ESPACE pour figer tous les acteurs
	if (key[KEY_SPACE]) {
		for (i = 0; i < NACTEUR; i++) {
			tab[i]->dx = 0;
			tab[i]->dy = 0;
		}
	}

	// ENTREE pour réinitialiser déplacement aléatoire tous les acteurs
	if (key[KEY_ENTER]) {
		for (i = 0; i < NACTEUR; i++)
			vecDepAleaActeur(tab[i]);
	}

	// Mouvement mouse depuis le dernier appel à get_mouse_mickeys ?
	get_mouse_mickeys(&mmx, &mmy);

	// Si on clique et qu'un des rectangles est sous la souris,
	// on met son déplacement identique à celui de la souris
	if (mouse_b & 1) {

		for (i = 0; i < NACTEUR; i++) {
			acteur = tab[i];
			if (mouse_x >= acteur->x && mouse_x <= acteur->x + acteur->tx &&
					mouse_y >= acteur->y && mouse_y <= acteur->y + acteur->ty) {
				acteur->dx = mmx;
				acteur->dy = mmy;
			}
		}
	}
}

// Dessiner un acteur sur une bitmap bmp
void dessinerActeur(BITMAP *bmp, t_acteur *acteur) {
	rectfill(bmp, acteur->x, acteur->y, acteur->x + acteur->tx,
					 acteur->y + acteur->ty, acteur->couleur);
}

// Dessiner sur une bitmap l'ensemble des acteurs
void dessinerTabActeurs(BITMAP *bmp, t_acteur *tab[NACTEUR]) {
	int i;

	for (i = 0; i < NACTEUR; i++)
		dessinerActeur(bmp, tab[i]);
}

// (ré)initialiser vecteur déplacement aléatoire avec composantes non nulles
void vecDepAleaActeur(t_acteur *acteur) {
	do {
		acteur->dx = rand() % 11 - 5;
		acteur->dy = rand() % 11 - 5;
	} while (acteur->dx == 0 || acteur->dy == 0);
}

// Déterminer si les rectangles de 2 acteurs s'intersectent
// Retourne 0 si pas de collision
// Si collision alors retourne une valeur selon la position de a2 par rapport à
// a1 1 : plutôt à droite	 2 : plutôt à gauche	 3 : plutôt en bas	 4 : plutôt
// en haut
int collisionActeurs(t_acteur *a1, t_acteur *a2) {
	int retour;
	int m[4], imin, i;

	// Calcul des marges d'intersection (a2 par rapport à a1)
	m[0] = a2->x + a2->tx - a1->x; // 0: à droite
	m[1] = a1->x + a1->tx - a2->x; // 1: à gauche
	m[2] = a2->y + a2->ty - a1->y; // 2: en bas
	m[3] = a1->y + a1->ty - a2->y; // 3: en haut

	// Chercher l'indice de la plus petite marge
	imin = 0;
	for (i = 1; i < 4; i++)
		if (m[i] < m[imin])
			imin = i;

	// A priori pas de collision
	retour = 0;

	// Si la plus petite marge n'est pas strictement négative
	// alors c'est qu'on a une collision et cette collision est de ce coté
	if (m[imin] >= 0)
		retour = imin + 1; // on retourne l'indice du coté + 1 (car 0 signifie "pas
											 // de collision")

	return retour;
}
