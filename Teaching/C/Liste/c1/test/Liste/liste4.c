#include <stdio.h>
#include <stdlib.h>
typedef int matrice[20][50];
typedef struct ne *liste;
typedef struct ne {
	int elm, col;
	liste svt;
} noeud;
typedef struct {
	liste svt;
} no;
typedef no vecteur[20];
void construit(matrice a, int n, int m, vecteur v) {
	liste p, l = NULL;
	int i, j;
	for (i = 0; i < n; i++)
		for (j = 0; j < m; j++)
			if (a[i][j] != 0) {
				p = (liste)malloc(sizeof(noeud));
				p->elm = a[i][j];
				p->svt = l;
				p->col = j;
				l = p;
				v[i].svt = l;
			}
}
main() {
	matrice a;
	vecteur v;
	int i, j, n, m;
	scanf("%d%d", &n, &m);
	for (i = 0; i < n; i++)
		for (j = 0; j < m; j++)
			scanf("%d", a[i] + j);
	construit(a, n, m, v);
}
