/*************************************************************
Utilisation du clavier : scancodes = état instantané touches
*************************************************************/

#include <allegro.h>
#include <time.h>

// Fonction générant une couleur aléatoire
int couleur_alea() { return makecol(rand() % 256, rand() % 256, rand() % 256); }

int main(int argc, char *argv[]) {
	srand(time(NULL));

	allegro_init();

	// pour disposer du clavier
	install_keyboard();

	set_color_depth(desktop_color_depth());
	if (set_gfx_mode(GFX_AUTODETECT_WINDOWED, 800, 600, 0, 0) != 0) {
		allegro_message("prb gfx mode");
		allegro_exit();
		exit(EXIT_FAILURE);
	}

	// Boucle intéractive : on continue la boucle
	//		tant que ( PAS touche Echap appuyée )
	while (!key[KEY_ESC]) {

		// Affichage état de la touche ESPACE
		if (key[KEY_SPACE])
			textprintf_ex(screen, font, 360, 300, makecol(255, 255, 0),
										makecol(0, 0, 0), "	ESPACE	");
		else
			textprintf_ex(screen, font, 360, 300, makecol(0, 255, 255),
										makecol(0, 0, 0), "PAS ESPACE");

		// Si touche EFFACER alors effacer écran
		if (key[KEY_BACKSPACE])
			clear_bitmap(screen);

		// Si touche haut/bas/gauche/droite ajouter un disques en position
		// correspondante
		if (key[KEY_UP])
			circlefill(screen, 300 + rand() % 200, 0 + rand() % 200, 20,
								 couleur_alea());
		if (key[KEY_DOWN])
			circlefill(screen, 300 + rand() % 200, 400 + rand() % 200, 20,
								 couleur_alea());
		if (key[KEY_LEFT])
			circlefill(screen, 0 + rand() % 200, 200 + rand() % 200, 20,
								 couleur_alea());
		if (key[KEY_RIGHT])
			circlefill(screen, 600 + rand() % 200, 200 + rand() % 200, 20,
								 couleur_alea());
	}

	return 0;
}
END_OF_MAIN();
