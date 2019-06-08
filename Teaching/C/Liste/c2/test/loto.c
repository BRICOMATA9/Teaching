#include <stdlib.h>
#include <stdio.h>
#include <time.h>

#define N 49

void my_rand () {
	static int tab[N];
	int i;

	srand (time (NULL));
	for (i = 0; i < 4; i++)
		 tab[i] = rand() % 50;

	for (i = 0; i < 4; i++)
		printf ("%d\n", tab[i]);
}

main() {
	my_rand();
}
