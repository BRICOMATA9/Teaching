#include <stdio.h>
void ghiles(int *n) {
	printf("%d\n", *n);
	if (*n == 1)
		printf("zero\n");
	else {
		*n = *n - 1;
		ghiles(n);
	}
	printf("%d\n", *n);
}
main() {
	int n;
	scanf("%d", &n);
	ghiles(&n);
}
