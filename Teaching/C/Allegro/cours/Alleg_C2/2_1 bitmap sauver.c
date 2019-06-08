/*******************************************************************
BITMAP : Sauver le dessin de l'écran (capture d'écran)

				 Le dessin se fait directement à l'écran
				 (code dérivé de l'exemple 4_0 souris du cours 1)
				 Le fichier sauvé est "capture_ecran.bmp"

				 Une option STORE permet de mémoriser l'état actuel
				 de l'écran et de le résituer avec UNDO
*******************************************************************/

#include <allegro.h>

int main(int argc, char *argv[]) {
	// Image mémoire servant à mémoriser l'écran
	BITMAP *page;

	// tableau pour les boutons de choix de couleurs
	int couleurs[5];

	// tableau pour les noms sur les boutons de l'interface
	char *noms[10] = {"",			"",			"",		 "",		 "",
										"CLEAR", "STORE", "UNDO", "SAVE", "EXIT"};

	int fin, ymenu, couleur;

	// Lancer allegro et le mode graphique
	allegro_init();
	install_mouse();
	install_keyboard();

	set_color_depth(desktop_color_depth());
	if (set_gfx_mode(GFX_AUTODETECT_WINDOWED, 800, 600, 0, 0) != 0) {
		allegro_message("prb gfx mode");
		allegro_exit();
		exit(EXIT_FAILURE);
	}

	show_mouse(screen);

	// déterminer les couleurs de la palette du menu
	couleurs[0] = makecol(0, 0, 0);
	couleurs[1] = makecol(255, 255, 255);
	couleurs[2] = makecol(255, 0, 0);
	couleurs[3] = makecol(0, 255, 0);
	couleurs[4] = makecol(0, 0, 255);

	// dessiner les zones de l'interface en haut à gauche de l'écran
	for (ymenu = 0; ymenu < 10; ymenu++) {
		if (ymenu < 5)
			rectfill(screen, 0, ymenu * 40, 79, ymenu * 40 + 39, couleurs[ymenu]);
		rect(screen, 0, ymenu * 40, 79, ymenu * 40 + 39, makecol(255, 255, 255));
		textprintf_ex(screen, font, 20, ymenu * 40 + 16, makecol(255, 255, 255), -1,
									noms[ymenu]);
	}

	// couleur initiale : blanc
	couleur = makecol(255, 255, 255);

	// Création de l'image mémoire à la taille de l'écran
	page = create_bitmap(SCREEN_W, SCREEN_H);

	// Boucle interactive
	fin = 0;
	while (!fin) {
		// si clic gauche...
		if (mouse_b & 1) {
			// si je suis dans le menu...
			if (mouse_x < 80 && mouse_y < 10 * 40) {
				ymenu = mouse_y / 40;
				switch (ymenu) {
				// CHOIX D'UNE COULEUR
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
					couleur = couleurs[ymenu];
					break;

				// CLEAR : effacer partie droite de l'écran (pas le menu !)
				case 5:
					rectfill(screen, 80, 0, SCREEN_W - 1, SCREEN_H - 1, makecol(0, 0, 0));
					break;

				// STORE : copie de l'écran sur la page mémoire
				case 6:
					blit(screen, page, 0, 0, 0, 0, SCREEN_W, SCREEN_H);
					break;

				// UNDO : copie de la page mémoire sur l'écran
				case 7:
					blit(page, screen, 0, 0, 0, 0, SCREEN_W, SCREEN_H);
					break;

				// SAVE : copie de l'écran sur la page mémoire
				//				puis sauvegarde de la page dans un fichier .bmp
				case 8:
					blit(screen, page, 0, 0, 0, 0, SCREEN_W, SCREEN_H);
					save_bitmap("capture.bmp", page, NULL);
					break;

				// EXIT : indiquer de terminer la boucle interactive (fin programme)
				case 9:
					fin = 1;
					break;
				}

				// tant que je reste appuyé sur le bouton souris rester bloqué ici
				while (mouse_b & 1)
					;
			}

			// si je ne suis pas dans le menu alors je pose la couleur active
			else
				circlefill(screen, mouse_x, mouse_y, 15, couleur);

		} // Fin de test	if (mouse_b & 1)

		if (key[KEY_ESC])
			fin = 1;

	} // Fin de boucle interactive

	return 0;
}
END_OF_MAIN();
