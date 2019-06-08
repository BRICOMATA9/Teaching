/**************************************************************************
PLUSIEURS SPRITES ANIMES

					ce programme illustre l'animation de plusieurs personnage (animaux)
					qui traversent l'écran

					Pour avoir plusieurs séquences animées
					il faut plusieurs tableaux de bitmaps
					correspondant aux séquences d'images

					Ici, chaque structure de type t_sequence regroupe
					les images d'une séquence, et on utilise un tableau
					global tabSequences de ces structures

					Pour éviter d'avoir à gérer des quantités
					importantes de petits fichiers images, chaque
					séquence image est regroupée dans un même .bmp
					La procédure void chargerSequence(t_sequence * seq);
					permet de découper cette image de départ en petite bitmaps
					(une pour chaque étape de l'animation)
**************************************************************************/

#include <allegro.h>
#include <time.h>

/***************************************************/
/*									 CONSTANTES										*/
/*						devront aller dans un .h						 */
/***************************************************/

// sur cet exemple Nombre d'acteurs fixe :
//		le tableau d'acteurs sera déclaré et utilisé en "automatique"
//		t_acteur tab[NACTEUR];
// Pour modifier cette valeur il faut adapter remplirTabActeurs
#define NACTEUR 6

// nombre total de séquences d'animation du jeu
// ( le nombre d'acteurs peut être supérieur si plusieurs acteurs utilisent les
// même graphismes ) Pour modifier cette valeur il faut modifier le tableau
// initialisé tabSequences
#define NSEQUENCE 6

/*****************************/
/*			 STRUCTURES					*/
/*	devront aller dans un .h */
/*****************************/

// données pour chaque séquence d'animation chargée initialement
//	( à ne faire qu'une seule fois au début du jeu )
typedef struct sequence {
	char *nomSource; // nom du fichier image contenant la séquence
	int nimg;				// nombre d'images dans la séquence
	int tx, ty;			// largeur et hauteur des images de la séquence
	int ncol; // nbr images cotes à cotes horizontalement dans le fichier image
	BITMAP **img; // tableau de pointeurs pour indiquer les images
} t_sequence;

// données personnelles de chaque acteur qui se déplace
// sur cet exemple on ne gère que des déplacements horizontaux (pas de dy...)
typedef struct acteur {
	// géométrie et déplacements

	int x, y;	 // position du coin sup. gauche
	int dx;		 // deplacement
	int tmpdx;	// ralentir déplacements en x (1 pour ne pas ralentir)
	int cptdx;	// compteur pour ralentir déplacement
	int tx, ty; // largeur hauteur

	// séquence d'images de l'animation

	int imgcourante; // indice de l'image courante
	int tmpimg;			// ralentir séquence (image suivante 1 fois sur tmpimg)
	int cptimg;			// compteur pour ralentir séquence

	// type = numéro de la sequence à utiliser dans tabSequences
	// ( ici : 0 Dragon	1 Poisson	2 Crabe	3 Abeille	4 Moustique	5 Serpent )

	int type;

} t_acteur;

/*****************************/
/*			 PROTOTYPES					*/
/*	devront aller dans un .h */
/*****************************/

// Allouer et initialiser un acteur
t_acteur *creerActeur(int type, int x, int y, int dx, int tmpdx, int tmpimg);

// Pour remplir un tableau avec des acteurs créés
// Sur cet exemple on crée 6 acteurs, chacun associé à une séquence
void remplirTabActeurs(t_acteur *tab[NACTEUR]);

// Actualiser un acteur (bouger ...)
void actualiserActeur(t_acteur *acteur);

// Gérer l'évolution de l'ensemble des acteurs
void actualiserTabActeurs(t_acteur *tab[NACTEUR]);

// Dessiner un acteur sur une bitmap bmp
void dessinerActeur(BITMAP *bmp, t_acteur *acteur);

// Dessiner l'ensemble des acteurs sur une bitmap bmp
void dessinerTabActeurs(BITMAP *bmp, t_acteur *tab[NACTEUR]);

// Charger les images d'une séquence d'animation
// Découpe une image source en plusieurs vignettes
// (doivent être rangées de gauche à droite et de haut en bas)
void chargerSequence(t_sequence *seq);

