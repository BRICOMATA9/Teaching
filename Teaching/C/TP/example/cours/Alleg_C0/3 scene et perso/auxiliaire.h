#ifndef AUXILIAIRE_H_INCLUDED
#define AUXILIAIRE_H_INCLUDED

// BUFFER d'affichage
extern BITMAP *page;

// Regroupe les initialisations d'allegro, mode graphique, clavier, souris
// Termine le programme (avec message) en cas d'échec
void lancerToutAllegro(int largeur, int hauteur);

// Fonctionne comme load_bitmap sauf qu'il ne prend pas NULL en 2ème paramètre
// et qu'il termine le programme (avec message) en cas d'échec
BITMAP *chargerImage(char *nomFichierImage);

#endif // AUXILIAIRE_H_INCLUDED
