#include <stdio.h>
void penible() {
	char reponse;
	printf("Voulez-vous continuer à vous enfoncer dans la récursion ?");
	scanf("%s", &reponse);
	if (reponse != 'N')
		penible();
}
main() { penible(); }
