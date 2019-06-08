#include <stdio.h>
typedef struct {
	int re;
	int im;
} complex;
complex init() {
	int a, b;
	complex p;
	scanf("%d%d", &a, &b);
	p.re = a;
	p.im = b;
	return (p);
}
void affich(complex c) { printf("%d %d\n", c.re, c.im); }
int comp(complex x, complex y) {
	if ((x.re == y.re) && (x.im == y.im)) {
		return (1);
	} else
		return (0);
}
complex som(complex x, complex y) {
	complex s;
	(s.re) = (x.re) + (y.re);
	(s.im) = (x.im) + (y.im);
	return (s);
}

main() {
	int i;
	complex c = init();
	complex d = init();
	scanf("%d", &i);
	switch (i) {
	case 1:
		affich(c);
		break;
	case 2:
		affich(d);
		break;
	case 4: {
		int m = comp(c, d);
		printf("%d\n", m);
	}
	case 3: {
		complex s = som(c, d);
		break;
		printf("%d %d\n", s.re, s.im);
	}
	default:
		printf("ereur\n");
	}
}
