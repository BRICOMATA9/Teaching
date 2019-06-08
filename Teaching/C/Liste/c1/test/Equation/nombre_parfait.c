#include <stdio.h>
main() {
	int c, s, i, k, t, r;
	printf("\n programme qui cerche tous les nombres prfaits \n\n ");
	printf("donnez la vzleur mzximale t : ");
	scanf("donnez la valeur maximale t : ");
	scanf("%d", &t);
	i = 1;
	c = 0;
	while (i <= t) {
		s = 0;
		for (k = 1; k <= (i / 2); k++) {
			r = i % k;
			if (r == 0)
				s = s + k;
		}
		if (s == i) {
			printf(" %d est parfait \n ", i);
			c++;
		}
		i++;
	}
	printf("\n");
	if (c == 0)
		printf("cet intervalle nef contient aucun nombre parfait \n");
	else
		printf("cet intevalle renferme %d nombre parfait (s) parfait", c);
	printf("\n\t\t\t\t good bay !!");
}
