/*
		VERSION 2009 donnée à titre indicatif :
		style de programmation plus compact

			ALLEGRO C3

			SPRITES ET ANIMATION
				 - Animer plusieurs séquences simultanées

*/

#include <allegro.h>
#include <stdio.h>
#include <time.h>

#define ERREUR(msg)																														\
	{																																						\
		set_gfx_mode(GFX_TEXT, 0, 0, 0, 0);																				\
		allegro_message("erreur ligne %d, fichier %s: %s\n", __LINE__, __FILE__,	 \
										msg);																											\
		allegro_exit();																														\
		exit(EXIT_FAILURE);																												\
	}

// généralisation controle du sprite : structure de données
typedef struct SPRITE {

	// le deplacement (sans float mais avec le même mécanisme de retard que
	// celui utilisé pour pour l'image)
	int x, y;				 // position
	int px, py;			 // pas du deplacement
	int tx, ty;			 // taille
	int wx, wy;			 // pour retarder avancement en x et y
	int xcmpt, ycmpt; // pour compter le retard

	// l'image
	int imcourante; // l'image courante
	int nb_image;	 // le nombre max des images de l'animation
	int maxtmps;		// temps maxi pour chaque image
	int tmps;			 // pour compter le temps d'affichage de l'image
	int dir;				// sens de l'animation (à reculons ou avancer)
	BITMAP **anim;	// un tableau de pointeurs pour stocker chaque petite anim

} t_sprite;

// la série des indices des sprites (qui seront tous regroupés dans un tableau
// de t_sprite* :
enum { DRAGON, POISSON, CRABE, ABEILLE, MOUSTIQUE, SERPENT, NB_SPRITE };

void construct_sprites(t_sprite *tab[]);
void init_position(t_sprite *s, int posx, int posy, int tx, int ty, int px,
									 int py, int wx, int wy);
void init_image(t_sprite *s, int nbimage, int maxtmps, int dir, char *name,
								int nb_col);
