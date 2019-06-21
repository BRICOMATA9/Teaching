#ifndef OBJET_H_INCLUDED
#define OBJET_H_INCLUDED

/// CONSTANTES

#define NIMAGE_OBJET 3


/// DEFINITIONS DES STRUCTURES

// Un objet est un élément du décor qui n'a pas vocation à bouger
typedef struct objet
{
    int x, y;    // Position de la base de l'objet à l'écran
    int iImg;    // Indice identifiant l'image de l'objet
                 // 0->arbre  1->maison  2->soleil
} t_objet;

// Un ensemble d'objets : regroupe tous les objets d'une scene
typedef struct tabObjet
{
    int nobj;       // Nombre d'objets dans le tableau
    t_objet *obj;   // Tableau des objets (alloué dynamiquement)
} t_tabObjet;


/// VARIABLES GLOBALES

// Tableau des images (BITMAPS) utilisées par les objets
extern BITMAP *tabImageObjet[NIMAGE_OBJET];


/// PROTOTYPES DES SOUS-PROGRAMMES

// Chargement des images des objets
void chargerTabImageObjet();

// Affichage d'un objet (sur le buffer)
void afficherObjet(t_objet *obj);

// Affichage de tous les objets de la scène entre ymin et ymax (inclus)
void afficherTabObjet(t_tabObjet *tabObj, int ymin, int ymax);

// Allocation et remplissage d'un ensemble d'objets à partir d'un fichier
t_tabObjet *chargerTabObjet(char *nomFichier);


#endif // OBJET_H_INCLUDED
