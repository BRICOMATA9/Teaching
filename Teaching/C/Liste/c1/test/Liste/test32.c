#include <stdio.h>
#include <stdlib.h>
typedef struct no *liste;
typedef struct no {
	int elm;
	int svt;
} noued;
liste creer() {
	liste l = (liste)malloc(sizeof(noued));
	if (!l) {
		printf("erreur d'allocation\n");
		exit(-1);
	}
	return (l);
}
void ajout(liste *tete, int e) {
	main() {}
