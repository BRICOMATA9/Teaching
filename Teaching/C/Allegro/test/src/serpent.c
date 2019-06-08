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

BITMAP *chargerImage(char *nomFichierImage){
	BITMAP *bmp;
	bmp=load_bitmap(nomFichierImage,NULL);
	if (bmp==NULL){
		allegro_message("pas pu trouver/charger %s",nomFichierImage);
		allegro_exit();
		exit(EXIT_FAILURE);
	}
	printf("Image charg\202e : %s\n", nomFichierImage);
	return bmp;
}

int main(int argc, char *argv[]){
	lancerToutAllegro(800,600);
	
	int c, fin, x, y = 0;
	int  xp, yp = 0;
	int first=1;
	BITMAP* page = create_bitmap(SCREEN_W,SCREEN_H);
	BITMAP* image = chargerImage("../res/decor.bmp");
	
	int tab1[10];
	int tab2[10];
	for(int i=0; i<10; i++){
		tab1[i]=rand()%800;
		tab2[i]=rand()%600;
		rectfill(page, tab1[i],tab2[i] , tab1[i]+10, tab2[i]+10, makecol(255,0,0));
		printf("%d", i);
	}

	fin=0;
	while (!fin) {
		if(key[KEY_ESC]) fin=1;
		
/*		rectfill(page,50,50,60,60,makecol(255,0,0));*/
/*		*/
/*		if(mouse_b & 1){*/
/*			rectfill(page,mouse_x,mouse_y,mouse_x+10,mouse_y+10,c);*/
/*		}else if(mouse_b & 2){*/
/*			c = getpixel(page, mouse_x, mouse_y);*/
/*			x=mouse_x;*/
/*			y=mouse_y;*/
/*			if(first){*/
/*				xp=mouse_x;*/
/*				yp=mouse_y;*/
/*				first=0;*/
/*			}*/
/*		}else if(!first){*/
/*			rectfill(page, xp, yp, x, y, makecol(0,0,0));*/
/*			first=1;*/
/*		}*/

	for(int i=0; i<10; i++){
		if(mouse_x > 800/2 && mouse_y > 600/2){
			tab1[i]++;
			tab2[i]++;
		}
		
		if(mouse_x > 800/2 && mouse_y < 600/2){
			tab1[i]++;
			tab2[i]--;
		}
		
		if(mouse_x < 800/2 && mouse_y > 600/2){
			tab1[i]--;
			tab2[i]++;
		}
		
		if(mouse_x < 800/2 && mouse_y < 600/2){
			tab1[i]--;
			tab2[i]--;
		}

		rectfill(page, tab1[i],tab2[i] , tab1[i]+10, tab2[i]+10, makecol(255,0,0));
		printf("%d", i);
	}
		
		blit(page,screen,0,0,0,0,SCREEN_W,SCREEN_H);
		rest(50);
	}

	return 0;
}
END_OF_MAIN();


