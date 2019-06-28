#include <stdio.h>
#include <stdlib.h>

/*typedef struct maillon t_maillon;*/
typedef struct maillon {
	float dat;
	struct maillon *svt;
} t_maillon;

/*typedef struct liste t_liste;*/
typedef struct liste {
	struct maillon *maillon;
} t_liste;


/*#include <stdio.h>*/
/*#include <stdlib.h>*/
/*typedef struct maillon *liste;*/
/*struct maillon {*/
/*	int dat;*/
/*	liste svt;*/
/*};*/


/*void ajout(t_liste *l, int e)*/
/*{*/
/*	t_liste n = malloc(sizeof(t_liste));*/
/*	n->dat = e;*/
/*	n->svt = *l;*/
/*	*l = n;*/
/*}*/

main() /***************************************************************/
{
/*	t_liste l = NULL;*/
/*	ajout(l,4);*/
}






