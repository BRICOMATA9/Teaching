/**************************************************************************
SPRITES : un sprite est une petite image
					correspondant à un élément graphique dynamique
					souvent affichée sur un fond avec des parties transparentes

					ce programme illustre différentes options d'affichage sur un fond
					et avec un avant plan
**************************************************************************/

#include <allegro.h>
#include <math.h>

// 8 exemples d'utilisation des sprites ...
#define NEXEMPLES 8

int main() {

	// BITMAP servant de buffer d'affichage (double buffer)
	BITMAP *page;

	// Image de fond
	BITMAP *decor;

	// Image d'avant plan
	BITMAP *avantplan;

	// Image de sprite sans transparence
	BITMAP *sprite_solide;

	// Image de sprite avec transparence
	BITMAP *sprite_transp;

	// Pour faire un peu de maths
	int i, x[NEXEMPLES], y[NEXEMPLES];
	float phase = 0, alpha = 2.0 * M_PI / NEXEMPLES, radius = 250.0;
	float echelle;

	// Lancer allegro et le mode graphique
	allegro_init();
	install_keyboard();

	set_color_depth(desktop_color_depth());
	if (set_gfx_mode(GFX_AUTODETECT_WINDOWED, 800, 600, 0, 0) != 0) {
		allegro_message("prb gfx mode");
		allegro_exit();
		exit(EXIT_FAILURE);
	}

	// CREATION DU BUFFER D'AFFICHAGE à la taille de l'écran
	page = create_bitmap(SCREEN_W, SCREEN_H);
	clear_bitmap(page);

	// charger image de fond
	decor = load_bitmap("images/hotplanet.bmp", NULL);
	if (!decor) {
		allegro_message("pas pu trouver images/hotplanet.bmp");
		exit(EXIT_FAILURE);
	}

	// charger image d'avant plan
	avantplan = load_bitmap("images/cockpit.bmp", NULL);
	if (!avantplan) {
		allegro_message("pas pu trouver images/cockpit.bmp");
		exit(EXIT_FAILURE);
	}

	// charger image de sprite sans transparence
	sprite_solide = load_bitmap("images/spaceship_sansmasque.bmp", NULL);
	if (!sprite_solide) {
		allegro_message("pas pu trouver images/spaceship_sansmasque.bmp");
		exit(EXIT_FAILURE);
	};

	// charger image de sprite avec transparence
	sprite_transp = load_bitmap("images/spaceship.bmp", NULL);
	if (!sprite_transp) {
		allegro_message("pas pu trouver images/spaceship.bmp");
		exit(EXIT_FAILURE);
	};

	// Boucle d'animation (pas d'interaction)
	while (!key[KEY_ESC]) {
		// effacer buffer en appliquant décor	(pas de clear_bitmap)
		blit(decor, page, 0, 0, 0, 0, SCREEN_W, SCREEN_H);

		// déterminer positions des exemples (et afficher indice à la position)
		// coordonnées polaires -> cartesien
		for (i = 0; i < NEXEMPLES; i++) {
			x[i] =
					SCREEN_W / 2 - sprite_transp->w / 2 + radius * cos(phase + alpha * i);
			y[i] =
					SCREEN_H / 2 - sprite_transp->h / 2 + radius * sin(phase + alpha * i);

			textprintf_ex(page, font, x[i] - 16, y[i] - 8, makecol(255, 255, 255), -1,
										"%d", i);
		}

		// faire avancer tout ça (pour la prochaine itération)
		phase += M_PI / 1000;

		// Affichages utilisant différentes techniques de blit et de draw_sprite

		// 0 simple blit d'une image sans info de transparence
		blit(sprite_solide, page, 0, 0, x[0], y[0], sprite_solide->w,
				 sprite_solide->h);

		// 1 simple blit d'une image avec info de transparence (transparence non
		// prise en compte)
		blit(sprite_transp, page, 0, 0, x[1], y[1], sprite_transp->w,
				 sprite_transp->h);

		// 2 draw_sprite d'une image sans info de transparence
		draw_sprite(page, sprite_solide, x[2], y[2]);

		// 3 draw_sprite d'une image avec info de transparence
		draw_sprite(page, sprite_transp, x[3], y[3]);

		// 4 draw_sprite renversé verticalement
		draw_sprite_v_flip(page, sprite_transp, x[4], y[4]);

		// 5 draw_sprite renversé horizontalement
		draw_sprite_h_flip(page, sprite_transp, x[5], y[5]);

		// 6 draw_sprite avec mise à l'échelle (anamorphose)
		stretch_sprite(page, sprite_transp, x[6], y[6], 0.5 * sprite_transp->w,
									 0.75 * sprite_transp->h);

		// 7 rotate_sprite : le sprite tourne autour de son centre
		// le paramètre de rotation est donné par	 ftofix(angle*128/M_PI)
		// (en supposante la valeur angle en radians)
		rotate_sprite(page, sprite_transp, x[7], y[7],
									ftofix((phase - 7 * alpha) * 128 / M_PI));

		// un dernier au centre : rotation et mise à l'échelle simultanée
		echelle = (cos(phase) + 1.0) * 0.75; // valeur évoluant entre 0 et 1.5
		rotate_scaled_sprite(page, sprite_transp,
												 SCREEN_W / 2 - echelle * sprite_transp->w / 2,
												 SCREEN_H / 2 - echelle * sprite_transp->h / 2,
												 ftofix(-phase * 128 / M_PI), ftofix(echelle));

		// Affichage (éventuel) d'un avant plan avec transparence
		masked_blit(avantplan, page, 0, 0, 0, SCREEN_H - 150, avantplan->w,
								avantplan->h);

		// affichage du buffer à l'écrane
		blit(page, screen, 0, 0, 0, 0, SCREEN_W, SCREEN_H);

		// la petite pause...
		rest(10);
	}

	return 0;
}
END_OF_MAIN();
