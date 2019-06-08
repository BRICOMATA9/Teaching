/**************************************************************************
	CADRE GENERAL DE GESTION DE LISTES D'ACTEURS EN QUANTITE VARIABLE :
	les structures acteurs sont créées et détruites
	selon les besoins du jeu, des sous-programmes gèrent
	automatiquement l'ajout et le retrait d'acteur du terrain de jeu

	Sur cet exemple les acteurs sont des DISQUES
	qui apparaissent au centre et disparaissent sur les bords
	Appuyer sur entrée pour ajouter un disque par itération
	Appuyer sur espace pour visualiser les emplacements utilisés
	dans le tableau de pointeur de la structure t_listeActeurs

	Le même principe général s'applique
	à des acteurs plus complexes, personnages interactifs, animés...
**************************************************************************/

#include <allegro.h>
#include <time.h>

/**********************/
/*		 STRUCTURES		 */
/**********************/

// chaque acteur qui se déplace
typedef struct acteur {

	// coordonnée (du coin sup. gauche)
	int x, y;

	// vecteur deplacement
	int dx, dy;

	// tailles (rayons des disques)
	int rayon;

	// couleur des disques
	int couleur;

	// vivant :
	//	 0 mort (doit disparaitre de la liste)
	//	 1 vivant
	int vivant;

} t_acteur;

// Une collection de acteurs
typedef struct listeActeurs {
	// nombre maxi d'éléments
	// =taille du tableau de pointeurs
	int max;

	// nombre effectif de pointeurs utilisés
	// (les autres sont à NULL)
	int n;

	// le tableau de pointeurs (alloué dynamiquement)
	t_acteur **tab;

} t_listeActeurs;

/*********************/
/*		 PROTOTYPES		*/
/*********************/

// Allouer et initialiser un acteur
//	 ( à adapter selon besoins )
t_acteur *creerActeur();

// Allouer et initialiser une liste (vide) de acteurs
t_listeActeurs *creerListeActeurs(int maxacteurs);

// Retourne un booléen vrai si il reste de la place
// dans la liste, faux sinon
int libreListeActeurs(t_listeActeurs *la);

// Allouer et ajouter un acteur à la liste
// et retourner l'adresse de ce nouveau acteur
// retourne NULL en cas de problème
t_acteur *ajouterActeur(t_listeActeurs *la);

// Enlever et libèrer un acteur qui était dans la liste en indice i
void enleverActeur(t_listeActeurs *la, int i);

// Actualiser un acteur (bouger ...)
void actualiserActeur(t_acteur *acteur);

// Gérer l'évolution de l'ensemble des acteurs
void actualiserListeActeurs(t_listeActeurs *la);

// Dessiner un acteur sur la bitmap bmp
void dessinerActeur(BITMAP *bmp, t_acteur *acteur);

// Dessiner sur une bitmap l'ensemble des acteurs
void dessinerListeActeurs(BITMAP *bmp, t_listeActeurs *la);

// Dessiner sur une bitmap les cases utilisées par des acteurs
// ( pour visualiser: pas utile dans un programme finalisé )
void dessinerCasesListeActeurs(BITMAP *bmp, t_listeActeurs *la);

/******************************************/
/* PROGRAMME PRINCIPAL										*/
/* initialisation puis boucle d'animation */
/******************************************/

int main() {

	// Buffer
	BITMAP *page;

	// La collection des acteurs
	t_listeActeurs *acteurs;

	// Proba de création de disque (en %)
	int probaNouveau = 15;

	// Il y aura du hasard
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

	// buffer
	page = create_bitmap(SCREEN_W, SCREEN_H);

	// préparer la liste des acteurs (100 maxi)
	// mais vide initialement
	acteurs = creerListeActeurs(100);

	// BOUCLE DE JEU
	while (!key[KEY_ESC]) {
		// effacer buffer
		clear_bitmap(page);

		// ajouter du monde
		// de manière probabiliste (par défaut)
		// ou systématiquement si touche entrée
		if (rand() % 100 < probaNouveau || key[KEY_ENTER])
			ajouterActeur(acteurs);

		// bouger tout le monde
		actualiserListeActeurs(acteurs);

		// afficher tout le monde
		dessinerListeActeurs(page, acteurs);

		// optionnel (pour visualiser ce qui se passe)
		if (key[KEY_SPACE])
			dessinerCasesListeActeurs(page, acteurs);

		// afficher tout ça à l'écran
		blit(page, screen, 0, 0, 0, 0, SCREEN_W, SCREEN_H);

		// petite temporisation
		rest(10);
	}

	return 0;
}
END_OF_MAIN();

/************************************************/
/*		 DEFINITIONS DES SOUS-PROGRAMMES					*/
/************************************************/

