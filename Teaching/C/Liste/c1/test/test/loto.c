#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define N 49

void my_rand() {
	static int tab[N];
	int i;

	srand(time(NULL));
	for (i = 0; i < 5; i++)
		tab[i] = rand() % 50;

	srand(time(NULL));
	for (i = i; i < 7; i++)
		tab[i] = rand() % 12;

	for (i = 0; i < 7; i++)
		printf("%d ", tab[i]);
	printf("\n");
}

main() { my_rand(); }
