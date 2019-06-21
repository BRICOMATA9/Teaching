#include <allegro.h>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>

void lancerAllegro(int largeur, int hauteur){
	allegro_init();
	install_keyboard();
	install_mouse();

	set_color_depth(desktop_color_depth());
	if (set_gfx_mode(GFX_AUTODETECT_WINDOWED,largeur,hauteur,0,0)!=0){
		allegro_message("probleme mode graphique : %s", allegro_error);
		allegro_exit();
		exit(EXIT_FAILURE);
	}
	show_mouse(screen);
	
}