// Allouer et initialiser un acteur
t_acteur *creerActeur() {
	t_acteur *nouv;

	// Allouer
	nouv = (t_acteur *)malloc(1 * sizeof(t_acteur));

	// Initialiser ...

	nouv->rayon = rand() % 20 + 20;

	nouv->x = SCREEN_W / 2 - nouv->rayon / 2;
	nouv->y = SCREEN_H / 2 - nouv->rayon / 2;

	do {
		nouv->dx = rand() % 11 - 5;
		nouv->dy = rand() % 11 - 5;
	} while (nouv->dx == 0 && nouv->dy == 0);

	nouv->couleur =
			makecol(rand() % 128 + 128, rand() % 128 + 128, rand() % 128 + 128);

	nouv->vivant = 1;

	// Retourner ce nouveau acteur tout frais
	return nouv;
}

// Actualiser un acteur (bouger, sortie écran ...)
void actualiserActeur(t_acteur *acteur) {

	// deplacement
	acteur->x = acteur->x + acteur->dx;
	acteur->y = acteur->y + acteur->dy;

	// si dépasse un bord alors disparait
	if (acteur->x + 2 * acteur->rayon < 0 || acteur->x > SCREEN_W ||
			acteur->y + 2 * acteur->rayon < 0 || acteur->y > SCREEN_H)
		acteur->vivant = 0;
}

// Dessiner un acteur sur la bitmap bmp
void dessinerActeur(BITMAP *bmp, t_acteur *acteur) {
	circlefill(bmp, acteur->x + acteur->rayon, acteur->y + acteur->rayon,
						 acteur->rayon, acteur->couleur);
}

// Allouer et initialiser une liste (vide) de acteurs
t_listeActeurs *creerListeActeurs(int maxacteurs) {
	t_listeActeurs *nouv;
	int i;

	nouv = (t_listeActeurs *)malloc(1 * sizeof(t_listeActeurs));

	nouv->max = maxacteurs;
	nouv->n = 0;
	nouv->tab = (t_acteur **)malloc(maxacteurs * sizeof(t_acteur *));

	for (i = 0; i < maxacteurs; i++)
		nouv->tab[i] = NULL;

	return nouv;
}

// Retourne un booléen vrai si il reste de la place
// dans la liste, faux sinon
int libreListeActeurs(t_listeActeurs *la) { return la->n < la->max; }

// Allouer et ajouter un acteur à la liste
// et retourner l'adresse de ce nouveau acteur
// retourne NULL en cas de problème
// ( mais il vaut mieux d'abord vérifier qu'il
//	 y a de la place disponible avant d'appeler )
t_acteur *ajouterActeur(t_listeActeurs *la) {
	int i;
	t_acteur *acteur;

	// Liste pleine, on alloue rien et on retourne NULL...
	if (la->n >= la->max)
		return NULL;

	// Allouer un acteur initialisé
	acteur = creerActeur();

	// Chercher un emplacement libre
	i = 0;
	while (la->tab[i] != NULL && i < la->max)
		i++;

	// Si on a trouvé ...
	// (normalement oui car on a vérifié n<max)
	if (i < la->max) {
		// Accrocher le acteur à l'emplacement trouvé
		la->tab[i] = acteur;
		la->n++;
	}
	// Sinon c'est qu'il y a un problème de cohérence
	else
		allegro_message("Anomalie gestion ajouterActeur : liste corrompue");

	return acteur;
}

// Enlever et libèrer un acteur qui était dans la liste en indice i
void enleverActeur(t_listeActeurs *la, int i) {

	// Vérifier qu'il y a bien un acteur accroché en indice i
	if (la->tab[i] != NULL) {
		// libérer la mémoire du acteur
		free(la->tab[i]);

		// marquer l'emplacement comme libre
		la->tab[i] = NULL;
		la->n--;
	}
}

// Gérer l'évolution de l'ensemble des acteurs
void actualiserListeActeurs(t_listeActeurs *la) {
	int i;

	// actualiser chaque acteur
	// si un acteur n'est plus vivant, l'enlever de la liste
	for (i = 0; i < la->max; i++)
		if (la->tab[i] != NULL) {
			actualiserActeur(la->tab[i]);
			if (!la->tab[i]->vivant) {
				enleverActeur(la, i);
			}
		}
}

// Dessiner sur une bitmap l'ensemble des acteurs
void dessinerListeActeurs(BITMAP *bmp, t_listeActeurs *la) {
	int i;

	for (i = 0; i < la->max; i++)
		if (la->tab[i] != NULL)
			dessinerActeur(bmp, la->tab[i]);
}

// Dessiner sur une bitmap les cases utilisées par des acteurs
// ( pour visualiser: pas utile dans un programme finalisé )
void dessinerCasesListeActeurs(BITMAP *bmp, t_listeActeurs *la) {
	int i;

	for (i = 0; i < la->max; i++) {
		textprintf_ex(bmp, font, 8 * i, 0, makecol(255, 255, 255), 0, "%d", i / 10);
		textprintf_ex(bmp, font, 8 * i, 8, makecol(255, 255, 255), 0, "%d", i % 10);
		if (la->tab[i] != NULL)
			rectfill(bmp, 8 * i, 16, 8 * (i + 1), 32, makecol(255, 0, 0));
		else
			rectfill(bmp, 8 * i, 16, 8 * (i + 1), 32, makecol(0, 255, 0));
	}
}
