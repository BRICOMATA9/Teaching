#include <allegro.h>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>

void lancerToutAllegro(int largeur, int hauteur){
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

int main(int argc, char *argv[]){
	
	lancerToutAllegro(800,600);
	
	BITMAP * page = create_bitmap(SCREEN_W,SCREEN_H);
	BITMAP* pagejhjh = create_bitmap(SCREEN_W,SCREEN_H);

	int fin,x,y,x0,y0 = 0;
	int color= 0;
	int first=1;
	
	fin=0;
	while (!fin){
		show_mouse(screen);
		rectfill(page, 50, 50, 70, 70, makecol(255,0,0));
		rectfill(page, 90, 50, 110, 70, makecol(0,255,0));
		rectfill(page, 130, 50, 150, 70, makecol(0,0,255));

		if (mouse_b & 2){ // gauche : dessiner en rouge
			color = getpixel(page, mouse_x, mouse_y);
			x=mouse_x;
			y=mouse_y;
			if(first){
				x0=mouse_x;
				y0=mouse_y;
				first=0;
			}
			rect (page, x0, y0, mouse_x, mouse_y, makecol(255,255,255));
		}
		else if (mouse_b & 1){ // droit : dessiner en bleu
			rectfill(page, mouse_x, mouse_y, mouse_x+20, mouse_y+20, color);
		}else if (mouse_b & 4) // mileu : fin du programme
			fin=1;
		else if(!first){
				rectfill(page, x0, y0, x, y, makecol(0,0,0));
				first=1;
			}
		
		blit(page,screen,0,0,0,0,SCREEN_W,SCREEN_H);
		clear_bitmap(page);
		rest(10);
	}

	return 0;
	
	
}
END_OF_MAIN();
