#include <stdio.h>
#include <stdlib.h>
main() {
	char **tab;
	int lig, col, i, j;
	char t[26];
	puts("Nb mots ?");
	scanf("%d", &lig);
	tab = (char **)malloc(lig * sizeof(char *));
	for (i = 0; i < lig; i++) {
		col = -1;
		while (t[col] != ' ') {
			col += 1;
			scanf("%c", t + col);
		}
		tab[i] = (char *)malloc(col * sizeof(char));
		for (j = 0; j <= col; j++)
			tab[i][j] = t[j];
	}
	for (i = 0; i < lig; i++) {
		for (j = 0; j < col; j++) {
			printf("%c", *(*(tab + i) + j));
		}
		printf("\n");
	}
	for (i = 0; i < lig; i++)
		free(tab[i]);
	free(tab);
}
