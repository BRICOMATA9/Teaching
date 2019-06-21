#include <stdio.h>
void convertir(int n) {
	if (n / 2 == 0) {
		printf("%d", n);
	} else {
		convertir(n / 2);
		printf("%d", n % 2);
	}
}
void calcule(int a, int b) {
	if (b == 1)
		printf("%d", a);
	else
		calcule(a * a, b - 1);
}
main() {
	int a, b;
	scanf("%d%d", &a, &b);
	calcule(a, b);
}
