#include <stdio.h>
main() {
	int t[20], i, n, a, val, j, b, k, sup, inf, milieu;
	scanf("%d", &n);
	for (i = 0; i < n; i++)
		scanf("%d", t + i);
	scanf("%d", &val);
	b = 0;
	for (i = 0; i < n && b == 0; i++)
		if (t[i] == val)
			b = 1;
	if (b == 1)
		printf("%d existe\n", val);
	for (i = 1; i < n; i++) {
		for (j = i - 1, k = i; t[j] > t[k] && j >= 0; k--, j--) {
			a = t[j];
			t[j] = t[k];
			t[k] = a;
		}
	}
	for (i = 0; i < n; i++)
		printf("%d", t[i]);
	b = 0;
	if (val < t[0] || val > t[n - 1])
		b = 0;
	else {
		sup = t[n - 1];
		inf = t[0];
		while (sup > inf && b == 0) {
			milieu = (sup + inf) / 2;
			if (val > milieu)
				inf = milieu;
			else if (val < milieu)
				sup = milieu;
			else
				b = 1;
		}
	}
	if (b == 1)
		printf("\n%d existe\n", val);
	else
		printf("\n%d n'existe pas\n", val);
	for (i = 0; val > t[i] && i < n; i++)
		;
	for (j = n; j > i; j--)
		t[j] = t[j - 1];
	t[i] = val;
	for (i = 0; i < n + 1; i++)
		printf("%d", t[i]);
	printf("\n");
	for (i = 0; t[i] != val && i < n; i++)
		;
	for (; i < n + 1; i++)
		t[i] = t[i + 1];
	for (i = 0; i < n; i++)
		printf("%d", t[i]);
	printf("\n");
}
