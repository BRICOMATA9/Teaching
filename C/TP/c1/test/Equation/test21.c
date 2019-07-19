#include <stdio.h>
main() {
	double x, y;
	int a;
	scanf("%d", &a);
	y = 1;
	do {
		x = (y + a / y) / 2;
		y = x;
	} while (((x - y) >= 0.00000001) || ((y - x) >= 0.00000001));
	printf("%e\n", x);
}
