#include <math.h>
#include <stdio.h>
main() {
	float A, B, C;
	float d;
	float e, f;
	scanf("%f", &A);
	scanf("%f", &B);
	scanf("%f", &C);
	if (A == 0) {
		e = -C / B;
	} else {
		d = B * B - 4 * A * C;
		if (d < 0) {
			printf("\npas de solution\n");
		} else if (d == 0) {
			e = -B / (2 * A);
		} else {
			e = (-B - sqrt(d)) / (2 * A);
			f = (-B + sqrt(d)) / (2 * A);
		}
	}
	printf("\n%f\n%f\n", e, f);
}
