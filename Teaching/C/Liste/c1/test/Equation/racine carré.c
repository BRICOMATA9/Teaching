#include <math.h>
#include <stdio.h>
#define NFOIS 5
main() {
	int i;
	float x;
	float racx;

	printf("Bonjour\n");
	printf("Je vais vous calculer %d racines carrées\n", NFOIS);

	for (i = 0; i < NFOIS; i++) {
		printf("donnez un nombre : ");
		scanf("%f", &x);
		if (x < 0, 0)
			printf("Le nombre %f ne possede pas de racine carrée\n", x);
		else {
			racx = sqrt(x);
			printf("Le nombre %f a pour racine carée : %f\n", x, racx);
		}
	}
	printf("travail terminé - Au revoir");
}
