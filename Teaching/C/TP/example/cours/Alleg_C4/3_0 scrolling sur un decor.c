/**************************************************************************
DECOR SCROLLING:
						Déplacement de l'écran sur un décor plus grand.
						en fait ce sont les coordonnées d'affichage du décor
						qui sont modifiées à l'écran...
						On se déplace avec les flèches du clavier

						Les deux variables à surveiller de près dans ce programme
						sont screenx et screeny qui sont les coordonnées de l'écran
						(fenêtre visible) dans le repère du décor.

						Il faut modifier le blit du décors sur le buffer

**************************************************************************/

#include <allegro.h>

// Chargement "sécurisé" d'une image :
// interrompt le programme avec un message si problème...
BITMAP *load_bitmap_check(char *nomImage) {
	BITMAP *bmp;
	bmp = load_bitmap(nomImage, NULL);
	if (!bmp) {
		allegro_message("pas pu trouver %s", nomImage);
		exit(EXIT_FAILURE);
	}
	return bmp;
}

/******************************************/
/* PROGRAMME PRINCIPAL										*/
/* initialisation puis boucle de jeu			*/
/******************************************/

int main() {

	BITMAP *page;				 // BITMAP buffer d'affichage
	BITMAP *decor;				// Image de fond, seulement pour visualiser
	int screenx, screeny; // Position de l'écran réel dans le repère du décor...

	// Lancer allegro et le mode graphique
	allegro_init();
	install_keyboard();

	set_color_depth(desktop_color_depth());
	if (set_gfx_mode(GFX_AUTODETECT_WINDOWED, 640, 480, 0, 0) != 0) {
		allegro_message("prb gfx mode");
		allegro_exit();
		exit(EXIT_FAILURE);
	}

	// CREATION DU BUFFER D'AFFICHAGE à la taille de l'écran
	page = create_bitmap(SCREEN_W, SCREEN_H);
	clear_bitmap(page);

	// charger image de fond
	decor = load_bitmap_check("images/grandfond_decor.bmp");

	// Ici initialisation du scrolling en haut à gauche du décor
	//	(on peut décider de partir autrement...)
	screenx = 0;
	screeny = 0;

	// Boucle de jeu
	while (!key[KEY_ESC]) {
		// GESTION DU SCROLLING AU CLAVIER (Touches de direction)
		if (key[KEY_RIGHT])
			screenx += 5;
		if (key[KEY_LEFT])
			screenx -= 5;
		if (key[KEY_DOWN])
			screeny += 5;
		if (key[KEY_UP])
			screeny -= 5;

		// Bloquer le scrolling si il est ammené trop loin !
		if (screenx < 0)
			screenx = 0;
		if (screenx > decor->w - SCREEN_W)
			screenx = decor->w - SCREEN_W;
		if (screeny < 0)
			screeny = 0;
		if (screeny > decor->h - SCREEN_H)
			screeny = decor->h - SCREEN_H;

		// EFFACER BUFFER EN APPLIQUANT UNE PARTIE DU DECOR (TAILLE DE L'ECRAN)
		blit(decor, page, screenx, screeny, 0, 0, SCREEN_W, SCREEN_H);

		// ANIMER DES CHOSES... (ici rien)

		// AFFICHAGE NOUVELLEs POSITIONs SUR LE BUFFER
		// ici pour illustrer on se contente juste de graphismes simples

		// Affichages ancrés au décor :
		// un changement de repère est nécessaire
		// (soustraire screenx screeny à toutes les coordonnées)
		circlefill(page, 540 - screenx, 50 - screeny, 25, makecol(255, 128, 128));
		textprintf_centre_ex(page, font, 540 - screenx, 100 - screeny,
												 makecol(255, 255, 255), -1, "AFFICHAGE FIXE AU DECOR");

		// Affichages ancrés à l'écran réel : pas de prise en compte de screenx et
		// screeny
		circlefill(page, 100, 50, 25, makecol(128, 255, 128));
		textprintf_centre_ex(page, font, 100, 100, makecol(255, 255, 255), -1,
												 "AFFICHAGE FIXE A L'ECRAN");
		textprintf_centre_ex(page, font, 320, 10, makecol(255, 255, 255), -1,
												 "APPUYER SUR LES FLECHES POUR SCROLLER");

		// AFFICHAGE DU BUFFER MIS A JOUR A L'ECRAN
		blit(page, screen, 0, 0, 0, 0, SCREEN_W, SCREEN_H);

		// ON FAIT UNE PETITE PAUSE
		rest(10);
	}

	return 0;
}
END_OF_MAIN();
