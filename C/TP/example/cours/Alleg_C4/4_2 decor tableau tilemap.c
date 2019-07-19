/**************************************************************************
DECOR TILEMAP: 3 décors successifs construit avec des tuiles
							 à partir d'un tableau de matrices 2D décrivant chaque terrain

							 Appuyer sur une touche pour passer au niveau suivant
**************************************************************************/

#include <allegro.h>

// Pour plus de simplicité : constantes des tuiles utilisées en globale
// ( pour gérer plusieurs ensembles de tuiles il faudrait
//	 mettre ces informations dans une structure ... )

#define NTUILE 6		// Nombre de tuiles graphiques utilisées
#define TXTUILE 100 // Largeur des tuiles
#define TYTUILE 100 // Hauteur des tuiles
#define NCOLTUILE 3 // Nombre de colonnes de tuiles dans le fichier image

#define NXMAP 8 // Nombre de tuiles en largeur sur le terrain
#define NYMAP 6 // Nombre de tuiles en hauteur sur le terrain

#define NTERRAIN 3 // Nombre de niveaux (= écrans de jeu)

// Sur cet exemple on a un seul ensemble de tuiles
// ( on s'autorise une globale, là encore pour simplifier )
BITMAP *tableTuiles;

// 3 terrains de jeu
int tabTerrains[NTERRAIN][NYMAP][NXMAP] = {{
																							 {1, 2, 1, 2, 1, 2, 1, 2},
																							 {2, 0, 3, 3, 3, 3, 0, 1},
																							 {1, 3, 4, 5, 4, 5, 3, 2},
																							 {2, 3, 5, 4, 5, 4, 3, 1},
																							 {1, 0, 3, 3, 3, 3, 0, 2},
																							 {2, 1, 2, 1, 2, 1, 2, 1},
																					 },
																					 {
																							 {4, 5, 4, 5, 4, 5, 4, 5},
																							 {5, 3, 0, 0, 0, 0, 3, 4},
																							 {4, 0, 1, 2, 1, 2, 0, 5},
																							 {5, 0, 2, 1, 2, 1, 0, 4},
																							 {4, 3, 0, 0, 0, 0, 3, 5},
																							 {5, 4, 5, 4, 5, 4, 5, 4},
																					 },
																					 {
																							 {3, 4, 4, 4, 4, 4, 4, 3},
																							 {4, 3, 3, 3, 3, 3, 3, 4},
																							 {4, 3, 5, 5, 5, 5, 3, 4},
																							 {4, 3, 5, 5, 5, 5, 3, 4},
																							 {4, 3, 3, 3, 3, 3, 3, 4},
																							 {3, 4, 4, 4, 4, 4, 4, 3},
																					 }};

/******************************************/
/*				 SOUS-PROGRAMMES								*/
/******************************************/

// Dessine la tuile numéro ituile sur la bitmap bmp au coordonnées xmap ymap
// (unité en nombre de tuiles, pas en pixels)
void dessineTuile(BITMAP *bmp, int ituile, int xmap, int ymap) {
	int lig, col; // ligne et colonne de la tuile source dans tableTuiles

	// Le numéro de ligne et de colonne dans un tableau 2D
	// à partir de l'indice du ième élément (en comptant de gauche à droite
	// et de haut en bas) s'obtiennent avec le quotient et le reste
	// dans la division de l'indice par le nombre de colonnes du tableau
	lig = ituile / NCOLTUILE;
	col = ituile % NCOLTUILE;

	// on copie juste le morceau concerné
	blit(tableTuiles, bmp, col * TXTUILE, lig * TYTUILE, xmap * TXTUILE,
			 ymap * TYTUILE, TXTUILE, TYTUILE);
}

// Dessine un terrain complet sur une bitmap
// (en général on dessinera sur le buffer, ici on utilise directement screen)
void dessineTerrain(BITMAP *bmp, int terrain[NYMAP][NXMAP]) {
	int xmap, ymap;

	for (ymap = 0; ymap < NYMAP; ymap++)
		for (xmap = 0; xmap < NXMAP; xmap++)
			dessineTuile(bmp, terrain[ymap][xmap], xmap, ymap);
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
	int niveau = 0;

	// Lancer allegro et le mode graphique
	allegro_init();
	install_keyboard();

	set_color_depth(desktop_color_depth());
	if (set_gfx_mode(GFX_AUTODETECT_WINDOWED, 800, 600, 0, 0) != 0) {
		allegro_message("prb gfx mode");
		allegro_exit();
		exit(EXIT_FAILURE);
	}

	// Charger le fichier avec les tuiles
	tableTuiles = load_bitmap_check("images/tilemapLaby/tableTuiles.bmp");

	// Boucle de jeu
	while (!key[KEY_ESC]) {
		// Dessiner le terrain d'exemple
		dessineTerrain(screen, tabTerrains[niveau]);
		textprintf_ex(screen, font, 10, 10, makecol(255, 40, 40), 0, "NIVEAU : %d",
									niveau);

		// Attendre une touche
		readkey();

		// Passer au niveau suivant (ou repartir à 0)
		niveau++;
		if (niveau >= NTERRAIN)
			niveau = 0;
	}

	return 0;
}
END_OF_MAIN();
