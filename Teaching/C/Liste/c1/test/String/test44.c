#include <stdio.h>
#include <string.h>
int voyelle(char s) {
	switch (s) {
	case 'a':
	case 'e':
	case 'i':
	case 'u':
	case 'y':
	case 'o':
		return (1);
	default:
		return (0);
	}
}
void insert(char *mot, int pos) {
	int i;
	for (i = strlen(mot); i >= pos; i--) {
		mot[i + 1] = mot[i];
	}
	mot[pos] = '-';
}
void divise(char *mot) {
	int i;
	for (i = 1; i < strlen(mot); i++) {
		if (!voyelle(mot[i]) && voyelle(mot[i - 1]) && voyelle(mot[i + 1])) {
			insert(mot, i);
			i++;
		}
		if (!voyelle(mot[i]) && !voyelle(mot[i + 1]) && voyelle(mot[i - 1]) &&
				voyelle(mot[i + 2])) {
			insert(mot, i + 1);
			i++;
		}
		if (!voyelle(mot[i]) && !voyelle(mot[i + 1]) && !voyelle(mot[i + 2])) {
			insert(mot, i + 2);
			i++;
		}
	}
}
main() {
	char mot[33];
	gets(mot);
	printf("%d\n", strlen(mot));
	divise(mot);
	printf("%d\n", strlen(mot));
	printf("%s\n", mot);
}
