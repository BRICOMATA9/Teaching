#include <stdio.h>
main() {
	printf("boooonjour");
	int n, a[21], m, j, i;
	scanf("%d", &n);
	for (i = 0; i < n; i++)
		scanf("%d", &a[i]);
	i = 0;
	while (i < n - 1) {
		j = i + 1;
		while (j < n) {
			if (a[i] < a[j]) {
				m = a[i];
				a[i] = a[j];
				a[j] = m;
			}
			j++;
		}
		i++;
	}
	for (i = 0; i < n; i++)
		printf("%d\n", a[i]);
}
