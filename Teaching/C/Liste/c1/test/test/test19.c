#include <stdio.h>
typedef struct {
	int nbr, t[100];
} vecteur;
vecteur lecture() {
	int i;
	vecteur v;
	scanf("%d", &v.nbr);
	for (i = 0; i < v.nbr; i++)
		scanf("%d", &v.t[i]);
	return v;
}
int distinct(vecteur v, int m[30], int *max) {
	int cpt = 0, i, j, b;
	*max = 1;
	for (i = 0; i < v.nbr; i++) {
		b = 1;
		for (j = i + 1; j < v.nbr; j++)
			if (v.t[i] == v.t[j])
				b++;
		if (b == 1) {
			m[cpt] = v.t[i];
			cpt++;
		}
		if (b > *max)
			*max = b;
	}
	return cpt;
}
void trier(vecteur *v) {
	int aide, i, j;
	for (i = 0; i < (*v).nbr - 1; i++)
		for (j = i + 1; j < (*v).nbr; j++)
			if ((*v).t[i] > (*v).t[j]) {
				aide = (*v).t[i];
				(*v).t[i] = (*v).t[j];
				(*v).t[j] = aide;
			}
}
void ecriture(vecteur v) {
	int i;
	for (i = 0; i < v.nbr; i++)
		printf("%d", v.t[i]);
}
int longplateau(vecteur v, int *a) {
	int max = 1, i, j, cpt;
	for (i = 0; i < v.nbr; i++) {
		cpt = 1;
		for (j = i + 1; j < v.nbr; j++)
			if (v.t[i] == v.t[j])
				cpt++;
		if (cpt > max) {
			max = cpt;
			*a = v.t[i];
		}
	}
	return max;
}
main() {
	int m[30], i, x, a;
	vecteur v = lecture();
	int k = distinct(v, m, &x);
	for (i = 0; i < k; i++)
		printf("%d", m[i]);
	printf("\n");
	trier(&v);
	ecriture(v);
	printf("\n");
	printf("%d\n", x);
	int y = longplateau(v, &a);
	printf("%d :%d\n", y, a);
}
