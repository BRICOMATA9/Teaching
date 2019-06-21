/*****************************************************************************
BITMAP : Charger une image depuis un fichier .bmp vers une BITMAP puis
				 effectuer des traitements pixel par pixel
						 - négatif
						 - niveaux de gris (noir et blanc)
						 - déformation géométrique (ondulation)
				 vers 3 autres BITMAP
				 Afficher l'original et les résultats

				 Le principe est le même que pour le programme précédent 4_0
				 mais ici on met les "filtres" dans des sous-programmes
*****************************************************************************/

#include <allegro.h>
#include <math.h>

void negatif(BITMAP *src, BITMAP *dest);
void nivgris(BITMAP *src, BITMAP *dest);
void ondulation(BITMAP *src, BITMAP *dest, float phase);

int main() {
	// Déclaration du pointeur sur BITMAP devant recevoir l'image
	BITMAP *image;

	// Pointeur sur BITMAP devant recevoir (successivement) le résultat des 3
	// traitements
	BITMAP *imgdest;

	// phase pour l'effet d'ondulation
	float phase = 0.0;

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
	image = load_bitmap("mon_image_tournee.bmp", NULL);
	if (!image) {
		allegro_message("pas pu trouver/charger mon_image_tournee.bmp");
		allegro_exit();
		exit(EXIT_FAILURE);
	}

	// Affichage de l'image originale sur l'écran en haut à gauche
	blit(image, screen, 0, 0, 0, 0, image->w, image->h);

	// Créer la BITMAP destination des traitements
	imgdest = create_bitmap(image->w, image->h);

	// NEGATIF
	negatif(image, imgdest);
	blit(imgdest, screen, 0, 0, image->w, 0, image->w, image->h);

	// NIVEAUX DE GRIS
	nivgris(image, imgdest);
	blit(imgdest, screen, 0, 0, 0, image->h, image->w, image->h);

	// Boucle d'animation
	while (!key[KEY_ESC]) {
		// ONDULATION
		phase = phase + .1 * M_PI;
		ondulation(image, imgdest, phase);
		blit(imgdest, screen, 0, 0, image->w, image->h, image->w, image->h);
	}

	return 0;
}
END_OF_MAIN();

// IMAGE EN NEGATIF
void negatif(BITMAP *src, BITMAP *dest) {
	int x, y, c;

	for (y = 0; y < src->h; y++)
		for (x = 0; x < src->w; x++) {
			c = getpixel(src, x, y);
			printf("%d\n", c);
			putpixel(dest, x, y,
							 makecol(255 - getr(c), 255 - getg(c), 255 - getb(c)));
		}
}

// NIVEAUX DE GRIS
void nivgris(BITMAP *src, BITMAP *dest) {
	int x, y, c, gris;

	for (y = 0; y < src->h; y++)
		for (x = 0; x < src->w; x++) {
			// Couleur de départ
			c = getpixel(src, x, y);

			// Moyenne des trois composantes r g b de départ
			gris = (getr(c) + getg(c) + getb(c)) / 3;

			// A l'arrivée on fabrique une couleur avec r g b identiques
			putpixel(dest, x, y, makecol(gris, gris, gris));
		}
}

// ONDULATIONS
void ondulation(BITMAP *src, BITMAP *dest, float phase) {
	int x, y, xim, yim, c;
	float dist;

	for (y = 0; y < src->h; y++)
		for (x = 0; x < src->w; x++) {
			// distance au centre de l'image
			dist = sqrt((x - 0.5 * src->w) * (x - 0.5 * src->w) +
									(y - 0.5 * src->h) * (y - 0.5 * src->h));

			// calcul de xim yim correspondant sur l'image de départ
			// proportionnel à x y de la vue finale + terme de reflet
			// ici 5.0 est l'amplitude est 0.2 indique l'inverse de la longueur d'onde
			xim = x + 5.0 * sin(0.2 * dist - phase);
			yim = y + 5.0 * cos(0.2 * dist - phase);

			// on copie de ces coordonnées déformées
			c = getpixel(src, xim, yim);

			// vers le pixel destination
			putpixel(dest, x, y, c);
		}
}
