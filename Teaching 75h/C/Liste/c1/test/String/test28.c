#include <stdio.h>
#include <stdlib.h>
#include <string.h>
main() {
	int i;
	char *m;
	m = (char *)malloc(21);
	scanf("%s", m);
	printf("%s", m);
	char p[strlen(m) + 1];
	for (i = 0; i < strlen(m); i++)
		*(p + i) = m[i];
	*(p + i) = '\0';
	printf("%s\n", p);
}
