#include <stdio.h>
#include <stdlib.h>

/*typedef struct maillon l iste;*/
/*struct maillon {*/
/*	int dat;*/
/*	liste svt;*/
/*};*/

/*typedef struct maillon {*/
/*	int dat;*/
/*	struct maillon *svt;*/
/*} l iste;*/

struct maillon {
	int dat;
	struct maillon *svt;
};
typedef struct maillon *liste;
typedef liste* liste1;

void ajout(liste *l, int e){
	liste n = malloc(sizeof(liste));
	n->dat = e;
	n->svt = *l;
	*l = n;
}

/*void suprim(liste1 l) {*/
/*	liste p = l ;*/
/*	l  = (l )->svt;*/
/*	free(p);*/
/*}*/

/*void ghiles(liste1 l, int n) {*/
/*	int e;*/
/*	if (n != 0){*/
/*		scanf("%d", &e);*/
/*		ajout(l, e);*/
/*		ghiles(l, n - 1);*/
/*	}*/
/*}*/

/*void aghiles(liste1 l, int n) {*/
/*	int e;*/
/*	if (n != 0){*/
/*		scanf("%d", &e);*/
/*		ajout(l, e);*/
/*		aghiles(&(l )->svt, n - 1);*/
/*	}*/
/*}*/

/*liste lifo() {*/
/*	liste l = NULL;*/
/*	int n;*/
/*	printf("le nbr d'dat");*/
/*	scanf("%d", &n);*/
/*	ghiles(&l, n);*/
/*	return (l);*/
/*}*/

/*liste fifo() {*/
/*	liste l = NULL;*/
/*	int n;*/
/*	printf("le nbr d'dat");*/
/*	scanf("%d", &n);*/
/*	aghiles(&l, n);*/
/*	return (l);*/
/*}*/

/*void recherche1(liste l, int e) {/*recher ds une liste trier*/
/*	if (!l || l->dat > e)*/
/*		printf("la valeur n'existe pas");*/
/*	else if (l->dat < e)*/
/*		recherche1(l->svt, e);*/
/*	else*/
/*		printf("la valeur existe");*/
/*}*/

/*int recherche2(liste l, int e) {/*****************recherche*
/*	if (!l)*/
/*		return (0);*/
/*	else if ((l)->dat == e)*/
/*		return (1);*/
/*	else*/
/*		recherche2((l)->svt, e);*/
/*}*/

/*void modifier(liste l, int x, int y) {/************************modifier*/
/*	if (!l)*/
/*		;*/
/*	else if ((l)->dat == x) {*/
/*		modifier((l)->svt, x, y);*/
/*		(l)->dat = y;*/
/*	} else*/
/*		modifier((l)->svt, x, y);*/
/*}*/

/*void insert(liste l, int e) {/************insertion ds une liste trier*/
/*	if (!l)*/
/*		ajout(&l, e);*/
/*	else if ((l)->dat < e)*/
/*		insert((l)->svt, e);*/
/*	else*/
/*		ajout(&l, e);*/
/*}*/

/*void suprimmer(liste1 l, int e) {/***************************suprimmer**/
/*	if (!l )*/
/*		;*/
/*	else if ((l )->dat == e) {*/
/*		suprim(l);*/
/*		suprimmer(l, e);*/
/*	} else*/
/*		suprimmer(&(l )->svt, e);*/
/*}*/

/*void affichage(liste l) { /***********************************affichage*/
/*	if (!l)*/
/*		printf("liste vide");*/
/*	else if (l->svt == NULL)*/
/*		printf("%d", l->dat);*/
/*	else {*/
/*		printf("%d ", l->dat);*/
/*		affichage(l->svt);*/
/*	}*/
/*}*/
/*void triliste(liste1 tete, liste p) {*/
/*	if (!(*tete)->svt);*/
/*	else if (!p)*/
/*		triliste(&(*tete)->svt, (*tete)->svt);*/
/*	else if ((*tete)->dat > p->dat) {*/
/*		int q = (*tete)->dat;*/
/*		(*tete)->dat = p->dat;*/
/*		p->dat = q;*/
/*		triliste(tete, p->svt);*/
/*	} else*/
/*		triliste(tete, p->svt);*/
/*}*/
/*void tri(liste l) { triliste(&l, l); }*/
main() /***************************************************************/
{
/*	liste l = fifo();*/
/*	affichage(l);*/
/*	tri(l);*/
/*	affichage(l);*/
}
