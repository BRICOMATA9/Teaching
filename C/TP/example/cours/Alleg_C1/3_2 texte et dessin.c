/********************************************************
1ers exemples d'affichage graphique et du texte...
********************************************************/

#include <allegro.h>
#include <time.h>

int main(int argc, char *argv[]) {
	int c, x, y, tx, ty;

	// Initialiser le générateur aléatoire (si utilisation de rand)
	srand(time(NULL));

	// Pour disposer des caractères ascii étendus (avec accents)
	set_uformat(U_ASCII);

	allegro_init();
	install_keyboard();

	set_color_depth(desktop_color_depth());
	if (set_gfx_mode(GFX_AUTODETECT_WINDOWED, 800, 600, 0, 0) != 0) {
		allegro_message("prb gfx mode");
		allegro_exit();
		exit(EXIT_FAILURE);
	}

	// Avoir une couleur (ici du blanc)
	c = makecol(255, 255, 255);

	// afficher du texte avec accents
	// attention pas de \n : pour un retour ligne afficher avec ordonnées plus
	// grandes !
	textprintf_ex(screen, font, 40, 70, c, -1, "Accents éèàùïôê ?");
	textprintf_ex(screen, font, 40, 85, c, -1,
								"Grâce à l'appel à set_uformat(U_ASCII) au début");
	textprintf_ex(screen, font, 40, 120, c, -1, "Affichage de valeurs : 3+4=%d",
								3 + 4);
	textprintf_ex(screen, font, 40, 135, c, -1, "Résolution graphique : %dx%d",
								SCREEN_W, SCREEN_H);

	// On affiche du texte où on veut quand on veut...
	c = makecol(255, 0, 255);
	textprintf_ex(screen, font, 550, 20, c, -1, "ici");
	textprintf_ex(screen, font, 500, 100, c, -1, "là");
	textprintf_ex(screen, font, 630, 60, c, -1, "ailleurs");

	readkey();

	// test rect et cercle, remplis ou contours
	while (!keypressed()) {
		y = 250 + rand() % (SCREEN_H - 400);
		x = rand() % SCREEN_W;
		tx = rand() % 100;
		ty = rand() % 100;
		c = makecol(rand() % 256, rand() % 256, rand() % 256);
		switch (rand() % 4) {
		case 0:
			rect(screen, x, y, x + tx, y + ty, c);
			break;
		case 1:
			rectfill(screen, x, y, x + tx, y + ty, c);
			break;
		case 2:
			circle(screen, x, y, tx, c);
			break;
		case 3:
			circlefill(screen, x, y, tx / 3, c);
			break;
		}
		rest(100);
	}

	return 0;
}
END_OF_MAIN();
