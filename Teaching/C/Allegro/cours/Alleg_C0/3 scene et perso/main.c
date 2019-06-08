#include "projet.h"

/// Programme principal
int main(int argc, char *argv[])
{
    /// DECLARATIONS DES VARIABLES DU MAIN

    BITMAP *decor;
    t_tabObjet *tabObj;
    t_perso *monLapin;

    /// INITIALISATION ALLEGRO et services
    lancerToutAllegro(800,600);

    /// AVANT BOUCLE JEU : initialisations et chargement des données

    // charger les images des "objets" (valable pour tous le jeu)
    chargerTabImageObjet();

    // charger image de fond
    decor=chargerImage("images/decor_scene1.bmp");

    // charger les données des "objets" pour la scène
    tabObj=chargerTabObjet("donnees/objets_scene1.txt");

    // créer le perso et charger son image
    monLapin=creerPerso();

    // Positionner le perso en démarrage de scène
    monLapin->x=100;
    monLapin->y=400;
    monLapin->orient=1;

    /// BOUCLE JEU
    while (!key[KEY_ESC])
    {
        /// Mise à jour des positions pour les objets animés
        bougerPerso(monLapin);

        /// Assemblage de la scène sur le BUFFER

        //  En posant le décor sur le buffer on écrase son ancien contenu
        blit(decor,page,0,0,0,0,SCREEN_W,SCREEN_H);
        //  On pose les différents éléments derrière le perso
        afficherTabObjet(tabObj, 0, monLapin->y-1);
        //  On dessine le perso
        afficherPerso(monLapin);
        //  On pose les différents éléments devant le perso
        afficherTabObjet(tabObj, monLapin->y, SCREEN_H);

        /// affichage du buffer à l'écran
        blit(page,screen,0,0,0,0,SCREEN_W,SCREEN_H);

        /// une pause pour temporiser l'enchaînement des images
        rest(20);        // ( 20 ms -> à peu près 50 images/s )
    }

    return 0;
}
END_OF_MAIN();
