#include <stdio.h>
#include <stdlib.h>
typedef struct no *pile;
typedef struct no {
	int elm;
	pile svt;
} noeud;
pile creer() /****************************************creer*/
{
	pile l = (pile)malloc(sizeof(noeud));
	if (!l) {
		printf("erreur d'allocation");
		exit(-1);
	}
	return (l);
}
int sommet(pile p) {
	int x = p->elm;
	return (x);
}
int vide(pile p) {
	if (!p)
		return (0);
	else
		return (1);
}
void empiler(pile *l, int e) /***************************empiler en tete*/
{
	pile n = creer();
	n->elm = e;
	n->svt = *l;
	*l = n;
}
pile desempiler(pile l) /*****************************desempilerer la tete*/
{
	pile p = l;
	l = l->svt;
	return (l);
}
void ghiles(pile *l, int n) {
	int e;
	if (n == 0)
		;
	else {
		scanf("%d", &e);
		empiler(l, e);
		ghiles(l, n - 1);
	}
}
pile lifo() /******************************************LIFO*/
{
	pile l = NULL;
	int n;
	printf("le nbr d'elm");
	scanf("%d", &n);
	ghiles(&l, n);
	return (l);
}
void recherche1(pile l, int e) /*recher ds une pile trier*/
{
	if (!vide(l) || sommet(l) > e)
		printf("la valeur n'existe pas");
	else if (sommet(l) < e) {
		recherche1(desempiler(l), e);
	} else
		printf("la valeur existe");
}
int recherche2(pile l, int e) /*****************recherche*/
{
	if (!vide(l))
		return (0);
	else if (sommet(l) == e)
		return (1);
	else {
		recherche2(desempiler(l), e);
	}
}
void modifier(pile l, int x, int y) /************************modifier*/
{
	if (!vide(l))
		;
	else if (sommet(l) == x) {
		l = desempiler(l);
		empiler(&l, y);
		modifier(desempiler(l), x, y);
	} else {
		modifier(desempiler(l), x, y);
	}
}
void insert(pile l, int e) /************insertion ds une pile trier*/
{
	if (!vide(l))
		empiler(&l, e);
	else if (sommet(l) < e) {
		insert(desempiler(l), e);
	} else
		empiler(&l, e);
}
void suprimmer(pile *l, int e) /************************desempilermer**/
{
	if (!vide(*l))
		;
	else if (sommet(*l) == e) {
		*l = desempiler(*l);
		suprimmer(l, e);
	} else {
		*l = desempiler(*l);
		suprimmer(l, e);
	}
}
void affichage(pile l) /***********************************affichage*/
{
	if (!vide(l))
		;
	else {
		printf("%d ", sommet(l));
		affichage(desempiler(l));
	}
}
void tripile(pile *tete, pile p) {
	if (!(*tete)->svt)
		;
	else if (!p)
		tripile(&(*tete)->svt, (*tete)->svt);
	else if ((*tete)->elm > p->elm) {
		int q = (*tete)->elm;
		(*tete)->elm = p->elm;
		p->elm = q;
		tripile(tete, p->svt);
	} else
		tripile(tete, p->svt);
}
void tri(pile l) { tripile(&l, l); }
main() /***************************************************************/
{
	int n, b;
	pile l = lifo();
	scanf("%d", &n);
	suprimmer(&l, n);
	affichage(l);
	affichage(l);
}
