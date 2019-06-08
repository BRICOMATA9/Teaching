#include "projet.h"

// Allouer un perso, initialiser les champs, charger son image
t_perso *creerPerso()
{
    t_perso *p;

    // Allocation
    p=(t_perso *)malloc(1*sizeof(t_perso));

    // Pour x y et orient on met des valeurs par défaut...
    // ( sera ré-initialisé avant chaque démarrage d'une scène )
    p->x=SCREEN_W/2;
    p->y=SCREEN_H/2;
    p->orient=0;

    // Vitesses de déplacement
    p->depx=6;
    p->depy=2;

    // Chargement image
    p->img=chargerImage("images/lapin.bmp");

    // Retourner le perso prêt à l'emploi !
    return p;
}

// Affichage du perso (sur le buffer)
void afficherPerso(t_perso *p)
{
    BITMAP *img;   // Adresse de l'image du perso

    // Ici il ne s'agit pas d'une copie de l'image !
    // on veut juste mettre son adresse dans une variable temporaire
    // pour manipuler plus facilement le code après
    img=p->img;

    // Selon l'orientation on "retourne" à l'affichage (symétrie)
    if (p->orient==0)
        draw_sprite(page, img, p->x - img->w/2, p->y - img->h);
    else
        draw_sprite_h_flip(page, img, p->x - img->w/2, p->y - img->h);
}

// Mouvements interactifs du perso
void bougerPerso(t_perso *p)
{
    BITMAP *img;

    if (key[KEY_LEFT])   // GAUCHE
    {
        p->x= p->x - p->depx;
        p->orient=0;
    }

    if (key[KEY_RIGHT])  // DROITE
    {
        p->x= p->x + p->depx;
        p->orient=1;
    }

    if (key[KEY_UP])     // HAUT
        p->y= p->y - p->depy;

    if (key[KEY_DOWN])   // BAS
        p->y= p->y + p->depy;


    // Verification des bords de la zone d'évolution du perso
    img = p->img;
    if (p->x - img->w/2 < 0)
        p->x = img->w/2;

    if (p->x + img->w/2 >= SCREEN_W)
        p->x = SCREEN_W-img->w/2;

    if (p->y < 2*SCREEN_H/3)
        p->y = 2*SCREEN_H/3;

    if (p->y >= SCREEN_H)
        p->y = SCREEN_H;
}