// Charger toutes les séquences du tableau global tabSequence
void chargerTabSequences();

/***************************************************/
/*							VARIABLES GLOBALES								 */
/*	les déclarations devront aller dans un .h			*/
/*	les définitions devront aller dans un .c			 */
/***************************************************/

// tableau global de toutes les séquences animées du jeu
// on s'autorise à utiliser un tableau global car ces données
// n'existent qu'en un seul exemplaire à l'échelle du programme
t_sequence tabSequences[NSEQUENCE] = {
		//					nomSource					 , nimg,	tx,	ty, ncol
		{"images/dragon/dragon.bmp", 6, 128, 64, 3},
		{"images/dragon/poisson.bmp", 3, 64, 32, 3},
		{"images/dragon/crabe.bmp", 4, 64, 32, 4},
		{"images/dragon/abeille.bmp", 6, 50, 40, 6},
		{"images/dragon/moustique.bmp", 6, 50, 40, 6},
		{"images/dragon/serpent.bmp", 7, 100, 50, 4}};

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

	// Image de fond
	BITMAP *decor;

	// On va utiliser du hasard
	srand(time(NULL));

	// Lancer allegro et le mode graphique
	allegro_init();
	install_keyboard();

	set_color_depth(desktop_color_depth());
	if (set_gfx_mode(GFX_AUTODETECT_WINDOWED, 640, 480, 0, 0) != 0) {
		allegro_message("prb gfx mode");
		allegro_exit();
		exit(EXIT_FAILURE);
	}

	// Création du buffer d'affichage à la taille de l'écran
	page = create_bitmap(SCREEN_W, SCREEN_H);
	clear_bitmap(page);

	// charger image de fond
	decor = load_bitmap("images/dragon/decor.bmp", NULL);
	if (!decor) {
		allegro_message("pas pu trouver images/dragon/decor.bmp");
		exit(EXIT_FAILURE);
	}

	// Chargement des images des séquences animées
	chargerTabSequences();

	// Initialisation aléatoire des paramètres des acteurs :
	// remplir le tableau avec des acteurs alloués et initialisés
	remplirTabActeurs(mesActeurs);

	// Boucle d'animation (pas d'interaction)
	while (!key[KEY_ESC]) {

		// 1)	EFFACER BUFFER, en appliquant décor	(pas de clear_bitmap)
		blit(decor, page, 0, 0, 0, 0, SCREEN_W, SCREEN_H);

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

// Allouer et initialiser un acteur
t_acteur *creerActeur(int type, int x, int y, int dx, int tmpdx, int tmpimg) {
	// pointeur sur l'acteur qui sera créé (et retourné)
	t_acteur *acteur;

	// Création (allocation)
	acteur = (t_acteur *)malloc(1 * sizeof(t_acteur));

	// Initialisation géométrie et déplacement
	acteur->x = x;
	acteur->y = y;
	acteur->dx = dx;
	acteur->tmpdx = tmpdx;
	acteur->cptdx = 0;
	acteur->tx = tabSequences[type].tx;
	acteur->ty = tabSequences[type].ty;

	// Initialisation séquence d'images de l'animation
	acteur->imgcourante = 0;
	acteur->tmpimg = tmpimg;
	acteur->cptimg = 0;

	// numéro de séquence
	acteur->type = type;

	// on retourne cet acteur fraichement créé
	return acteur;
}

// Pour remplir un tableau avec des acteurs créés
// Sur cet exemple on crée 6 acteurs, chacun associé à une séquence
void remplirTabActeurs(t_acteur *tab[NACTEUR]) {
	// Appeler NACTEUR fois creerActeur avec les paramètres souhaités :
	//								(type,	 x,	 y,	dx, tmpdx, tmpimg )
	tab[0] = creerActeur(0, 500, 0, -5, 1, 5);
	tab[1] = creerActeur(1, 300, 400, 3, 1, 8);
	tab[2] = creerActeur(2, 300, 212, 2, 6, 20);
	tab[3] = creerActeur(3, 100, 122, -3, 1, 8);
	tab[4] = creerActeur(4, 500, 70, 4, 1, 2);
	tab[5] = creerActeur(5, 350, 200, -2, 1, 4);
}

// Actualiser un acteur (bouger ...)
void actualiserActeur(t_acteur *acteur) {

	// gestion des bords "à la pac man"
	// sur cet exemple seulement sur l'axe x (car pas de dy)
	if (acteur->x + acteur->tx < 0)
		acteur->x = SCREEN_W;
	if (acteur->x > SCREEN_W)
		acteur->x = -acteur->tx;

	// calculer nouvelle position
	// nouvelle position = position actuelle + deplacement seulement une fois sur
	// tmpdx sur cet exemple seulement sur l'axe x (car pas de dy)
	acteur->cptdx++;
	if (acteur->cptdx >= acteur->tmpdx) {
		acteur->cptdx = 0;
		acteur->x = acteur->x + acteur->dx;
	}

	// gestion enchainement des images
	// incrémenter imgcourante une fois sur tmpimg
	acteur->cptimg++;
	if (acteur->cptimg >= acteur->tmpimg) {
		acteur->cptimg = 0;
		acteur->imgcourante++;
		// quand l'indice de l'image courante arrive à nimg de la séquence
		// on recommence la séquence à partir de 0
		if (acteur->imgcourante >= tabSequences[acteur->type].nimg)
			acteur->imgcourante = 0;
	}
}

// Gérer l'évolution de l'ensemble des acteurs
void actualiserTabActeurs(t_acteur *tab[NACTEUR]) {
	int i;

	for (i = 0; i < NACTEUR; i++)
		actualiserActeur(tab[i]);
}

// Dessiner un acteur sur une bitmap bmp
void dessinerActeur(BITMAP *bmp, t_acteur *acteur) {
	// Pointeur sur la séquence concernée (prise en compte du type de l'acteur)
	t_sequence *seq;
	seq = &tabSequences[acteur->type];

	//	Prise en compte du numéro d'image courante de l'acteur dans cette séquence
	draw_sprite(bmp, seq->img[acteur->imgcourante], acteur->x, acteur->y);
}

// Dessiner l'ensemble des acteurs sur une bitmap bmp
void dessinerTabActeurs(BITMAP *bmp, t_acteur *tab[NACTEUR]) {
	int i;

	for (i = 0; i < NACTEUR; i++)
		dessinerActeur(bmp, tab[i]);
}

// Charger les images d'une séquence d'animation
// Découpe une image source en plusieurs vignettes
// (doivent être rangées de gauche à droite et de haut en bas)
void chargerSequence(t_sequence *seq) {
	BITMAP *source; // la bitmap qui charge l'image de séquence (temporairement)
	int i;					// indice de l'image dans la séquence
	int ix, iy; // indices (horizontal et vertical) dans le "tableau" des images
	int sx, sy; // coordonnées correspondantes (en pixels)

	// Charger l'image de séquence
	source = load_bitmap(seq->nomSource, NULL);
	if (!source) {
		allegro_message("pas pu trouver %s", seq->nomSource);
		exit(EXIT_FAILURE);
	}

	// Allouer le tableau de pointeur sur les images de l'animation
	seq->img = (BITMAP **)malloc(seq->nimg * sizeof(BITMAP *));

	// Allouer les images de l'animation et les récupérer sur l'image source
	ix = 0;
	iy = 0;
	for (i = 0; i < seq->nimg; i++) {
		// allouer image
		seq->img[i] = create_bitmap(seq->tx, seq->ty);

		// récupérer image
		sx = ix * seq->tx;
		sy = iy * seq->ty;
		blit(source, seq->img[i], sx, sy, 0, 0, seq->tx, seq->ty);

		// préparer indices pour l'image suivante
		ix++;								// colonne suivante
		if (ix >= seq->ncol) // si je suis à droite de la dernière colonne alors...
		{
			ix = 0; // repartir sur la colonne 0
			iy++;	 // à la ligne en dessous
		}
	}

	// On a fini de récupérer séparément chaque étape (image) de l'animation
	// on n'a donc plus besoin de l'image source qui les regroupe
	destroy_bitmap(source);
}

// Charger toutes les séquences du tableau global tabSequence
void chargerTabSequences() {
	int i;

	for (i = 0; i < NSEQUENCE; i++)
		chargerSequence(&tabSequences[i]);
}
