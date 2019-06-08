#include <stdio.h>
void fonction(int n, int u, int i) {
	printf("%d=NX%d AVANT %d=UX\n", n, i, u);
	if (n == 1)
		printf("%d=NH%d %d=UH\n", n, i, u);
	else if (u == 0) {
		printf("%d=NP%d AVANT %d=UP\n", n, i, u);
		fonction(n - 1, u - 1, i + 1);
		printf("%d=NP%d APRES %d=UP\n", n, i, u);
	} else {
		printf("%d=NI%d AVANT %d=UI\n", n, i, u);
		fonction(n - 1, u - 1, i + 1);
		printf("%d=NI%d APRES %d=UI\n", n, i, u);
	}
	printf("%d=NX%d APRES %d=UX\n", n, i, u);
}
main() {
	int n, u, i;
	scanf("%d%d%d", &n, &u, &i);
	fonction(n, u, i);
}
