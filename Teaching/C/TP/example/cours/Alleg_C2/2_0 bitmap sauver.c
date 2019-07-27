/*******************************************************************
BITMAP : Sauver le dessin d'une BITMAP dans un fichier .bmp
				 Le dessin se fait dans un sous-programme qui reçoit
				 le pointeur de la BITMAP en paramètre
*******************************************************************/

#include <allegro.h>

// Dessiner sur un BITMAP reçu en paramètre (par adresse)
void dessiner(BITMAP *bmp) {
	// Cercle blanc au centre
	circle(bmp, 200, 100, 50, makecol(255, 255, 255));

	// Disques violets dans les coins
	circlefill(bmp, 0, 0, 50, makecol(100, 50, 100));
	circlefill(bmp, 399, 0, 50, makecol(100, 50, 100));
	circlefill(bmp, 0, 199, 50, makecol(100, 50, 100));
	circlefill(bmp, 399, 199, 50, makecol(100, 50, 100));

	// Lignes rouges et vertes en diagonales
	line(bmp, 0, 0, 399, 199, makecol(255, 0, 0));
	line(bmp, 399, 0, 0, 199, makecol(0, 255, 0));

	// Un peu de texte centré
	textprintf_centre_ex(bmp, font, 200, 0, makecol(255, 255, 255), -1,
											 "BITMAP A SAUVER");
}

int main() {
	// Déclaration d'un pointeur sur une structure BITMAP
	BITMAP *bmp;

	// Diverses variables...
	int fin, verif;

	// Lancer allegro et le mode graphique
	allegro_init();
	install_keyboard();

	set_color_depth(desktop_color_depth());
	if (set_gfx_mode(GFX_AUTODETECT_WINDOWED, 800, 600, 0, 0) != 0) {
		allegro_message("prb gfx mode");
		allegro_exit();
		exit(EXIT_FAILURE);
	}

	// Allocation dynamique d'une structure BITMAP de 400 par 200
	bmp = create_bitmap(400, 200);

	// Effacer contenu éventuel qui traine en mémoire
	clear_bitmap(bmp);

	// DESSINER DANS LA BITMAP... en appelant un sous programme
	dessiner(bmp);

	// Affichage de la Bitmap sur l'écran au milieu
	blit(bmp, screen, 0, 0, (SCREEN_W - bmp->w) / 2, (SCREEN_H - bmp->h) / 2,
			 bmp->w, bmp->h);

	// Texte affiché à l'écran (screen) : ne sera pas sauvé
	textprintf_ex(screen, font, 200, 0, makecol(255, 255, 255), -1,
								"VOULEZ VOUS SAUVER	ma_bitmap.bmp	Oui/Verifier/Non ?");

	// boucle d'événements
	fin = 0;
	while (!fin) {
		// si OUI (touche O) sauver la BITMAP sans vérifier que c'est OK
		if (key[KEY_O]) {
			save_bitmap("ma_bitmap.bmp", bmp, NULL);
			fin = 1;
		}

		// si VERIFIER (touche V) sauver la BITMAP et vérifier que c'est OK
		if (key[KEY_V]) {
			verif = save_bitmap("ma_bitmap.bmp", bmp, NULL);
			if (verif != 0)
				allegro_message("Votre image n'a pas pu etre sauvee");
			else {
				allegro_message("Votre image a bien ete sauvee");
				fin = 1;
			}
		}

		// si NON (touche N) ou Echap alors sortir
		if (key[KEY_N] || key[KEY_ESC])
			fin = 1;
	}

	// libérer la mémoire de la BITMAP quand on ne l'utilise plus (à la fin)
	destroy_bitmap(bmp);

	return 0;
}
END_OF_MAIN();
