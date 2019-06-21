

/*******************************************************************
BITMAP : Charger une image depuis un fichier .bmp vers une BITMAP
         et afficher cette BITMAP au milieu de l'écran

         L'image s'apppelle "mon_image.bmp" et doit être mise
         au niveau du répertoire de projet (avec le main.c)
         à moins de modifier le chemin d'accès ci dessous...

         Appuyer sur espace pour ajouter des copies multiples
*******************************************************************/



#include <allegro.h>
#include <png.h>
#include <loadpng.h>
#include <jpgalleg.h>

#include <time.h>

int main()
{
    // Déclaration du pointeur sur BITMAP devant recevoir l'image
    BITMAP *image[2];
    char nf[2][100]={"img/test.png", "img/mona-lisa.jpg"};
    int i;

    // Il y aura un peu de hasard...
    srand(time(NULL));

    // Lancer allegro et le mode graphique
    allegro_init();
    install_keyboard();
    register_png_file_type();
    jpgalleg_init();

    set_color_depth(desktop_color_depth());
    if (set_gfx_mode(GFX_AUTODETECT_WINDOWED,800,600,0,0)!=0)
    {
        allegro_message("prb gfx mode");
        allegro_exit();
        exit(EXIT_FAILURE);
    }

    // Chargement et affichage des images
    for (i=0; i<2; i++)
    {
        // Chargement de l'image (l'allocation a lieu en même temps)
        image[i]=load_bitmap(nf[i],NULL);

        // Vérification que l'image est bien chargée (dans le cas contraire image vaut NULL)
        // TOUJOURS LE FAIRE CAR ON N'EST JAMAIS CERTAIN DE BIEN TROUVER L'IMAGE
        if (!image[i])
        {
            allegro_message("pas pu trouver/charger %s", nf[i]);
            allegro_exit();
            exit(EXIT_FAILURE);
        }
    }

    // Affichage de l'image 0 sur l'écran
    blit(image[0],screen,0,0, (SCREEN_W-image[0]->w)/2, (SCREEN_H-image[0]->h)/2, image[0]->w, image[0]->h);

    // Affichage de l'image 1 sur l'écran
    blit(image[1],screen,0,0, 0, 0, image[1]->w, image[1]->h);

    // Boucle interactive
    while (!key[KEY_ESC])
    {
        if (key[KEY_SPACE])
        {
            i=(i+1)%2;
            blit(image[i],screen,0,0, rand()%(SCREEN_W-image[i]->w), rand()%(SCREEN_H-image[i]->h), image[i]->w, image[i]->h);
        }
        rest(10);
    }

    return 0;
}
END_OF_MAIN();
