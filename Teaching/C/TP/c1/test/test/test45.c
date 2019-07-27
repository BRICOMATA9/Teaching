#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef char chaine[80];
typedef chaine matrice[100];
int identique(chaine S1, chaine S2) {
	int i, id = 1;
	if (strlen(S1) != strlen(S2))
		id = 0;
	else
		while (i < strlen(S1) && i < strlen(S2) && id == 1)
			if (S1[i] != S2[i])
				id = 0;
			else
				i++;
	return (id);
}
main() {
	matrice A;
	char s[] = {" "};
	int i, j, n;
	scanf("%d", &n);
	for (i = 0; i < n; i++)
		scanf("%s", A[i]);
	for (i = 0; i < n; i++)
		for (j = 1; j < n; j++)
			if (identique(A[i], A[j]))
				strcpy(A[j], s);
}
