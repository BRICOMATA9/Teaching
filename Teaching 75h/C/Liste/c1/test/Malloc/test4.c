#include <stdio.h>
#include <stdlib.h>
main() {
	int k, n, i, j;
	char **tab;
	scanf("%d\n%d\n", &k, &n);
	tab = (char **)malloc(k * sizeof(int));
	for (j = 0; j < k; j++) {
		tab[i] = (char *)malloc(n * sizeof(char));
		for (i = 0; i < n; i++) {
			scanf("%c\n", (tab[j] + i));
		}
	}
	for (j = 0; j < k; j++) {
		for (i = 0; i < n; i++) {
			printf("%c", *(tab[j] + i));
		}
		printf("\n");
	}
	for (i = 0; i < k; i++)
		free(tab[i]);
	free(tab);
}
