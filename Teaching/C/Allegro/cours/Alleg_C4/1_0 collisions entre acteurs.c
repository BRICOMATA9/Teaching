/**************************************************************************
COLLISIONS: Détecter collision entre 2 rectangles
						Un des 2 rectangles est positionné sous la souris,
						l'autre est fixe au centre de l'écran

						La collision est signalée par un changement de couleur
**************************************************************************/

#include <allegro.h>
#include <time.h>

/******************************************/
/* PROGRAMME PRINCIPAL										*/
/* initialisation puis boucle de jeu			*/
/******************************************/

int main() {
	// Coordonnées des rectangles

	int x1g = 250, x1d = 550; // rectangle 1 fixe
	int y1h = 220, y1b = 370;

	int x2g, x2d, y2h, y2b;	// rectangle 2 sous la souris
	int t2x = 80, t2y = 120; // largeur hauteur

	int couleur; // couleur pour signaler collision ou pas

	BITMAP *page; // BITMAP buffer d'affichage

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

	// Boucle de jeu
	while (!key[KEY_ESC]) {
		// EFFACER POSITIONs ACTUELLEs SUR LE BUFFER
		clear_bitmap(page);

		// GESTION DEPLACEMENT RECTANGLE 2
		x2g = mouse_x - t2x / 2;
		x2d = x2g + t2x;
		y2h = mouse_y - t2y / 2;
		y2b = y2h + t2y;

		// TEST COLLISION (enregistrer du rouge si collision, sinon du vert)
		if (x1g <= x2d && x2g <= x1d && y1h <= y2b && y2h <= y1b)
			couleur = makecol(255, 0, 0);
		else
			couleur = makecol(0, 255, 0);

		// AFFICHAGE sur buffer

		rectfill(page, x1g, y1h, x1d, y1b, makecol(0, 255, 255));
		rectfill(page, x2g, y2h, x2d, y2b, couleur);

		// AFFICHAGE DU BUFFER MIS A JOUR A L'ECRAN
		blit(page, screen, 0, 0, 0, 0, SCREEN_W, SCREEN_H);

		// ON FAIT UNE PETITE PAUSE
		rest(10);
	}

	return 0;
}
END_OF_MAIN();
