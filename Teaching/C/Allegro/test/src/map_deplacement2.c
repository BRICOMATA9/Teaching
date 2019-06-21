#include <allegro.h>
#include "setup.h"

void main(){
	lancerAllegro(800,600);
	
	BITMAP * page = create_bitmap(SCREEN_W,SCREEN_H);
	BITMAP * map = load_bitmap("../res/map.bmp",NULL);
	if (!map)  {
		allegro_message("pas pu trouver/map.bmp");
		allegro_exit(); 
		exit(EXIT_FAILURE);
	}
	
	BITMAP *dust = create_bitmap(1920,1080);
	clear_to_color(dust, makeacol(220,220,220,100));
	
	int pos_x =0;
	int pos_y =0;
	int x0 =0;
	int y0 =0;
	int first =0;
	int i =0;

	set_alpha_blender();
	drawing_mode(DRAW_MODE_TRANS, 0, 0, 0);
	while (!key[KEY_ESC]){
		
		if (mouse_b & 1 ){
			if(first){
				x0=mouse_x;
				y0=mouse_y;
				first=0;
			}
				pos_x += x0 - mouse_x;
				pos_x -= mouse_x - x0;
				pos_y += y0 - mouse_y;
				pos_y -= mouse_y - y0;
				
				x0=mouse_x;
				y0=mouse_y;
		} else if(!first){
			first=1;
		}
		
		show_mouse(map);
		blit(map,screen,mouse -400,mouse_y - 300,0,0,SCREEN_W,SCREEN_H);
/*		show_mouse(screen);*/
		
/*		*/
/*		circlefill(dust,pos_x+400, pos_y+300, 150, makeacol(255,0,255,255));*/
/*		masked_blit(dust,page,pos_x,pos_y,0,0,SCREEN_W,SCREEN_H);*/
/*		*/
/*		rectfill(page,*/
/*			SCREEN_W-10-192,*/
/*			SCREEN_H-10-108,*/
/*			SCREEN_W-10,*/
/*			SCREEN_H-10,*/
/*			makeacol(0,0,0,150)*/
/*		);*/
/*		rect(page,*/
/*			(SCREEN_W-10-192+(pos_x/10)),*/
/*			(SCREEN_H-10-108+(pos_y/10)),*/
/*			(SCREEN_W-10-112+(pos_x/10)),*/
/*			(SCREEN_H-10-48 +(pos_y/10)),*/
/*			makeacol(255,255,255,200)*/
/*		);*/
/*		*/
/*		rectfill(page, mouse_x, mouse_y, mouse_x+40, mouse_y+40, makecol(0,0,0));*/
/*		show_mouse(page);*/
/*		blit(page,screen,0,0,0,0,SCREEN_W,SCREEN_H);*/
/*		rest(100);*/
	}
}
