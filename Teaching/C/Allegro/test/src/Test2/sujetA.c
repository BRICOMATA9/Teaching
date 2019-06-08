#include "setup.h"

void main(int argc, char *argv[]){
	
	lancerAllegro(800,600);
	
	BITMAP * background = create_bitmap(SCREEN_W,SCREEN_H);
	
	set_alpha_blender();
	drawing_mode(DRAW_MODE_TRANS, 0, 0, 0);
	
	BITMAP * map = load_bitmap("desert.bmp",NULL);
	if (!map)  {
		allegro_message("pas pu trouver/map.bmp");
		allegro_exit(); 
		exit(EXIT_FAILURE);
	}
	
	BITMAP *dust = create_bitmap(1920,1080);
	clear_to_color(dust, makeacol(220,220,220,100));
	
	int x0,y0 = 0;
	int first = 1;
	
	while (!key[KEY_ESC]){
		blit(map,background,0,0,0,0,SCREEN_W,SCREEN_H);
		masked_blit(dust,background,0,0,0,0,SCREEN_W,SCREEN_H);
		
		if (mouse_b & 2){ // droit
			if(first){
				x0=mouse_x;
				y0=mouse_y;
				first=0;
			}
			rect (background, x0, y0, mouse_x, mouse_y, makeacol(0,0,0,255));
		} else if(!first){
			rectfill(dust, x0, y0, mouse_x, mouse_y, makeacol(255,0,255,255));
			first=1;
		}
		
		show_mouse(background);
		blit(background,screen,0,0,0,0,SCREEN_W,SCREEN_H);
	}
}
