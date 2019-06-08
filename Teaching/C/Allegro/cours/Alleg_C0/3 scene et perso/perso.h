#ifndef PERSO_H_INCLUDED
#define PERSO_H_INCLUDED

/// DEFINITIONS DES STRUCTURES

typedef struct perso
{
    int x, y;       // Coordonnées des pieds
    int orient;     // Orientation   0 gauche   1 droite
    int depx, depy; // Vitesses horizontales et verticales
    BITMAP *img;    // BITMAP représentant le perso
} t_perso;


/// PROTOTYPES DES SOUS-PROGRAMMES

// Allouer un perso, initialiser les champs, charger son image
t_perso *creerPerso();

// Affichage du perso (sur le buffer)
void afficherPerso(t_perso *p);

// Mouvements interactifs du perso
void bougerPerso(t_perso *p);

#endif // PERSO_H_INCLUDED
