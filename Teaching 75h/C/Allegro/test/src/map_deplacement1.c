#include <stdio.h>
#include <stdlib.h>
#include <allegro.h>
#include <time.h>

int main()
{
    //var
    BITMAP * map = NULL;
    BITMAP * map_b = NULL;
    BITMAP * page = NULL;

    int pos_x =0;
    int pos_y =0;
    int i =0;


    //init
    srand(time(NULL));
    allegro_init();
    install_keyboard();
    install_mouse();



    //boucle
    set_color_depth(desktop_color_depth());
    if (set_gfx_mode(GFX_AUTODETECT_WINDOWED,800,600,0,0)!=0)
    {
        allegro_message("probleme mode graphique");
        allegro_exit();
        exit(EXIT_FAILURE);
    }




    map = load_bitmap("../res/map.bmp",NULL);
    if (!map)  {
        allegro_message("pas pu trouver/map.bmp");
        allegro_exit(); exit(EXIT_FAILURE);
    }

    map_b = load_bitmap("../res/map.bmp",NULL);
    if (!map_b)  {
        allegro_message("pas pu trouver/map_b.bmp");
        allegro_exit(); exit(EXIT_FAILURE);
    }

    page = create_bitmap(SCREEN_W,SCREEN_H);


    set_alpha_blender();
    show_mouse(screen);
    drawing_mode(DRAW_MODE_TRANS, 0, 0, 0);



    /// BOUCLE D'ATTENTE (appuyer sur Echap pour sortir)
    while (!key[KEY_ESC]){

        //Deplacement
        if((mouse_x > (SCREEN_W-50)) && pos_x < (1920-SCREEN_W)) 
        	pos_x = pos_x + 5;
        if((mouse_x <50) && (pos_x>0))
        	pos_x = pos_x - 5;
        if((mouse_y > (SCREEN_H-50)) && pos_y < (1080-SCREEN_H))
        	pos_y = pos_y + 5;
        if((mouse_y < 50) && (pos_y > 0))
        	pos_y = pos_y - 5;

        //ACTION
        if(mouse_b & 2){
            if(makecol(255,0,255)==getpixel(map_b,pos_x+mouse_x,pos_y+mouse_y))
            	allegro_message("Terre");
            else allegro_message("Ocean");
               mouse_b = 0;
        }


        // 3) AFFICHAGE NOUVELLEs POSITIONs SUR LE BUFFER
        //    ON UTILISE page AU LIEU DE screen

        //debug negatif
        /*
        if(i%2==0)
        blit(map,page,pos_x,pos_y,0,0,SCREEN_W,SCREEN_H); // astuce : image en 1er...
        else
        blit(map_b,page,pos_x,pos_y,0,0,SCREEN_W,SCREEN_H);

        i++;
*/
        blit(map,page,pos_x,pos_y,0,0,SCREEN_W,SCREEN_H);
        //RADAR
        rectfill(page,
        	SCREEN_W-10-192,
        	SCREEN_H-10-108,
        	SCREEN_W-10,
        	SCREEN_H-10,
        	makeacol(0,0,0,150)
        );
        rect(page,
        	(SCREEN_W-10-192+(pos_x/10)),
        	(SCREEN_H-10-108+(pos_y/10)),
        	(SCREEN_W-10-112+(pos_x/10)),
        	(SCREEN_H-10-48 +(pos_y/10)),
        	makeacol(255,255,255,200)
        );

        // 4) AFFICHAGE DU BUFFER MIS A JOUR A L'ECRAN
        //    le nouveau contenu graphique remplace l'ancien
        //    sans que l'ancien ait été effacé à l'écran (pas de clignotement)
        blit(page,screen,0,0,0,0,SCREEN_W,SCREEN_H);

        rest(10);
                //TEST

    //clear_bitmap(screen);
    }






    return 0;
}

 END_OF_MAIN();
