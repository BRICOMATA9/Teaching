#include <stdio.h>
#include <stdlib.h>
main() {
	int **p, i, j, n, m;
	scanf("%d", &n);
	p = (int **)malloc(n * sizeof(int *));
	scanf("%d", &m);
	for (i = 0; i < n; i++) {
		*(p + i) = (int *)malloc(m * sizeof(int));
		for (j = 0; j < m; j++)
			scanf("%d", *(p + i) + j);
	}
	for (i = 0; i < n; i++) {
		for (j = 0; j < m; j++)
			printf("%d", p[i][j]);
		printf("\n");
	}
}
