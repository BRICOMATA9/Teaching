#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void str(char *s, char *t, int i) {
	int j, k;
	char *m = (char *)malloc(strlen(s) + strlen(t) + 1);
	for (j = 0, k = 0; k < i - 1; k++, j++)
		m[j] = s[k];
	for (i = 0; i < strlen(t); i++, j++)
		m[j] = t[i];
	for (; k < strlen(s); k++, j++)
		m[j] = s[k];
	m[j] = '\0';
	strcpy(s, m);
}
main() {
	char s[60], t[30];
	int i;
	scanf("%s%s", s, t);
	scanf("%d", &i);
	str(s, t, i);
	printf("%s\n", s);
}
