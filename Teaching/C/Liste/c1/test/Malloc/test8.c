#include <stdio.h>
#include <stdlib.h>
const max_char = 9999;
const max_mot = 99;
main() {
	char **tab;
	int mot, i, j, z;
	int cpt[max_mot];
	char t[max_char];
	z = 0;
	mot = 0;
	gets(t);
	while (*(t + z) != '\0') {
		cpt[mot] = 0;
		while ((*(t + z) != '\0') && (*(t + z) != ' ')) {
			cpt[mot]++;
			z++;
		}
		while ((*(t + z) != '\0') && (*(t + z) == ' ')) {
			z++;
			cpt[mot]++;
		}
		mot++;
	}
	tab = (char **)malloc((mot + 1) * sizeof(char *));
	z = 0;
	for (i = 0; i < mot; i++) {
		tab[i] = (char *)malloc((cpt[i] + 1) * sizeof(char));
		for (j = 0; j < cpt[i]; j++) {
			tab[i][j] = t[z];
			z++;
		}
		tab[i][j] = '\0';
	}
	for (i = 0; i < mot; i++)
		printf("%s", tab[i]);
	printf("%d\n", mot);
	for (i = 0; i < mot; i++)
		free(tab[i]);
	free(tab);
}
