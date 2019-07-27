#include <stdio.h>
typedef struct {
	int t[77];
	int so;
} pile;
pile init() {
	pile p;
	p.so = -1;
	return (p);
}
int vide(pile p) {
	if (p.so == -1)
		return (1);
	else
		return (0);
}
int plein(pile p) {
	if (p.so == 77)
		return (1);
	else
		return (-1);
}
int sommet(pile p) { return (p.so); }
void empiler(pile *p, int e) {
	(*p).so++;
	(*p).t[sommet(*p)] = e;
}
void desempiler(pile *p, int *e) {
	*e = (*p).t[(*p).so];
	(*p).so--;
}
pile remplir() {
	int n, i, e;
	pile p = init();
	printf("nbr d'elm\n");
	scanf("%d", &n);
	printf("les elms :\n");
	for (i = 0; i < n; i++) {
		scanf("%d", &e);
		empiler(&p, e);
	}
	return (p);
}
void affich(pile p) {
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
