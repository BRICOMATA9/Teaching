#include <allegro.h>
#include <time.h>

typedef struct acteur {
    int x, y;
    int dx, dy;
    int rayon;
    int couleur;
    int vivant;
} t_acteur;

typedef struct listeActeurs{
    int max;
    int n;
    t_acteur **tab;
} t_listeActeurs;

t_acteur * creerActeur();
t_listeActeurs * creerListeActeurs(int maxacteurs);
void actualiserActeur             (t_acteur *acteur);
int libreListeActeurs             (t_listeActeurs *la);
t_acteur * ajouterActeur          (t_listeActeurs *la);
void enleverActeur                (t_listeActeurs *la, int i);
void actualiserListeActeurs       (t_listeActeurs *la);

void dessinerActeur               (BITMAP *bmp,t_acteur *acteur);
void dessinerListeActeurs         (BITMAP *bmp,t_listeActeurs *la);
void dessinerCasesListeActeurs    (BITMAP *bmp,t_listeActeurs *la);

int main(){
    BITMAP *page;
    t_listeActeurs *acteurs;
    int probaNouveau=15;
    srand(time(NULL));
    allegro_init();
    install_keyboard();

    set_color_depth(desktop_color_depth());
    if (set_gfx_mode(GFX_AUTODETECT_WINDOWED,800,600,0,0)!=0){
        allegro_message("prb gfx mode");
        allegro_exit();
        exit(EXIT_FAILURE);
    }

    page=create_bitmap(SCREEN_W,SCREEN_H);
    acteurs=creerListeActeurs(100);
    while (!key[KEY_ESC]){
        clear_bitmap(page);
        if (rand()%100 < probaNouveau || key[KEY_ENTER])
            ajouterActeur(acteurs);

        actualiserListeActeurs(acteurs);
        dessinerListeActeurs(page,acteurs);
        if (key[KEY_SPACE])
            dessinerCasesListeActeurs(page,acteurs);
        blit(page,screen,0,0,0,0,SCREEN_W,SCREEN_H);
        rest(10);
    }

    return 0;
}
END_OF_MAIN();

t_acteur * creerActeur(){
    t_acteur *nouv;

    nouv=(t_acteur *)malloc(1*sizeof(t_acteur));
    nouv->rayon=rand()%20+20;
    nouv->x=SCREEN_W/2-nouv->rayon/2;
    nouv->y=SCREEN_H/2-nouv->rayon/2;

    do {
        nouv->dx=rand()%11-5;
        nouv->dy=rand()%11-5;
    } while (nouv->dx==0 && nouv->dy==0);

    nouv->couleur=makecol(rand()%128+128,rand()%128+128,rand()%128+128);
    nouv->vivant=1;

    return nouv;
}

void actualiserActeur(t_acteur *acteur){

    acteur->x=acteur->x+acteur->dx;
    acteur->y=acteur->y+acteur->dy;
    if (acteur->x+2*acteur->rayon<0 || acteur->x>SCREEN_W || acteur->y+2*acteur->rayon<0 || acteur->y>SCREEN_H )
        acteur->vivant=0;

}

void dessinerActeur(BITMAP *bmp,t_acteur *acteur){
    circlefill(bmp,acteur->x+acteur->rayon,acteur->y+acteur->rayon,acteur->rayon,acteur->couleur);
}

t_listeActeurs * creerListeActeurs(int maxacteurs){
    t_listeActeurs *nouv;
    int i;

    nouv=(t_listeActeurs *)malloc(1*sizeof(t_listeActeurs));
    nouv->max=maxacteurs;
    nouv->n=0;
    nouv->tab=(t_acteur **)malloc(maxacteurs*sizeof(t_acteur*));

    for (i=0;i<maxacteurs;i++)
        nouv->tab[i]=NULL;

    return nouv;
}

int libreListeActeurs(t_listeActeurs *la){
    return la->n < la->max;
}

t_acteur * ajouterActeur(t_listeActeurs *la){
    int i;
    t_acteur *acteur;

    if (la->n >= la->max)
        return NULL;

    acteur=creerActeur();

    i=0;
    while (la->tab[i]!=NULL && i<la->max)
        i++;

    if (i<la->max){
        la->tab[i]=acteur;
        la->n++;
    }
    else
        allegro_message("Anomalie gestion ajouterActeur : liste corrompue");

    return acteur;
}

void enleverActeur(t_listeActeurs *la,int i){

    if (la->tab[i]!=NULL){
        free(la->tab[i]);
        la->tab[i]=NULL;
        la->n--;
    }
}

void actualiserListeActeurs(t_listeActeurs *la){
    int i;

    for (i=0;i<la->max;i++)
        if (la->tab[i]!=NULL){
            actualiserActeur(la->tab[i]);
            if (!la->tab[i]->vivant){
                enleverActeur(la,i);
            }
        }
}

void dessinerListeActeurs(BITMAP *bmp,t_listeActeurs *la){
    int i;
    for (i=0;i<la->max;i++)
        if (la->tab[i]!=NULL)
            dessinerActeur(bmp,la->tab[i]);

}

void dessinerCasesListeActeurs(BITMAP *bmp,t_listeActeurs *la){
    int i;

    for (i=0;i<la->max;i++){
        textprintf_ex(bmp,font,8*i,0,makecol(255,255,255),0,"%d",i/10);
        textprintf_ex(bmp,font,8*i,8,makecol(255,255,255),0,"%d",i%10);
        if (la->tab[i]!=NULL)
            rectfill(bmp,8*i,16,8*(i+1),32,makecol(255,0,0));
        else
            rectfill(bmp,8*i,16,8*(i+1),32,makecol(0,255,0));
    }
}




