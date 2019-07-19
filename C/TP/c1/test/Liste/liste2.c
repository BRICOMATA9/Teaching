#include <stdio.h>
#include <stdlib.h>
typedef struct maillon *liste;
struct maillon {
	int elm;
	liste svt;
};


void inser(liste *tete, int e) {
	liste l, p, new = malloc(sizeof(liste));
	new->elm = e;
	for (l = *tete; l != NULL; p = l, l = l->svt)
		;
	new->svt = l;
	if (l == *tete)
		*tete = new;
	else
		p->svt = new;
}
liste fifo() {
	liste tete = NULL;
	int n, i, e;
	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf("%d", &e);
		inser(&tete, e);
	}
	return (tete);
}
void affich(liste l) {
	if (l->svt == NULL)
		printf("%d", l->elm);
	else {
		printf("%d ", l->elm);
		affich(l->svt);
	}
}
main() {
	liste t = fifo();
	affich(t);
}
