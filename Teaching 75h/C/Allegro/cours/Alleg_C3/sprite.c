/**************************************************************************
SPRITE ANIME
					Pour animer un élément graphique dynamique
					il faut charger un tableau de bitmaps
					correspondant à une séquence d'images

					ce programme illustre l'animation d'un personnage (chat)
					qui traverse l'écran de gauche à droite et de droite à gauche

					les différents paramètres peuvent être réglés avec F1 à F8
**************************************************************************/

#include <allegro.h>
#include <stdio.h>

// Sous programme pour jouer avec les parametres
void reglages(BITMAP *bmp, int *ptempoglobale, int *pdx, int *ptmpdx,
							int *ptmpimg);

// Il y a 6 images dans la séquence du chat
//	( à terme il faudrait gérer ça en allocation dynamique )
#define NIMAGE 6

int main() {

	// LES INFORMATIONS SUIVANTES VONT ALLER DANS UNE STRUCTURE ACTEUR
	//	 ( pour pouvoir gérer plusieurs sprites animés )

	// Données géométriques de l'animation
	int x, y;
	int dx, dy;
	int tx, ty;

	// Pour pouvoir avancer très lentement on avance moins souvent
	//	( ajouter dx une fois tous les tmpdx, initialement à chaque fois )
	int cptdx = 0, tmpdx = 1;

	// Gestion de l'enchainement des images de la séquence
	// indice de l'image courante
	int imgcourante = 0;
	// on passe à l'image suivante une fois tous les tmpimg
	int cptimg = 0, tmpimg = 4;

	// Séquence d'animation
	BITMAP *img[NIMAGE];

	// AUTRES VARIABLES NE CONCERNANT PAS SPECIFIQUEMENT LE CHAT

	// BITMAP servant de buffer d'affichage (double buffer)
	BITMAP *page;

	// Image de fond
	BITMAP *decor;

	// La tempo générale (fonction rest) sera réglable
	int tempoglobale = 10;

	// Pour charger la séquence
	int i;
	char nomfichier[256];

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
	decor = load_bitmap("images/cat/decor.bmp", NULL);
	if (!decor) {
		allegro_message("pas pu trouver images/cat/decor.bmp");
		exit(EXIT_FAILURE);
	}

	// charger les images de la séquence d'animation
	for (i = 0; i < NIMAGE; i++) {
		// sprintf permet de faire un printf dans une chaine
		sprintf(nomfichier, "images/cat/cat%d.bmp", i);

		img[i] = load_bitmap(nomfichier, NULL);
		if (!img[i]) {
			allegro_message("pas pu trouver %s", nomfichier);
			exit(EXIT_FAILURE);
		}
	}

	// initialisation des données du chat

	tx = img[0]->w; // pour la taille on se base sur la 1ère image de la séquence
	ty = img[0]->h;
	x = 0;
	y = SCREEN_H / 2 - ty;
	dx = 5;
	dy = 0;

	cptdx = 0;
	tmpdx = 1;

	imgcourante = 0;
	cptimg = 0;
	tmpimg = 5;

	// Boucle d'animation (pas d'interaction)
	while (!key[KEY_ESC]) {
		// effacer buffer en appliquant décor	(pas de clear_bitmap)
		blit(decor, page, 0, 0, 0, 0, SCREEN_W, SCREEN_H);

		// appel d'un sous programme de réglage interactif des parametres
		// ( seulement utile sur cet exemple ou pour du debug )
		reglages(page, &tempoglobale, &dx, &tmpdx, &tmpimg);

		// gestion déplacement du chat
		if ((x < 0 && dx < 0) || (x + tx > SCREEN_W && dx > 0))
			dx = -dx;

		cptdx++;
		if (cptdx >= tmpdx) {
			cptdx = 0;
			x += dx;
		}

		y += dy;

		// gestion enchainement des images
		// incrémenter imgcourante une fois sur tmpimg
		cptimg++;
		if (cptimg >= tmpimg) {
			cptimg = 0;

			imgcourante++;

			// quand l'indice de l'image courante arrive à NIMAGE
			// on recommence la séquence à partir de 0
			if (imgcourante >= NIMAGE)
				imgcourante = 0;
		}

		// afficher l'image courante du chat (selon le sens...)
		if (dx >= 0)
			draw_sprite(page, img[imgcourante], x, y);
		else
			draw_sprite_h_flip(page, img[imgcourante], x, y);

		// affichage du buffer à l'écrane
		blit(page, screen, 0, 0, 0, 0, SCREEN_W, SCREEN_H);

		// la petite pause...
		rest(tempoglobale);
	}

	return 0;
}
END_OF_MAIN();

// Sous programme pour jouer avec les parametres
void reglages(BITMAP *bmp, int *ptempoglobale, int *pdx, int *ptmpdx,
							int *ptmpimg) {
	textprintf_ex(bmp, font, 16, 20, makecol(255, 255, 255), 0,
								"F1 - F2 : tempoglobale = %d", *ptempoglobale);
	textprintf_ex(bmp, font, 16, 30, makecol(255, 255, 255), 0,
								"F3 - F4 :					 dx = %d", *pdx);
	textprintf_ex(bmp, font, 16, 40, makecol(255, 255, 255), 0,
								"F5 - F6 :				tmpdx = %d", *ptmpdx);
	textprintf_ex(bmp, font, 16, 50, makecol(255, 255, 255), 0,
								"F7 - F8 :			 tmpimg = %d", *ptmpimg);

	if (key[KEY_F1])
		(*ptempoglobale)--;
	if (*ptempoglobale < 0)
		*ptempoglobale = 0;
	if (key[KEY_F2])
		(*ptempoglobale)++;
	if (*ptempoglobale > 100)
		*ptempoglobale = 100;

	if ((key[KEY_F3] && *pdx > 0) || (key[KEY_F4] && *pdx < 0))
		(*pdx)--;
	if ((key[KEY_F4] && *pdx > 0) || (key[KEY_F3] && *pdx < 0))
		(*pdx)++;
	if (key[KEY_F4] && *pdx == 0)
		(*pdx)++;

	if (key[KEY_F5])
		(*ptmpdx)--;
	if (*ptmpdx < 1)
		*ptmpdx = 1;
	if (key[KEY_F6])
		(*ptmpdx)++;
	if (*ptmpdx > 100)
		*ptmpdx = 100;

	if (key[KEY_F7])
		(*ptmpimg)--;
	if (*ptmpimg < 1)
		*ptmpimg = 1;
	if (key[KEY_F8])
		(*ptmpimg)++;
	if (*ptmpimg > 100)
		*ptmpimg = 100;
}
