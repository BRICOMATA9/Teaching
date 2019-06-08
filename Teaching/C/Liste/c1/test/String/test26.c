#include <stdio.h>
#include <string.h>
main() {
	int i = 0, b = 1;
	char t[30];
	scanf("%s", t);
	while (i < strlen(t) / 2 && b == 1) {
		if (t[i] != t[strlen(t) - i - 1])
			b = 0;
		i++;
	}
	printf("%d\n", b);
	i = 0;
	b = 1;
	while (i < strlen(t) / 2 && b == 1) {
		if (t[i] != t[strlen(t) / 2 + i])
			b = 0;
		i++;
	}
	printf("%d\n", b);
}
