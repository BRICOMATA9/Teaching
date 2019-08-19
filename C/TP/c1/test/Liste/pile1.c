#include <stdio.h>
#include <stdlib.h>
typedef struct no *pile;
typedef struct no {
	int elm;
	pile svt;
} noeud;
pile init() { return (NULL); }
int vide(pile p) {
	if (!p)
		return (1);
	else
		return (0);
}
int sommet(pile p) { return (p->elm); }
pile creer() {
	pile p = (pile)malloc(sizeof(noeud));
	if (!p) {
		printf("erreur d'allocation");
		exit(-1);
	}
	return (p);
}
void empiler(pile *p, int e) {
	pile q = creer();
	q->elm = e;
	q->svt = *p;
	*p = q;
}
void desempiler(pile *p, int *e) {
	pile q = *p;
	*e = (*p)->elm;
	*p = (*p)->svt;
	free(q);
}
pile remplir() {
	int i, n, e;
	pile p = init();
	printf("nbr d'elm");
	scanf("%d", &n);
	printf("les elms");
	for (i = 0; i < n; i++) {
		scanf("%d", &e);
		empiler(&p, e);
	}
	return (p);
}
void affich(pile q) {
	pile p = q;
	int e;
	while (!vide(p)) {
		desempiler(&p, &e);
		printf("%d", e);
	}
}
void tripile(pile *p) {
	int max, e;
	pile r = init(), q = init();
	while (!vide(*p)) {
		desempiler(p, &max);
		while (!vide(*p)) {
			desempiler(p, &e);
			if (e > max) {
				empiler(&q, max);
				max = e;
			} else
				empiler(&q, e);
		}
		empiler(&r, max);
		while (!vide(q)) {
			desempiler(&q, &e);
			empiler(p, e);
		}
	}
	while (!vide(r)) {
		desempiler(&r, &e);
		empiler(p, e);
	}
}
main() {
	pile p = init();
	p = remplir();
	tripile(&p);
	affich(p);
}
