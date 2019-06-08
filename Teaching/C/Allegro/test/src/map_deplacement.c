#include <stdio.h>
#include <stdlib.h>
#include <allegro.h>
#include <time.h>

int main(){
    //var
    BITMAP * map = NULL;
    BITMAP * map_b = NULL;
    BITMAP * page = NULL;
    BITMAP * dust = NULL;
    int pos_x =0;
    int pos_y =0;
    int i =0;
    //init
    srand(time(NULL));
    allegro_init();
    install_keyboard();
    install_mouse();
    set_alpha_blender();
    show_mouse(screen);
    drawing_mode(DRAW_MODE_TRANS, 0, 0, 0);
    //boucle
    set_color_depth(desktop_color_depth());
    if (set_gfx_mode(GFX_AUTODETECT_WINDOWED,800,600,0,0)!=0){
        allegro_message("probleme mode graphique");
        allegro_exit();
        exit(EXIT_FAILURE);
    }
    
    // 1
    map = load_bitmap("../res/map.bmp",NULL);
    if (!map)  {
        allegro_message("pas pu trouver/map.bmp");
        allegro_exit(); exit(EXIT_FAILURE);
    }
    
    // 2
    page = create_bitmap(SCREEN_W,SCREEN_H);
    
    // 3
    dust = create_bitmap(1920,1080);
    clear_to_color(dust, makeacol(220,220,220,100));
    
    while (!key[KEY_ESC]){
        circlefill(dust,pos_x+400, pos_y+300, 150, makeacol(255,0,255,255));
        //Deplacement
        if((mouse_x >(SCREEN_W-50))&&pos_x<(1920-SCREEN_W))  pos_x = pos_x + 5;
        if((mouse_x <50)           &&(pos_x>0))              pos_x = pos_x - 5;
        if((mouse_y >(SCREEN_H-50))&&pos_y<(1080-SCREEN_H))  pos_y = pos_y + 5;
        if((mouse_y <50)           &&(pos_y>0))              pos_y = pos_y - 5;
        //ACTION
        if(mouse_b & 2){
            if(5607628==getpixel(map,pos_x+mouse_x,pos_y+mouse_y))allegro_message("Terre");
               else allegro_message("Ocean");
               mouse_b = 0;
        }
        blit(map,page,pos_x,pos_y,0,0,SCREEN_W,SCREEN_H);
/*        masked_blit(dust,page,pos_x,pos_y,0,0,SCREEN_W,SCREEN_H);*/
        
        rectfill(page,
        	SCREEN_W-10-192,
        	SCREEN_H-10-108,
        	SCREEN_W-10,
        	SCREEN_H-10,makeacol(0,0,0,150));
        	
        rect(page,
        	((SCREEN_W-10-192)+(pos_x/10)),
        	(SCREEN_H-10-108+(pos_y/10)),
        	(SCREEN_W-10-112+(pos_x/10)),
        	(SCREEN_H-10-48+(pos_y/10)),
        	makeacol(255,255,255,200));
        
        blit(page,screen,0,0,0,0,SCREEN_W,SCREEN_H);
        
        rest(10);
    }
    return 0;
}
END_OF_MAIN();
