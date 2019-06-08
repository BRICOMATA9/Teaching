#include <allegro.h>
#include <time.h>

typedef struct acteur{
	int x,y;          // position du coin sup. gauche
	int dx,dy;        // vecteur deplacement
	int tx,ty;        // largeur hauteur
	int couleur;      // couleur (ne sera plus pertinent avec des sprites importés...)
	int type;         // type 0 laser, 1 missile (accélération horizontale)
	int comportement; // 0 normal déplacement, 1 explosion
	int cptexplo;     // temps depuis l'explosion
	int vivant;       // 0 mort (doit disparaitre de la liste), 1 vivant
} t_acteur;

typedef struct listeActeurs {
	int max;     // nombre maxi d'éléments
	int n;       // nombre effectif de pointeurs utilisés
	t_acteur **tab;
} t_listeActeurs;

typedef struct joueur {
	int x, y;	   // position
	int tx, ty;	 // taille
	int vit;	   // vitesse des déplacements (nombre de pixels)
	int cpttir0; // tempo armement 0
	int cpttir1; // tempo armement 1
	BITMAP *img; // sprite (image chargée)
} t_joueur;

typedef struct ennemi {
	int x, y;		 // position
	int dx, dy;	 // vecteur déplacement
	int tx, ty;	 // taille
	BITMAP *img; // sprite (image chargée)
} t_ennemi;

t_ennemi       *creerEnnemi       (char *nomimage);
t_acteur       *creerActeur       (int x, int y, int type);
t_listeActeurs *creerListeActeurs (int maxacteurs);
t_joueur       *creerJoueur       (char *nomimage);

void actualiserActeur      (t_acteur       *acteur  );
void actualiserListeActeurs(t_listeActeurs *la      );
void actualiserJoueur      (t_joueur       *joueur  ,t_listeActeurs *la);
void actualiserEnnemi      (t_ennemi       *ennemi  );

void dessinerActeur        (BITMAP *bmp       ,t_acteur       *acteur   );
void dessinerListeActeurs  (BITMAP *bmp       ,t_listeActeurs *la       );
void dessinerJoueur        (BITMAP *bmp       ,t_joueur       *joueur   );
void dessinerEnnemi        (BITMAP *bmp       ,t_ennemi       *ennemi   );

t_acteur* ajouterActeur     (t_listeActeurs *la, int x, int y, int type);
void      enleverActeur     (t_listeActeurs *la, int i);

void collisionActeur       (t_ennemi *ennemi  ,t_acteur *acteur);
void collisionListeActeurs (t_ennemi *ennemi  ,t_listeActeurs *la);

int main() {
	srand(time(NULL));
	allegro_init();
	install_keyboard();
	set_color_depth(desktop_color_depth());
	if (set_gfx_mode(GFX_AUTODETECT_WINDOWED, 800, 600, 0, 0) != 0) {
		allegro_message("prb gfx mode");
		allegro_exit();
		exit(EXIT_FAILURE);
	}

	BITMAP *page = create_bitmap(SCREEN_W, SCREEN_H);
	BITMAP *decor = load_bitmap("images/hotplanet.bmp", NULL);
	if (!decor) {
		allegro_message("pas pu trouver images/hotplanet.bmp");
		exit(EXIT_FAILURE);
	}
	
	t_joueur        *vaisseau  = creerJoueur("images/spaceship.bmp");
	t_ennemi        *cible     = creerEnnemi("images/deathstar.bmp");
	t_listeActeurs  *acteurs   = creerListeActeurs(100);
	
	int start = clock();
	while (!key[KEY_ESC]) {
		// ralentir sans bloquer le programme
		if (clock() > start + 10000) {
			start = clock();
			blit(decor, page, 0, 0, 0, 0, SCREEN_W, SCREEN_H);
			
			actualiserJoueur(vaisseau, acteurs);
			actualiserEnnemi(cible);
			actualiserListeActeurs(acteurs);
			
			collisionListeActeurs(cible, acteurs);
			
/*			draw_sprite(page, vaisseau->img, vaisseau->x, vaisseau->y);*/
			masked_blit(vaisseau->img, page, 0,0, vaisseau->x, vaisseau->y,vaisseau->tx, vaisseau->ty);
			draw_sprite(page, cible->img, cible->x, cible->y);
			
			dessinerListeActeurs(page, acteurs);
			
			blit(page, screen, 0, 0, 0, 0, SCREEN_W, SCREEN_H);
			rest(100);
		}
	}
	return 0;
}
END_OF_MAIN();

