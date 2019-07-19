/********************************************************
1ers exemples d'affichage graphique et du texte...
********************************************************/

#include <allegro.h>

int main(int argc, char *argv[]) {
	int couleur;
	int i;

	allegro_init();
	install_keyboard();

	set_color_depth(desktop_color_depth());
	if (set_gfx_mode(GFX_AUTODETECT_WINDOWED, 800, 600, 0, 0) != 0) {
		allegro_message("prb gfx mode");
		allegro_exit();
		exit(EXIT_FAILURE);
	}

	// Avoir une couleur (ici du blanc)
	couleur = makecol(255, 255, 255);

	// afficher du texte (couleur=blanc)
	textprintf_ex(screen, font, 250, 50, couleur, -1,
								"BONJOUR MONDE GRAPHIQUE !");

	// Rectangle contour (couleur=blanc)
	rect(screen, 100, 100, 200, 200, couleur);

	// Rectangle plein (rouge couleur directe)
	rectfill(screen, 300, 100, 400, 200, makecol(255, 0, 0));

	// deux lignes diagonales (jaune et violet)
	line(screen, 500, 100, 600, 200, makecol(255, 255, 0));
	line(screen, 600, 100, 500, 200, makecol(255, 0, 255));

	// Cercle contour (vert)
	circle(screen, 150, 300, 50, makecol(0, 255, 0));

	// Cercle plein (bleu)
	circlefill(screen, 350, 300, 50, makecol(0, 0, 255));

	// Ellipse pleine (cyan)
	ellipsefill(screen, 550, 300, 75, 25, makecol(0, 255, 255));

	// Dégradé avec des lignes du noir au blanc
	for (i = 0; i < 256; i++) {
		couleur = makecol(i, i, i); // gris proportionnel à i
		line(screen, 250 + i, 400, 250 + i, 500, couleur);
	}

	readkey();

	return 0;
}
END_OF_MAIN();
