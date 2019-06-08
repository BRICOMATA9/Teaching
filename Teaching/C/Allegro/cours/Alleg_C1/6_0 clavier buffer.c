/*************************************************************
Utilisation du clavier : buffer = comme en console avec getch
*************************************************************/

#include <allegro.h>

int main(int argc, char *argv[]) {
	int touche;
	char carac;
	int fin;
	int poscarac;

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

	// A compléter si l'objectif est de saisir une chaine
	// (enregistrer les caractères, position curseur mobile, effacer...)
	poscarac = 0;
	fin = 0;
	while (!fin) {

		// keypressed() : équivalent allegro du kbhit()
		if (keypressed()) {
			// récupérer la touche avec readkey() : équivalent allegro du getch()
			touche = readkey();

			// a partir de l'info de touche on obtient le caractère en castant en char
			carac = (char)touche;

			// afficher le caractère toujours à la même position
			textprintf_ex(screen, font, 400, 60, makecol(255, 255, 255),
										makecol(0, 0, 0), "%c", carac);

			// afficher le caractère à une position x croissante
			textprintf_ex(screen, font, 400 + poscarac, 100, makecol(255, 255, 255),
										makecol(0, 0, 0), "%c", carac);
			poscarac = poscarac + 8;

			// Terminer le programme à la validation...
			// le retour chariot n'est pas \n mais \r
			if (carac == '\r')
				fin = 1;
		}
	}

	return 0;
}
END_OF_MAIN();
