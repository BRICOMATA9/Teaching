#include <stdio.h>
#include <stdlib.h>
main() {
	char **tab;
	int lig, col, i, j;
	char t[777];
	puts("Nb mots ?");
	scanf("%d", &lig);
	tab = (char **)malloc(lig * sizeof(int));
	for (i = 0; i < lig; i++) {
		col = 0;
		while (t[col] != ' ') {
			scanf("%c", t + col);
			col += 1;
		}
		printf("%s", t);
		tab[i] = (char *)malloc((col + 1) * sizeof(char));
		for (j = 0; j < col; j++)
			tab[i][j] = t[j];
		tab[i][j] = '\0';
		col++;
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
