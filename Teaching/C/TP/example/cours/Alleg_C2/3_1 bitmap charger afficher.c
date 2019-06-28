/*******************************************************************
BITMAP : Charger une image depuis un fichier .bmp vers une BITMAP
				 et afficher cette BITMAP au milieu de l'écran
				 puis animer cette image (effacer ancienne position...)

				 L'image s'apppelle "mon_image.bmp" et doit être mise
				 au niveau du répertoire de projet (avec le main.c)
				 à moins de modifier le chemin d'accès ci dessous...
*******************************************************************/

#include <allegro.h>

int main() {
	// Déclaration du pointeur sur BITMAP devant recevoir l'image
	BITMAP *image;

	// paramètres de l'élément à animer
	int posx, posy; // coordonnées
	int tx, ty;		 // taille (largeur et hauteur)
	int depx, depy; // vecteur déplacement effectif en x et y

	// Lancer allegro et le mode graphique
	allegro_init();
	install_keyboard();

	set_color_depth(desktop_color_depth());
	if (set_gfx_mode(GFX_AUTODETECT_WINDOWED, 800, 600, 0, 0) != 0) {
		allegro_message("prb gfx mode");
		allegro_exit();
		exit(EXIT_FAILURE);
	}

	// Chargement de l'image (l'allocation a lieu en même temps)
	image = load_bitmap("mon_image.bmp", NULL);
	if (!image) {
		allegro_message("pas pu trouver/charger mon_image.bmp");
		allegro_exit();
		exit(EXIT_FAILURE);
	}

	// Initialisation des paramètres de l'élément à animer

	// La taille est directement récupérée dans les champs w et h
	tx = image->w;
	ty = image->h;

	// Position initiale au centre
	posx = SCREEN_W / 2 - tx / 2;
	posy = SCREEN_H / 2 - ty / 2;

	// mouvements vers la droite et vers le bas
	// on pourrait initialiser aléatoirement ici...
	depx = 9;
	depy = 5;

	// Boucle d'animation (pas d'interaction)
	while (!key[KEY_ESC]) {
		// 1) EFFACER POSITION ACTUELLE (redessiner à la couleur du fond)
		rectfill(screen, posx, posy, posx + tx, posy + ty, makecol(0, 0, 0));

		// 2) DETERMINER NOUVELLE POSITION

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
		//		On blit l'image en position posx posy
		blit(image, screen, 0, 0, posx, posy, tx, ty);

		// 4) ON FAIT UNE PETITE PAUSE à chaque fois sinon ça va trop vite...
		rest(20);
	}

	return 0;
}
END_OF_MAIN();
