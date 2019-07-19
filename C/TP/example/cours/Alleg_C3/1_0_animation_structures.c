/**************************************************************************
ANIMATION : 10 disques bougent à l'écran (rebondissent sur les bords)
						avec double buffer (pas de clignotement)

						Amelioration par rapport au code 6_0 du cours 2 :

						UN TABLEAU DE STRUCTURES (ACTEURS)...
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

	// tailles (rayons des disques)
	int rayon;

	// couleur des disques
	int couleur;

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

	// rayon du disque (var. temporaire)
	int r;

	// Création (allocation)
	acteur = (t_acteur *)malloc(1 * sizeof(t_acteur));

	// Initialisation

	r = rand() % 40 + 1;

	// Position aléatoire (on tient compte de la taille...)
	acteur->posx = rand() % (SCREEN_W - 2 * r) + r;
	acteur->posy = rand() % (SCREEN_H - 2 * r) + r;

	// Vitesse aléatoire symétrique
	// avec composantes horizontales et verticales non nulles
	do {
		acteur->depx = rand() % 21 - 10;
		acteur->depy = rand() % 21 - 10;
	} while (acteur->depx == 0 || acteur->depy == 0);

	acteur->rayon = r;

	// Couleur pas trop sombre
	acteur->couleur =
			makecol(rand() % 128 + 128, rand() % 128 + 128, rand() % 128 + 128);

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
	if ((acteur->posx - acteur->rayon < 0 && acteur->depx < 0) ||
			(acteur->posx + acteur->rayon > SCREEN_W && acteur->depx > 0))
		acteur->depx = -acteur->depx;

	if ((acteur->posy - acteur->rayon < 0 && acteur->depy < 0) ||
			(acteur->posy + acteur->rayon > SCREEN_H && acteur->depy > 0))
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
	circlefill(bmp, acteur->posx, acteur->posy, acteur->rayon, acteur->couleur);
}

// Dessiner sur une bitmap l'ensemble des acteurs
void dessinerTabActeurs(BITMAP *bmp, t_acteur *tab[NACTEUR]) {
	int i;

	for (i = 0; i < NACTEUR; i++)
		dessinerActeur(bmp, tab[i]);
}
