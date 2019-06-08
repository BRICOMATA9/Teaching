#include <stdio.h>
typedef struct {
	int deg;
	int c[10];
} polynome;
polynome lire() {
	polynome p;
	scanf("%d", &p.deg);
	int i;
	for (i = 0; i <= p.deg; i++) {
		printf("degré N°= %d\n", i);
		scanf("%d", &p.c[i]);
	}
	return (p);
}
void affich(polynome p) {
	int i;
	for (i = p.deg; i > 0; i--) {
		printf("%d x^%d+ ", p.c[i], i);
	}
	printf("%d\n", p.c[0]);
}
main() { affich(lire()); }
