#include <stdio.h>
#include <string.h>
main() {
	char t[30], m[26];
	int i, j, b, k = 0;
	scanf("%s", t);
	for (i = 0; i < strlen(t); i++) {
		b = 0;
		for (j = i + 1; j < strlen(t) && b == 0; j++)
			if (t[i] == t[j])
				b = 1;
		if (b == 0) {
			m[k] = t[i];
			k++;
		}
	}
	m[k] = '\0';
	printf("%s\n", m);
}
