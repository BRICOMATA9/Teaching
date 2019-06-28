/**************************************************************************
ANIMATION : une primitive graphique (disque) et une image (.bmp chargé)
						bougent ensemble à l'écran (rebonds sur les bords)

						2ème version : avec double buffer (pas de clignotement)
**************************************************************************/

#include <allegro.h>

int main() {
	// BITMAP servant de buffer d'affichage
	BITMAP *page;

	// BITMAP devant recevoir l'image
	BITMAP *image;

	// paramètres de l'élément 1 à animer (disque)
	int posx1, posy1; // coordonnées
	int rayon1;			 // taille (rayon du disque)
	int depx1, depy1; // vecteur déplacement effectif en x et y

	// paramètres de l'élément 2 à animer (image)
	int posx2, posy2; // coordonnées
	int tx2, ty2;		 // taille (largeur et hauteur)
	int depx2, depy2; // vecteur déplacement effectif en x et y

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

	// Chargement de l'image
	image = load_bitmap("earth.bmp", NULL);
	if (!image) {
		allegro_message("pas pu trouver/charger earth.bmp");
		allegro_exit();
		exit(EXIT_FAILURE);
	}

	// Initialisation des paramètres de l'élément 1
	rayon1 = 40;
	posx1 = rayon1;
	posy1 = rayon1;
	depx1 = 5;
	depy1 = 9;

	// Initialisation des paramètres de l'élément 2
	tx2 = image->w;
	ty2 = image->h;
	posx2 = SCREEN_W / 2 - tx2 / 2;
	posy2 = SCREEN_H / 2 - ty2 / 2;
	depx2 = 9;
	depy2 = 5;

	// Boucle d'animation (pas d'interaction)
	while (!key[KEY_ESC]) {
		// 1) EFFACER POSITIONs ACTUELLEs SUR LE BUFFER
		//		ON EFFACE TOUT LE BUFFER ! (c'est plus simple)
		clear_bitmap(page);

		// 2) DETERMINER NOUVELLEs POSITIONs

		// contrôle des bords : ici on décide de rebondir sur les bords
		if ((posx1 - rayon1 < 0 && depx1 < 0) ||
				(posx1 + rayon1 > SCREEN_W && depx1 > 0))
			depx1 = -depx1;
		if ((posy1 - rayon1 < 0 && depy1 < 0) ||
				(posy1 + rayon1 > SCREEN_H && depy1 > 0))
			depy1 = -depy1;

		if ((posx2 < 0 && depx2 < 0) || (posx2 + tx2 > SCREEN_W && depx2 > 0))
			depx2 = -depx2;
		if ((posy2 < 0 && depy2 < 0) || (posy2 + ty2 > SCREEN_H && depy2 > 0))
			depy2 = -depy2;

		// calculer nouvelles positions
		// nouvelle position = position actuelle + deplacement
		posx1 = posx1 + depx1;
		posy1 = posy1 + depy1;

		posx2 = posx2 + depx2;
		posy2 = posy2 + depy2;

		// 3) AFFICHAGE NOUVELLEs POSITIONs SUR LE BUFFER
		//		ON UTILISE page AU LIEU DE screen
		blit(image, page, 0, 0, posx2, posy2, tx2, ty2); // astuce : image en 1er...
		circlefill(page, posx1, posy1, rayon1, makecol(200, 255, 200));

		// 4) AFFICHAGE DU BUFFER MIS A JOUR A L'ECRAN
		//		le nouveau contenu graphique remplace l'ancien
		//		sans que l'ancien ait été effacé à l'écran (pas de clignotement)
		blit(page, screen, 0, 0, 0, 0, SCREEN_W, SCREEN_H);

		// 5) ON FAIT UNE PETITE PAUSE à chaque fois sinon ça va trop vite...
		rest(20);
	}

	return 0;
}
END_OF_MAIN();