t_acteur *creerActeur(int x, int y, int type) {
	t_acteur *nouv;
	nouv               = (t_acteur *)malloc(1 * sizeof(t_acteur));
	nouv->x            = x;
	nouv->y            = y;
	nouv->type         = type;
	nouv->comportement = 0; //
	nouv->cptexplo     = 0; // pas encore explosé mais on initialise par sécurité
	nouv->vivant       = 1;

	switch (type) {
	// laser
	case 0:
		nouv->tx = 30;
		nouv->ty = 5;  
		nouv->dx = 10; // deplacement à droite
		nouv->dy = 0;  //pas de deplacement en haut en en bas
		nouv->couleur = makecol(255, 255, 0);
		break;
	// missile
	case 1:
		nouv->tx = 40;
		nouv->ty = 20;
		nouv->dx = 2;
		nouv->dy = rand() % 5 - 2; // petite dispersion dans la trajectoire des missiles :
		nouv->couleur = makecol(240, 220, 220);
		break;
	}
	return nouv;
}

void actualiserActeur(t_acteur *acteur) {
	acteur->x = acteur->x + acteur->dx;
	acteur->y = acteur->y + acteur->dy;
	if (acteur->type == 1 && acteur->dx < 14)
		acteur->dx++;
	if (acteur->x + acteur->tx < 0 || acteur->x > SCREEN_W || acteur->y + acteur->ty < 0 || acteur->y > SCREEN_H)
		acteur->vivant = 0;
	if (acteur->comportement == 1) {
		acteur->cptexplo++;
		if (acteur->cptexplo > 7)
			acteur->vivant = 0;
	}
}

void dessinerActeur(BITMAP *bmp, t_acteur *acteur) {
	if (acteur->comportement == 0) {
		switch (acteur->type) {
		case 0:
			rectfill(bmp, 
				acteur->x, 
				acteur->y, 
				acteur->x + acteur->tx,
				acteur->y + acteur->ty,
				acteur->couleur
			);
			break;
		case 1:
			ellipsefill(bmp, 
				acteur->x, 
				acteur->y + acteur->ty / 2, 
				2 * acteur->tx / 3, 
				acteur->ty / 2, 
				makecol(255, 100, 25)
			);
			ellipsefill(bmp, 
				acteur->x, 
					acteur->y + acteur->ty / 2, 
					acteur->tx / 3,
					acteur->ty / 3, 
					makecol(255, 200, 50)
				);
			triangle(bmp, 
				acteur->x, 
				acteur->y, 
				acteur->x, 
				acteur->y + acteur->ty,
				acteur->x + acteur->tx, acteur->y + acteur->ty / 2,
				acteur->couleur
			);
			break;
		}
	}
	else {
		switch (acteur->type) {
		case 0:
			circlefill(bmp, 
				acteur->x + acteur->tx / 2, 
				acteur->y + acteur->ty / 2,
				30 - 4 * acteur->cptexplo,
				makecol(255, 255 - 15 * acteur->cptexplo, 255 - 30 * acteur->cptexplo)
			);
			break;
		case 1:
			circlefill(
					bmp, 
					acteur->x + acteur->tx / 2, 
					acteur->y + acteur->ty / 2,
					60 - 6 * acteur->cptexplo,
					makecol(255 - 15 * acteur->cptexplo, 128 - 15 * acteur->cptexplo, 0)
				);
			break;
		}
	}
}

