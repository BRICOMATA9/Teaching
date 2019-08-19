#include "setup.h"

void main(int argc, char *argv[]){
	
	lancerAllegro(800,600);
	
	BITMAP * background = load_bitmap("test.bmp",NULL);
	if (!background)  {
		allegro_message("pas pu trouver/test.bmp");
		allegro_exit(); 
		exit(EXIT_FAILURE);
	}
	
/*	BITMAP * background = create_bitmap(SCREEN_W,SCREEN_H);*/
	BITMAP * cadre      = create_bitmap(SCREEN_W,SCREEN_H);

	int x0,y0 = 0;
	int color = 0;
	int first = 1;
	
	while (!key[KEY_ESC]){
/*		blit(map,background,0,0,0,0,SCREEN_W,SCREEN_H);*/
		// 1ère partie
		rectfill(background, 50 , 50, 70 , 70, makecol(0, 0,255));
		rectfill(background, 70 , 50, 90 , 70, makecol(0,255, 0));
		rectfill(background, 90 , 50, 110, 70, makecol(255, 0, 0));
		
		if (mouse_x < SCREEN_W/2){
			if (mouse_b & 2){       // droit
				color = getpixel(background, mouse_x, mouse_y);
			}else if (mouse_b & 1){ // gauche
				rectfill(background, mouse_x, mouse_y, mouse_x+20, mouse_y+20, color);
				rectfill(background, SCREEN_W-mouse_x, mouse_y, SCREEN_W-mouse_x+20, mouse_y+20, color);
			}
		}
		blit(background,cadre,0,0,0,0,SCREEN_W,SCREEN_H);
		
		// 2ème partie
		if (mouse_b & 2){ // droit
			if(first){
				x0=mouse_x;
				y0=mouse_y;
				first=0;
			}
			rect (cadre, x0, y0, mouse_x, mouse_y, makecol(255,255,255));
		}else if(!first){
			rectfill(background, x0, y0, mouse_x, mouse_y, makecol(0,0,0));
			first=1;
		}
		
		show_mouse(cadre);
		blit(cadre,screen,0,0,0,0,SCREEN_W,SCREEN_H);
	}
}
