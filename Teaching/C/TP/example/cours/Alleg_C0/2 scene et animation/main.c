#include <allegro.h>
#include <math.h>
#include <stdio.h>

/// PROTOTYPES DES SOUS-PROGRAMMES

// Regroupe les initialisations d'allegro, mode graphique, clavier, souris
// Termine le programme (avec message) en cas d'échec
void lancerToutAllegro(int largeur, int hauteur);

// Fonctionne comme load_bitmap sauf qu'il ne prend pas NULL en 2ème paramètre
// et qu'il termine le programme (avec message) en cas d'échec
BITMAP *chargerImage(char *nomFichierImage);



/// Programme principal
int main(int argc, char *argv[])
{
    /// DECLARATIONS DES VARIABLES DU MAIN

    // Page pour l'assemblage de la scène (invisible)
    BITMAP *page;

    // Graphismes chargés depuis des fichiers .bmp
    BITMAP *decor;
    BITMAP *arbre;
    BITMAP *maison;
    BITMAP *soleil;

    // Variables pour animer le soleil
    int soleilx, soleily;       // Position effective du soleil
    int soleilmx, soleilmy;     // Position moyenne du soleil
    int soleilampx, soleilampy; // Amplitudes mouvement
    int soleilcycle;            // Angle en degrés...

    /// INITIALISATION ALLEGRO et services
    lancerToutAllegro(800,600);

    /// AVANT BOUCLE JEU : initialisations et chargement des données

    // CREATION DU BUFFER D'AFFICHAGE à la taille de l'écran
    page=create_bitmap(SCREEN_W,SCREEN_H);
    clear_bitmap(page);

    // charger image de fond
    decor=chargerImage("images/decor.bmp");

    // charger les images des "objets"
    arbre=chargerImage("images/arbre.bmp");
    maison=chargerImage("images/maison.bmp");
    soleil=chargerImage("images/soleil.bmp");

    // Initialisation pour animation
    // (positions/compteurs de départ...)
    soleilmx=50;
    soleilmy=65;
    soleilampx=0;
    soleilampy=20;
    soleilcycle=0;


    /// BOUCLE JEU
    while (!key[KEY_ESC])
    {
        /// Mise à jour des positions pour les objets animés
        soleilx=soleilmx+soleilampx*cos(soleilcycle*M_PI/180);
        soleily=soleilmy-soleilampy*sin(soleilcycle*M_PI/180);
        soleilcycle=soleilcycle+10;
        while (soleilcycle>=360)
            soleilcycle=soleilcycle-360;

        /// Assemblage de la scène sur le BUFFER (invisible pour l'instant)
        //  En posant le décor sur le buffer on écrase son ancien contenu
        blit(decor,page,0,0,0,0,SCREEN_W,SCREEN_H);

        //  On pose les différents éléments, du plus éloigné au plus proche
        //  ON RECONSTRUIT TOUT (même ce qui est resté à la même place)
        draw_sprite(page,soleil,soleilx,soleily);
        draw_sprite(page,arbre,490,330);
        draw_sprite(page,maison,450,350);
        draw_sprite(page,arbre,150,370);
        draw_sprite(page,arbre,330,400);


        /// affichage du buffer à l'écran (scene rendue visible)
        blit(page,screen,0,0,0,0,SCREEN_W,SCREEN_H);

        /// une pause pour temporiser l'enchaînement des images
        rest(20);        // ( 20 ms -> à peu près 50 images/s )
    }

    /// TERMINER LE PROGRAMME
    //  Rien de spécial à faire ici pour l'instant
    //  Les BITMAPs réservées en mémoire avec create_bitmap ou load_bitmap
    //  seront automatiquement libérées en terminant le main.

    return 0;
}
END_OF_MAIN();


/// DEFINITIONS DES SOUS-PROGRAMMES

// Regroupe les initialisations d'allegro, mode graphique, clavier, souris
void lancerToutAllegro(int largeur, int hauteur)
{
    allegro_init();
    install_keyboard();
    install_mouse();

    /// OUVERTURE MODE GRAPHIQUE (ouverture fenêtre allegro)
    set_color_depth(desktop_color_depth());
    if (set_gfx_mode(GFX_AUTODETECT_WINDOWED,largeur,hauteur,0,0)!=0)
    {
        allegro_message("probleme mode graphique : %s", allegro_error);
        allegro_exit();
        exit(EXIT_FAILURE);
    }
    show_mouse(screen); // Affiche pointeur de souris en mode allegro
}

// Fonctionne comme load_bitmap sauf qu'il ne prend pas NULL en 2ème paramètre
// et qu'il termine le programme (avec message) en cas d'échec
//    Exemple de fonction wrapper (emballage d'une fct par une autre fct)
BITMAP *chargerImage(char *nomFichierImage)
{
    BITMAP *bmp;
    bmp=load_bitmap(nomFichierImage,NULL);
    if (bmp==NULL)
    {
        allegro_message("pas pu trouver/charger %s",nomFichierImage);
        allegro_exit();
        exit(EXIT_FAILURE);
    }
    printf("Image charg\202e : %s\n", nomFichierImage);
    return bmp;
}