t_listeActeurs *creerListeActeurs(int maxacteurs) {
	t_listeActeurs *nouv;
	int i;
	nouv = (t_listeActeurs *)malloc(1 * sizeof(t_listeActeurs));
	nouv->max = maxacteurs;
	nouv->n = 0;
	nouv->tab = (t_acteur **)malloc(maxacteurs * sizeof(t_acteur *));
	for (i = 0; i < maxacteurs; i++)
		nouv->tab[i] = NULL;
	return nouv;
}

t_acteur *ajouterActeur(t_listeActeurs *la, int x, int y, int type) {
	int i;
	t_acteur *acteur;
	if (la->n >= la->max)
		return NULL;
	acteur = creerActeur(x, y, type);
	i = 0;
	while (la->tab[i] != NULL && i < la->max)
		i++;
	if (i < la->max) {
		// Accrocher le acteur à l'emplacement trouvé
		la->tab[i] = acteur;
		la->n++;
	}
	// Sinon c'est qu'il y a un problème de cohérence
	else
		allegro_message("Anomalie gestion ajouterActeur : liste corrompue");
	return acteur;
}

void enleverActeur(t_listeActeurs *la, int i) {
	// Vérifier qu'il y a bien un acteur accroché en indice i
	if (la->tab[i] != NULL) {
		// libérer la mémoire du acteur
		free(la->tab[i]);
		// marquer l'emplacement comme libre
		la->tab[i] = NULL;
		la->n--;
	}
}

// Gérer l'évolution de l'ensemble des acteurs
void actualiserListeActeurs(t_listeActeurs *la) {
	int i;
	// actualiser chaque acteur si un acteur n'est plus vivant, l'enlever de la liste
	for (i = 0; i < la->max; i++)
		if (la->tab[i] != NULL) {
			actualiserActeur(la->tab[i]);
			if (!la->tab[i]->vivant) {
				enleverActeur(la, i);
			}
		}
}

// Dessiner sur une bitmap l'ensemble des acteurs
void dessinerListeActeurs(BITMAP *bmp, t_listeActeurs *la) {
	int i;
	for (i = 0; i < la->max; i++)
		if (la->tab[i] != NULL)
			dessinerActeur(bmp, la->tab[i]);
}

// Gérer collision (éventuelle) entre un acteur (un tir) et un ennemi
void collisionActeur(t_ennemi *ennemi, t_acteur *acteur) {
	int vx, vy, d2;
	// si il n'explose déjà pas !
	if (acteur->comportement == 0) {
		// si il est dans la cible alors appeler destinActeur (explosion)
		// calcul du vecteur entre acteur et centre cible
		vx = acteur->x + acteur->tx / 2 - (ennemi->x + ennemi->tx / 2);
		vy = acteur->y + acteur->ty / 2 - (ennemi->y + ennemi->ty / 2);
		// calcul distance au carré au centre de la cible (Pythagore)
		// (on reste sur le carré pour éviter de calculer la racine)
		d2 = vx * vx + vy * vy;
		// si dans le disque alors destin...
		if (d2 < ennemi->tx * ennemi->tx / 4){
			acteur->dx /= 2;
			acteur->dy /= 2;
			acteur->comportement = 1;
			acteur->cptexplo = 0;
		}
	}
}

// Gérer les collisions entre les acteurs (tous les tirs) et un ennemi
void collisionListeActeurs(t_ennemi *ennemi, t_listeActeurs *la) {
	int i;
	// regarder pour chaque acteur...
	for (i = 0; i < la->max; i++)
		if (la->tab[i] != NULL)
			collisionActeur(ennemi, la->tab[i]);
}

// Allouer et initialiser un joueur
t_joueur *creerJoueur(char *nomimage) {
	t_joueur *nouv;
	// Allouer
	nouv = (t_joueur *)malloc(1 * sizeof(t_joueur));
	// Initialiser
	nouv->img = load_bitmap(nomimage, NULL);
	if (!nouv->img) {
		allegro_message("pas pu trouver %s", nomimage);
		exit(EXIT_FAILURE);
	}
	nouv->tx = nouv->img->w;
	nouv->ty = nouv->img->h;
	nouv->x = SCREEN_W / 4 - nouv->tx / 2;
	nouv->y = SCREEN_H / 2 - nouv->ty / 2;
	nouv->vit = 5;
	nouv->cpttir0 = 0;
	nouv->cpttir1 = 0;
	return nouv;
}

