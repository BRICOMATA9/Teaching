/********************************************************
1ers exemples d'affichage graphique et du texte...
********************************************************/

#include <allegro.h>

int main(int argc, char *argv[]) {
	int couleur;

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

	// afficher du texte coin supérieur gauche en x=40 y=20 (couleur=blanc)
	textprintf_ex(screen, font, 40, 20, couleur, -1, "BONJOUR MONDE GRAPHIQUE !");

	// cercle plein de centre x=400 y=300 rayon=180 (couleur=blanc)
	circlefill(screen, 400, 300, 180, couleur);

	readkey();

	return 0;
}
END_OF_MAIN();
