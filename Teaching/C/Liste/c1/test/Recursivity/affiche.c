#include <stdio.h>
typedef char chaine[20];
void affiche(chaine mot, int n, int i) {
	if (i <= n) {
		printf("%s\n", mot + i);
		affiche(mot, n, i + 1);
	}
}
main() {
	int n, i;
	chaine mot;
	scanf("%d%d", &n, &i);
	scanf("%s", mot);
	affiche(mot, n, i);
}
