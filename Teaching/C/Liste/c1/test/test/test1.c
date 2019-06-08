#include <stdio.h>
#include <string.h>
const n = 10;
main() {
	typedef char str[20];
	typedef str nm[10];
	int j, psave;
	str prem;
	nm nom;
	char ch;
	printf(" \nprogramme qui sit 10 nom et donne la place du \n ");
	printf("premier dans l'ordre alphabetique \n\n\n ");
	printf(" donnez les %d noms : \n ", n);
	for (j = 0; j < n; j++)
		;
	gets(nom[j]);
}
strcpy(prem, nom[0]);
place = 0;
for (j = 1; j < n; j++)
	if (strcmp(nom[j], prem) < 0) {
		strcpy(prem, nom[j]);
		place = j + 1;
	}
printf(" le premier nom dans l'ordre alphabetique est ");
puts(prem);
printf("\nla position de ce nom est : %d \n\n ", place);
printf(" appuyez sur une touche pour suitter ");
ch = getchar();
}
