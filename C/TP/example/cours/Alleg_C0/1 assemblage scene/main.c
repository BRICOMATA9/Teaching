#include <allegro.h>

/// Programme principal
int main(int argc, char *argv[])
{
    /// DECLARATIONS DES VARIABLES DU MAIN

    // Graphismes chargés depuis des fichiers .bmp
    BITMAP *decor;
    BITMAP *arbre;
    BITMAP *maison;
    BITMAP *soleil;

    /// INITIALISATION ALLEGRO et services
    allegro_init();
    install_keyboard();
    install_mouse();

    /// OUVERTURE MODE GRAPHIQUE (ouverture fenêtre allegro)
    set_color_depth(desktop_color_depth());
    if (set_gfx_mode(GFX_AUTODETECT_WINDOWED,800,600,0,0)!=0)
    {
        allegro_message("probleme mode graphique");
        allegro_exit();
        exit(EXIT_FAILURE);
    }
    show_mouse(screen); // Affiche pointeur de souris en mode allegro


    /// Chargement des données images (rien de visible pour l'instant)

    // !!! pour les chargements il faudra ajouter un code de test... !!!
    //  ( load_bitmap retourne NULL en cas d'échec du chargement )

    // charger image de fond
    decor=load_bitmap("images/decor.bmp",NULL);

    // charger les images des "objets"
    arbre=load_bitmap("images/arbre.bmp",NULL);
    maison=load_bitmap("images/maison.bmp",NULL);
    soleil=load_bitmap("images/soleil.bmp",NULL);

    /// EXEMPLE DE CONSTRUCTION GRAPHIQUE DIRECTEMENT A L'ECRAN
    /// Assemblage de la scène sur screen
    //  On pose les différents éléments, du plus éloigné au plus proche
    blit(decor,screen,0,0,0,0,SCREEN_W,SCREEN_H);
    draw_sprite(screen,soleil,50,65);
    draw_sprite(screen,arbre,490,330);
    draw_sprite(screen,maison,450,350);
    draw_sprite(screen,arbre,150,370);
    draw_sprite(screen,arbre,330,400);


    /// BOUCLE D'ATTENTE (appuyer sur Echap pour sortir)
    while (!key[KEY_ESC])
    {

    }

    /// TERMINER LE PROGRAMME
    //  Rien de spécial à faire ici pour l'instant
    //  Les BITMAPs réservées en mémoire avec create_bitmap ou load_bitmap
    //  seront automatiquement libérées en terminant le main.

    return 0;
}
END_OF_MAIN();
/// NE PAS OUBLIER CET INDICATEUR DE FIN DE MAIN (bricolage Allegro)

