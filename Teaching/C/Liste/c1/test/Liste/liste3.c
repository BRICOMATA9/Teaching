#include <stdio.h>
#include <stdlib.h>
typedef struct ne *liste;
typedef struct ne {
	int elm;
	liste svt;
} noeud;
typedef struct no *listeb;
typedef struct no {
	char nom[33];
	int taille;
	liste svt;
	listeb svtb;
} hbel;
liste suprime(liste l) {
	liste p = l;
	l = l->svt;
	free(p);
	return (l);
}
liste inser(liste tete, int e) {
	liste l = tete;
	liste r, p = (liste)malloc(sizeof(noeud));
	p->elm = e;
	if (l = NULL) {
		p->svt = NULL;
		l = p;
	} else
		while (e < l->elm && l != NULL) {
			r = l;
			l = l->svt;
		}
	if (tete == l) {
		p->svt = l;
		l = p;
	} else
		r->svt = p;
	p->svt = l;
}
liste creatliste(liste l, int taille) {
	int i, nbr = taille / 1024 + 1;
	liste p = NULL;
	for (i = 0; i < nbr; i++) {
		p = inser(p, l->elm);
		l = suprime(l);
	}
	return (p);
}
listeb ajout(char *np, int t, liste l) {

	main() {}
