/*******************************************************************
Utilisation du clavier pour bouger un élément graphique (rectangle)
*******************************************************************/

#include <allegro.h>

int main() {

	// paramètres de l'élément à animer
	int posx, posy;	// coordonnées
	int tx, ty;			// taille (largeur et hauteur)
	int deplacement; // amplitude absolu des déplacements

	srand(time(NULL));

	allegro_init();
	install_keyboard();

	set_color_depth(desktop_color_depth());
	if (set_gfx_mode(GFX_AUTODETECT_WINDOWED, 800, 600, 0, 0) != 0) {
		allegro_message("prb gfx mode");
		allegro_exit();
		exit(EXIT_FAILURE);
	}

	// initialisation des variables de la forme

	// tailles et position initiale au centre
	tx = 60;
	ty = 40;
	posx = SCREEN_W / 2 - tx / 2;
	posy = SCREEN_H / 2 - ty / 2;

	// mouvements :
	// se déplacera de 5 pixels à chaque étape de déplacement
	deplacement = 5;

	// Boucle interactive
	while (!key[KEY_ESC]) {

		// 1) EFFACER POSITION ACTUELLE (redessiner à la couleur du fond)

		rectfill(screen, posx, posy, posx + tx, posy + ty, makecol(0, 0, 0));

		// 2) DETERMINER NOUVELLE POSITION

		// prise en compte du clavier : deplacement direct de la position
		if (key[KEY_UP])
			posy = posy - deplacement; // mouvement négatif en ordonnées
		if (key[KEY_DOWN])
			posy = posy + deplacement; // mouvement positif en ordonnées
		if (key[KEY_LEFT])
			posx = posx - deplacement; // mouvement négatif en abscisses
		if (key[KEY_RIGHT])
			posx = posx + deplacement; // mouvement positif en abscisses

		// contrôle des bords
		if (posx + tx < 0)
			posx = SCREEN_W + posx + tx;
		if (posx >= SCREEN_W)
			posx = posx - SCREEN_W - tx;
		if (posy + ty < 0)
			posy = SCREEN_H + posy + ty;
		if (posy >= SCREEN_H)
			posy = posy - SCREEN_H - ty;

		// 3) AFFICHAGE NOUVELLE POSITION
		rectfill(screen, posx, posy, posx + tx, posy + ty, makecol(255, 128, 128));

		// 4) ON FAIT UNE PETITE PAUSE à chaque fois sinon ça va trop vite...
		rest(20);
	}

	return 0;
}
END_OF_MAIN();
