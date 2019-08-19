#include <stdio.h>
#include <stdlib.h>
typedef struct ne *liste;
typedef struct ne {
	int elm;
	liste svt, prd;
} noeud;
liste allouer() {
	liste l = (liste)malloc(sizeof(noeud));
	if (!l)
		exit(-1);
	return (l);
}
liste ajout(liste l, int e) {
	liste p = allouer();
	p->elm = e;
	p->svt = l;
	p->prd = NULL;
	if (l != NULL)
		l->prd = p;
	l = p;
	return (l);
}
liste binaire(int x) {
	liste l = NULL;
	while (x != 0) {
		l = ajout(l, x % 2);
		x = x / 2;
	}
	return (l);
}
void affiche(liste l) {
	while (l != NULL) {
		printf("%d", l->elm);
		l = l->svt;
	}
}
main() {
	int x;
	scanf("%d", &x);
	liste l = binaire(x);
	affiche(l);
}
