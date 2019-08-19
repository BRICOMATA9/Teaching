/**************************************************************************
COLLISIONS: 2 éléments rectangulaires bougent avec la souris (drag and throw)

						on détecte leur collision et l'état de collision
						est signalée par un changement de couleur
						Ce code reprend des fonctions de 1_0 et 1_1 du cours 3
						on a enlevé la gestion du tableau d'acteurs (seulement 2 acteurs)

						La détection proprement dite des collisions est faite
						par une fonction auxilliaire : collisionActeurs
						Voir tout en bas du code.

**************************************************************************/

#include <allegro.h>
#include <time.h>

/****************************/
/*		 STRUCTURE ACTEUR		 */
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
/*****************************/

// Fonctions principales (appelées depuis le main)

// Allouer et initialiser un acteur
t_acteur *creerActeur();

// Actualiser un acteur (bouger ...)
void actualiserActeur(t_acteur *acteur);

// Dessiner un acteur sur une bitmap bmp
void dessinerActeur(BITMAP *bmp, t_acteur *acteur);

// Fonctions annexes

// voir ci dessous pour des manières alternatives d'écrire la même fonction
int sousSourisActeur(t_acteur *acteur);

// Déterminer si les rectangles de 2 acteurs s'intersectent
// Fonction booléenne : retourne 1 si collision	0 sinon
int collisionActeurs(t_acteur *a1, t_acteur *a2);

/******************************************/
/* PROGRAMME PRINCIPAL										*/
/* initialisation puis boucle de jeu			*/
/******************************************/

int main() {
	// 2 acteurs (à créer)
	t_acteur *actA, *actB;

	// BITMAP servant de buffer d'affichage (double buffer)
	BITMAP *page;

	// Mouvement Mouse en x et y	(mouvement = changement de position)
	int mmx, mmy;

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
	actA = creerActeur();
	actB = creerActeur();

	// Boucle de jeu
	while (!key[KEY_ESC]) {
		// EFFACER POSITIONs ACTUELLEs SUR LE BUFFER
		clear_bitmap(page);

		// GESTION INTERFACE

		// Le "mickey" est l'unité de déplacement du curseur souris
		// la fonction suivante récupère le vecteur déplacement depuis son dernier
		// appel
		get_mouse_mickeys(&mmx, &mmy);

		if (mouse_b & 1 && sousSourisActeur(actA)) {
			actA->dx = mmx;
			actA->dy = mmy;
		}

		if (mouse_b & 1 && sousSourisActeur(actB)) {
			actB->dx = mmx;
			actB->dy = mmy;
		}

		// DETERMINER NOUVELLEs POSITIONs
		actualiserActeur(actA);
		actualiserActeur(actB);

		// COLLISION ?
		if (collisionActeurs(actA, actB)) {
			actA->couleur = makecol(255, 80, 80);
			actB->couleur = makecol(255, 80, 80);
		} else {
			actA->couleur = makecol(80, 255, 80);
			actB->couleur = makecol(80, 255, 80);
		}

		// AFFICHAGE NOUVELLEs POSITIONs SUR LE BUFFER
		dessinerActeur(page, actA);
		dessinerActeur(page, actB);

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
/************************************************/

// Allouer et initialiser (aléatoirement) un acteur
t_acteur *creerActeur() {
	// pointeur sur l'acteur qui sera créé (et retourné)
	t_acteur *acteur;

	// Création (allocation)
	acteur = (t_acteur *)malloc(1 * sizeof(t_acteur));

	// Initialisation

	acteur->tx = rand() % 100 + 100;
	acteur->ty = rand() % 100 + 100;

	// Position aléatoire (on tient compte de la taille...)
	acteur->x = rand() % (SCREEN_W - acteur->tx);
	acteur->y = rand() % (SCREEN_H - acteur->ty);

	// Pour ce programme on veut des acteurs initialement immobiles
	acteur->dx = 0;
	acteur->dy = 0;

	// Couleur blanche (mais ce sera modifié dans le main...)
	acteur->couleur = makecol(255, 255, 255);

	// on retourne cet acteur fraichement créé
	// ( en fait on retourne le POINTEUR sur lui )
	return acteur;
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

// Dessiner un acteur sur une bitmap bmp
void dessinerActeur(BITMAP *bmp, t_acteur *acteur) {
	rectfill(bmp, acteur->x, acteur->y, acteur->x + acteur->tx,
					 acteur->y + acteur->ty, acteur->couleur);
}

// Déterminer si un acteur est sous la souris
// Fonction booléenne : retourne 1 pour oui	0 pour non
// voir ci dessous pour des manières alternatives d'écrire la même fonction
int sousSourisActeur(t_acteur *acteur) {
	int retour = 0;

	if (mouse_x >= acteur->x && mouse_x <= acteur->x + acteur->tx &&
			mouse_y >= acteur->y && mouse_y <= acteur->y + acteur->ty)
		retour = 1;

	return retour;
}

// On pourrait aussi écrire (moins "rigoureux" car plusieurs return):
/*
int sousSourisActeur(t_acteur *acteur)
{
		if ( mouse_x >= acteur->x && mouse_x <= acteur->x + acteur->tx &&
				 mouse_y >= acteur->y && mouse_y <= acteur->y + acteur->ty )
				return 1;
		else
				return 0;
}
*/

// On pourrait aussi écrire (rigoureux et compact mais à réserver aux cas
// simples)
/*
int sousSourisActeur(t_acteur *acteur)
{
		// On peut retourner directement le résultat d'une expression booléenne
		return	mouse_x >= acteur->x && mouse_x <= acteur->x + acteur->tx &&
						mouse_y >= acteur->y && mouse_y <= acteur->y + acteur->ty ;
}
*/

// Déterminer si les rectangles de 2 acteurs s'intersectent
// Fonction booléenne : retourne 1 si collision	0 sinon
int collisionActeurs(t_acteur *a1, t_acteur *a2) {
	int retour = 0;

	// Si collision mettre valeur retour à 1
	if (a1->x <= a2->x + a2->tx && a2->x <= a1->x + a1->tx &&
			a1->y <= a2->y + a2->ty && a2->y <= a1->y + a1->ty)
		retour = 1;

	return retour;
}