void recup_images_anime(t_sprite *s, char *fname, int nb_col);
void destruct(t_sprite *tab[]);
void avance_sprite(BITMAP *dest, t_sprite *s);
/******************************************************************************
*******************************************************************************/
int main() {
	t_sprite *all[NB_SPRITE];
	BITMAP *page, *decor;
	int i, start;

	allegro_init();
	install_keyboard();
	srand(time(NULL));

	set_color_depth(16);
	if (set_gfx_mode(GFX_AUTODETECT_FULLSCREEN, 640, 480, 0, 0) != 0)
		ERREUR(allegro_error);

	// le buffer et l'image du fond
	page = create_bitmap(SCREEN_W, SCREEN_H);
	decor = load_bitmap(".\\images\\dragon\\decor.bmp", NULL);
	if (!page || !decor)
		ERREUR("create page||load decor");

	// construire tous les spites
	construct_sprites(all);

	// boucle
	start = clock();
	while (!key[KEY_ESC]) {

		// ralentir sans bloquer le programme
		if (clock() > start + 10) {
			start = clock();
			// efface page avec décor
			blit(decor, page, 0, 0, 0, 0, decor->w, decor->h);

			// animation des sprites
			for (i = 0; i < NB_SPRITE; i++)
				avance_sprite(page, all[i]);

			// affichage écran
			blit(page, screen, 0, 0, 0, 0, SCREEN_W, SCREEN_H);
		}
	}
	destroy_bitmap(page);
	destruct(all);
	return 0;
}
END_OF_MAIN();
/******************************************************************************
Allouer chaque sprite et mettre tout à 0
*******************************************************************************/
void construct_sprites(t_sprite *tab[]) {
	int i;
	for (i = 0; i < NB_SPRITE; i++) {
		tab[i] = (t_sprite *)malloc(sizeof(t_sprite));
		memset(tab[i], 0, sizeof(t_sprite));
	}
	// 1 LE DRAGON
	// paramêtres position =le sprite, position,taille,deplacement, attente
	init_position(tab[DRAGON], 500, 0, 128, 64, -5, 0, 1, 0);
	// paramêtres image = nb_image, maxtmps,dir, nomfichier, nb colonnes
	init_image(tab[DRAGON], 6, 5, 1, ".\\images\\dragon\\dragon.bmp", 3);

	// 2 LE POISSON
	init_position(tab[POISSON], 300, 400, 64, 32, 3, 0, 1, 0);
	init_image(tab[POISSON], 3, 8, 1, ".\\images\\dragon\\poisson.bmp", 3);

	// LE CRABE
	init_position(tab[CRABE], 300, 212, 64, 32, 2, 0, 6, 0);
	init_image(tab[CRABE], 4, 20, 1, ".\\images\\dragon\\crabe.bmp", 4);

	// L'ABEILLE
	init_position(tab[ABEILLE], 100, 122, 50, 40, -3, 0, 1, 0);
	init_image(tab[ABEILLE], 6, 8, 1, ".\\images\\dragon\\abeille.bmp", 6);

	// LE MOUSTIQUE
	init_position(tab[MOUSTIQUE], 500, 70, 50, 40, 4, 0, 1, 0);
	init_image(tab[MOUSTIQUE], 6, 2, 1, ".\\images\\dragon\\moustique.bmp", 6);

	// LE SERPENT
	init_position(tab[SERPENT], 350, 200, 100, 50, -2, 0, 1, 0);
	init_image(tab[SERPENT], 7, 4, 1, ".\\images\\dragon\\serpent.bmp", 4);
}
/******************************************************************************
*******************************************************************************/
void init_position(t_sprite *s, int posx, int posy, // position
									 int tx, int ty,									// taille
									 int px, int py,									// deplacement
									 int wx, int wy)									// attente deplacement
{
	s->x = posx;
	s->y = posy;
	s->tx = tx;
	s->ty = ty;
	s->px = px;
	s->py = py;
	s->wx = wx;
	s->wy = wy;
}
/******************************************************************************
*******************************************************************************/
void init_image(t_sprite *s,											 // le sprite
								int nbimage, int maxtmps, int dir, // param anime
								char *name, int nb_col)						// param récup sur fichier
{
	int i;
	s->maxtmps = maxtmps;
	s->dir = dir;
	s->nb_image = nbimage;

	// construire le tableau des images (tableau de pointeurs)
	s->anim = (BITMAP **)malloc(sizeof(BITMAP *) * nbimage);
	// allouer chaque pointeur BITMAP* du tableau
	for (i = 0; i < nbimage; i++) {
		s->anim[i] = create_bitmap(s->tx, s->ty);
		if (!s->anim[i])
			ERREUR("creation sprite");
	}
	// récupérer
	recup_images_anime(s, name, nb_col);
}
/******************************************************************************
*******************************************************************************/
void recup_images_anime(t_sprite *s, char *fname, int nb_col) {
	BITMAP *tmp = NULL;
	int x, y, i;

	tmp = load_bitmap(fname, NULL);
	if (!tmp)
		ERREUR("recup anime dragon");

	for (i = 0; i < s->nb_image; i++) {
		x = (i % nb_col) * s->tx;
		y = (i / nb_col) * s->ty;
		blit(tmp, s->anim[i], x, y, 0, 0, s->tx, s->ty);
	}
	destroy_bitmap(tmp);
}
/******************************************************************************
*******************************************************************************/
void destruct(t_sprite *tab[]) {
	int i, j;
	for (i = 0; i < NB_SPRITE; i++)
		for (j = 0; j < tab[i]->nb_image; j++)
			destroy_bitmap(tab[i]->anim[j]);
	free(tab[i]->anim);
	free(tab[i]);
}
/******************************************************************************
*******************************************************************************/
void avance_sprite(BITMAP *dest, t_sprite *s) {
	// MODIFIER POSITION

	// attention à une possible division par 0 si xwait,ywait ou maxtmps sont à 0
	// avec ce code :
	//	 s->xcmpt=(++s->xcmpt)%s->wx;
	//	 if (!s->xcmpt)
	//			s->x+=s->px;
	// on peut lui préférer celui-ci :

	// petit compte pour retard avance en x
	if (++s->xcmpt > s->wx) {
		s->x += s->px;
		s->xcmpt = 0;
	}
	// idem en y
	if (++s->ycmpt > s->wy) {
		s->y += s->py;
		s->ycmpt = 0;
	}

	// CONTROLE DES BORDS
	// controle mouvement x
	if (s->x + s->tx < 0)
		s->x = SCREEN_W - 1;

	if (s->x > SCREEN_W)
		s->x = -s->tx;

	// controle mouvement y
	if (s->y + s->ty < 0)
		s->y = SCREEN_H - 1;

	if (s->y > SCREEN_H)
		s->y = -s->ty;

	// CONTROLE IMAGE
	// compte pour affichage image
	if (++s->tmps > s->maxtmps) {
		// si inférieur à 0 on repart à l dernière et si supérieur au
		// nombre d'image on repart à 0;
		s->imcourante = ((s->imcourante + s->dir) + s->nb_image) % s->nb_image;
		s->tmps = 0;
	}

	// AFFICHAGE SPRITE
	draw_sprite(dest, s->anim[s->imcourante], s->x, s->y);
}
/******************************************************************************
*******************************************************************************/
