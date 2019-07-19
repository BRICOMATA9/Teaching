#include <stdio.h>
main() {
	int i;
	char *t;
	char p[20];
	char a;
	scanf("%s", &a);
	scanf("%s", p);
	int b = 0;
	for (i = 0; p[i] != '\0' && b == 0; i++)
		if (p[i] == a) {
			b = 1;
			t = p + i;
		}
	if (b == 1)
		while (b == 1) {
			b = 0;
			for (i = i + 1; p[i] != '\0' && b == 0; i++)
				if (p[i] == a) {
					t = p + i;
					b = 1;
				}
		}
	else
		t = "NULL";
	printf("%s\n", t);
}
