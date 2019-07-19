/*******************************************************************
Utilisation du clavier pour bouger un élément graphique (rectangle)
*******************************************************************/

#include <allegro.h>

int main() {

	// paramètres de l'élément à animer
	int posx, posy;	// coordonnées
	int tx, ty;			// taille (largeur et hauteur)
	int depx, depy;	// vecteur déplacement effectif en x et y
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
	// se déplacera de 5 pixels à chaque étape
	// initialement immobile
	deplacement = 5;
	depx = 0;
	depy = 0;

	// Boucle interactive
	while (!key[KEY_ESC]) {
		// 1) EFFACER POSITION ACTUELLE (redessiner à la couleur du fond)
		rectfill(screen, posx, posy, posx + tx, posy + ty, makecol(0, 0, 0));

		// 2) DETERMINER NOUVELLE POSITION

		// prise en compte du clavier sur le vecteur deplacement depx et depy
		if (key[KEY_UP]) {
			depx = 0;
			depy = -deplacement; // mouvement négatif en ordonnées
		}
		if (key[KEY_DOWN]) {
			depx = 0;
			depy = deplacement; // mouvement positif en ordonnées
		}
		if (key[KEY_LEFT]) {
			depx = -deplacement; // mouvement négatif en abscisses
			depy = 0;
		}
		if (key[KEY_RIGHT]) {
			depx = deplacement; // mouvement positif en abscisses
			depy = 0;
		}
		// si espace alors mouvement aléatoire ...
		if (key[KEY_SPACE]) {
			depx = rand() % (deplacement * 2 + 1) - deplacement;
			depy = rand() % (deplacement * 2 + 1) - deplacement;
		}

		// contrôle des bords : ici on décide de rebondir sur les bords
		if ((posx < 0 && depx < 0) || (posx + tx > SCREEN_W && depx > 0))
			depx = -depx;
		if ((posy < 0 && depy < 0) || (posy + ty > SCREEN_H && depy > 0))
			depy = -depy;

		// calculer nouvelle position
		// nouvelle position = position actuelle + deplacement
		posx = posx + depx;
		posy = posy + depy;

		// 3) AFFICHAGE NOUVELLE POSITION
		rectfill(screen, posx, posy, posx + tx, posy + ty, makecol(255, 128, 128));
		if (depx >= 0)
			circlefill(screen, posx + tx - 12, posy + 12, 6, makecol(0, 128, 128));
		else
			circlefill(screen, posx + 12, posy + 12, 6, makecol(0, 128, 128));

		// 4) ON FAIT UNE PETITE PAUSE à chaque fois sinon ça va trop vite...
		rest(20);
	}

	return 0;
}
END_OF_MAIN();