// Actualiser joueur (bouger interactivement et tirer...)
void actualiserJoueur(t_joueur *joueur, t_listeActeurs *la) {
	// Déplacements instantanés (pas d'inertie) gestion d'un blocage dans une zone écran (moitié gauche)
	if (key[KEY_LEFT]) {
		joueur->x -= joueur->vit;
		if (joueur->x < 0)
			joueur->x = 0;
	}
	if (key[KEY_RIGHT]) {
		joueur->x += joueur->vit;
		if (joueur->x + joueur->tx > SCREEN_W / 2)
			joueur->x = SCREEN_W / 2 - joueur->tx;
	}
	if (key[KEY_UP]) {
		joueur->y -= joueur->vit;
		if (joueur->y < 0)
			joueur->y = 0;
	}
	if (key[KEY_DOWN]) {
		joueur->y += joueur->vit;
		if (joueur->y + joueur->ty > SCREEN_H)
			joueur->y = SCREEN_H - joueur->ty;
	}

	// Gestion du tir...

	// incrémenter la tempo des tirs
	joueur->cpttir0++;
	joueur->cpttir1++;

	// si le joueur appui sur la gachette et arme ok...
	// espace = laser
	if (key[KEY_SPACE] && joueur->cpttir0 >= 5) {
		ajouterActeur(la, joueur->x + joueur->tx, joueur->y + joueur->ty / 2, 0);
		joueur->cpttir0 = 0;
	}
	// entrée = missile
	if (key[KEY_ENTER] && joueur->cpttir1 >= 10) {
		ajouterActeur(la, joueur->x + joueur->tx, joueur->y + joueur->ty / 2, 1);
		joueur->cpttir1 = 0;
	}
}

// Allouer et initialiser ennemi
t_ennemi *creerEnnemi(char *nomimage) {
	t_ennemi *nouv;
	// Allouer
	nouv = (t_ennemi *)malloc(1 * sizeof(t_ennemi));
	// Initialiser
	nouv->img = load_bitmap(nomimage, NULL);
	if (!nouv->img) {
		allegro_message("pas pu trouver %s", nomimage);
		exit(EXIT_FAILURE);
	}
	nouv->tx = nouv->img->w;
	nouv->ty = nouv->img->h;
	nouv->x = 3 * SCREEN_W / 4 - nouv->tx / 2;
	nouv->y = SCREEN_H / 2 - nouv->ty / 2;
	nouv->dx = 0;
	nouv->dy = 0;
	return nouv;
}

// Actualiser ennemi (bouger automatiquement au hasard dans la moitié droite...)
void actualiserEnnemi(t_ennemi *ennemi) {
	// proba de changement de déplacement : une chance sur 20
	if (rand() % 20 == 0) {
		// Nouveau vecteur déplacement
		ennemi->dx = rand() % 11 - 5;
		ennemi->dy = rand() % 11 - 5;
	}
	// contrôle des bords : ici on décide de rebondir sur les bords
	if ((ennemi->x < SCREEN_W / 2 && ennemi->dx < 0) || (ennemi->x + ennemi->tx > SCREEN_W && ennemi->dx > 0))
		ennemi->dx = -ennemi->dx;
	if ((ennemi->y < 0 && ennemi->dy < 0) || (ennemi->y + ennemi->ty > SCREEN_H && ennemi->dy > 0))
		ennemi->dy = -ennemi->dy;
	// calculer nouvelle position
	// nouvelle position = position actuelle + deplacement
	ennemi->x = ennemi->x + ennemi->dx;
	ennemi->y = ennemi->y + ennemi->dy;
}
