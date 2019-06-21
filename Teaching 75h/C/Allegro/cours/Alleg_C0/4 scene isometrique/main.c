#include <allegro.h>
#include <math.h>
#include <stdio.h>

/// CONSTANTES

// Nombre de briques graphiques différentes
#define NIMAGE_OBJET 5

// Taille de la matrice 3D contenant la description de la scène
#define SIZE_X 10
#define SIZE_Y 10
#define SIZE_Z 3

// facteur d'echelle entre les cases (voxels) et les unités de pixel
#define ECHELLE 16


/// VARIABLES GLOBALES

// Tableau des images (BITMAPS) utilisées par les objets
BITMAP *tabImageObjet[NIMAGE_OBJET];

// Page pour l'assemblage de la scène : BUFFER
BITMAP *page;


/// PROTOTYPES DES SOUS-PROGRAMMES

// Regroupe les initialisations d'allegro, mode graphique, clavier, souris
// Termine le programme (avec message) en cas d'échec
void lancerToutAllegro(int largeur, int hauteur);

// Fonctionne comme load_bitmap sauf qu'il ne prend pas NULL en 2ème paramètre
// et qu'il termine le programme (avec message) en cas d'échec
BITMAP *chargerImage(char *nomFichierImage);

// Fonction de projection 3D -> 2D
void projection(int *xe, int *ye, int x, int y, int z);

// Chargement de scène
void chargerScene3D(unsigned char mat[SIZE_Z][SIZE_Y][SIZE_X], char *nomFichier);

// Affichage de scène
void afficherScene3D(unsigned char mat[SIZE_Z][SIZE_Y][SIZE_X]);



/// Programme principal
int main(int argc, char *argv[])
{
    /// DECLARATIONS DES VARIABLES DU MAIN

    // Dans cette matrice 3D 0 indique "espace vide"
    // 1 indique image 1 (case 0 du tableau image)
    // 2 indique image 2 (case 1 du tableau image)
    // ...
    unsigned char mat[SIZE_Z][SIZE_Y][SIZE_X];

    // Position du roi
    int xroi=9,yroi=0,zroi=2;

    /// INITIALISATION ALLEGRO et services
    lancerToutAllegro(800,600);

    /// AVANT BOUCLE JEU : initialisations et chargement des données

    // CREATION DU BUFFER D'AFFICHAGE à la taille de l'écran
    page=create_bitmap(SCREEN_W,SCREEN_H);
    clear_bitmap(page);

    // charger les images des "objets"
    tabImageObjet[0]=chargerImage("images/iso_cube1.bmp");
    tabImageObjet[1]=chargerImage("images/iso_cube2.bmp");
    tabImageObjet[2]=chargerImage("images/iso_cube3.bmp");
    tabImageObjet[3]=chargerImage("images/iso_fou.bmp");
    tabImageObjet[4]=chargerImage("images/iso_roi.bmp");

    // charger la scene
    chargerScene3D(mat, "donnees/scene3D_1.txt");

    /// BOUCLE JEU
    while (!key[KEY_ESC])
    {
        /// Mise à jour des positions pour les objets animés

        // Le roi disparait... (provisoirement)
        mat[zroi][yroi][xroi]=0;
        // Deplacement du roi
        if (key[KEY_LEFT] && xroi>0 && mat[zroi][yroi][xroi-1]==0) xroi--;
        if (key[KEY_RIGHT] && xroi<SIZE_X-1 && mat[zroi][yroi][xroi+1]==0) xroi++;
        if (key[KEY_UP] && yroi>0 && mat[zroi][yroi-1][xroi]==0) yroi--;
        if (key[KEY_DOWN] && yroi<SIZE_Y-1 && mat[zroi][yroi+1][xroi]==0) yroi++;
        // Le roi tombe ?
        while (zroi>0 && mat[zroi-1][yroi][xroi]==0) zroi--;
        // Placement du roi dans la matrice à sa nouvelle position
        // (si il n'y a pas eu déplacement il réapparait au même endroit)
        mat[zroi][yroi][xroi]=5;

        /// Assemblage de la scène sur le BUFFER
        //  Pas de décor de fond : effacer le BUFFER
        clear_bitmap(page);

        //  On pose les différents éléments
        afficherScene3D(mat);

        /// affichage du buffer à l'écran
        blit(page,screen,0,0,0,0,SCREEN_W,SCREEN_H);

        /// une pause pour temporiser l'enchaînement des images
        /// comme les déplacements se font case par case il faut ralentir
        /// mais ce n'est PAS une bonne solution de ralentir à ce niveau
        /// il faut réfléchir à des déplacements plus progressifs avec une pause globale plus courte
        rest(200);        // ( 200 ms -> à peu près 5 images/s )
    }

    /// TERMINER LE PROGRAMME
    //  Rien de spécial à faire ici pour l'instant
    //  Les BITMAPs réservées en mémoire avec create_bitmap ou load_bitmap
    //  seront automatiquement libérées en terminant le main.

    return 0;
}
END_OF_MAIN();


/// DEFINITIONS DES SOUS-PROGRAMMES

// Fonction de projection 3D -> 2D
void projection(int *pxe, int *pye, int x, int y, int z)
{
    *pxe = 2*x - 2*y + SCREEN_W/2;
    *pye = x + y - 2*z + SCREEN_H/3;
}

// Affichage de scène
void afficherScene3D(unsigned char mat[SIZE_Z][SIZE_Y][SIZE_X])
{
    int x, y, z;
    int xe, ye;
    BITMAP *img;

    // Compte tenu du choix de coordonnées ce parcours
    // affichera en 1er les objets cachés par les suivants
    // ( à condition que chaque objet soit bien dans un cube... )
    /// On affiche d'abord d'arrière en avant dans le plan et ensuite
    /// (dans la boucle interne) de bas en haut
    /// car les objets qui dépassent le format du cube
    /// (roi et fou) dépassent en hauteur (testez les alternatives...)
    for (y=0; y<SIZE_Y; y++)
        for (x=0; x<SIZE_X; x++)
            for (z=0; z<SIZE_Z; z++)
                if ( mat[z][y][x]!=0 )  // Le code 0 est utilisé pour indiquer "rien"
                {
                    // Conversion 3D -> 2D
                    projection(&xe, &ye, ECHELLE*x, ECHELLE*y, ECHELLE*z);

                    // Pointeur sur l'image concernée... attention à l'indice de l'image
                    // (dans la matrice +1 par rapport aux indices du tableau images)
                    img= tabImageObjet[ mat[z][y][x]-1 ];

                    // On dessine en 2D. Positionnement par rapport "pied" image
                    draw_sprite(page, img, xe-img->w/2, ye-img->h);
                }
}

// Chargement de scène
void chargerScene3D(unsigned char mat[SIZE_Z][SIZE_Y][SIZE_X], char *nomFichier)
{
    FILE *fp;
    int x, y, z, val;

    // Ouverture en lecture du fichier contenu de la matrice 3D
    fp=fopen(nomFichier,"r");
    if (fp==NULL)
    {
        allegro_message("Catastrophe, j'ai un besoin vital du fichier %s\nmais je n'arrive pas a le trouver ou a l'ouvrir", nomFichier);
        allegro_exit();
        exit(EXIT_FAILURE);
    }

    for (z=0; z<SIZE_Z; z++)
        for (y=0; y<SIZE_Y; y++)
            for (x=0; x<SIZE_X; x++)
            {
                fscanf(fp,"%d",&val);
                mat[z][y][x]=val;
            }

    fclose(fp);
}



///  ------------  AUXILIAIRES ------------------

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
