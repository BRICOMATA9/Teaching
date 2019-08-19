#include <stdio.h>
main() {
	int i, j, min, x = 0, y = 0, t[20][30], aide, n, m, k, l;
	scanf("%d", &n);
	scanf("%d", &m);
	for (i = 0; i < n; i++)
		for (j = 0; j < m; j++)
			scanf("%d", &t[i][j]);
	for (x = 0; x < n; x++) {
		for (y = 0; y < m; y++) {
			min = t[i][j];
			i = x;
			while (i < n) {
				j = y;
				while (j < m) {
					if (t[i][j] < min) {
						min = t[i][j];
						k = i;
						l = j;
					}
					j++;
				}
				i++;
			}
			aide = t[x][y];
			t[x][y] = t[k][l];
			t[k][l] = aide;
		}
	}
	for (i = 0; i < n; i++) {
		for (j = 0; j < m; j++)
			printf("%d ", t[i][j]);
		printf("\n");
	}
}
