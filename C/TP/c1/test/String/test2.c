#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define ROWS 5
#define COLS 3

int read_table(FILE *fp, int *tab, int rows, int cols, char sep) {
	char c;
	int z = 0, y = 0, x = 0;

	char buffer[11];
	memset(buffer, 0, 11);
	while ((c = getc(fp)) != EOF) {
		if (c >= 0x30 && c <= 0x39) {
			if (z < 11) {
				buffer[z] = c;
				z++;
			} else
				return -1;
		} else if (c == sep || c == '\n') {
			if (z > 0) {
				if (y >= cols)
					return -1;

				*(tab + x * cols + y) = atoi(buffer);
				memset(buffer, 0, 11);
				z = 0;
				y++;
			}
		} else
			return -1;

		if (c == '\n') {
			if (y < cols)
				return -1;
			y = 0;

			x++;
			if (x == rows)
				break;
		}
	}

	return 0;
}

int main(void) {
	FILE *fp = NULL;
	fp = fopen("./in", "r");
	if (fp != NULL) {
		int tab[ROWS][COLS];
		int rc = read_table(fp, (int *)tab, ROWS, COLS, ' ');
		if (rc == 0) {
			int x, y;
			for (x = 0; x < 5; x++) {
				for (y = 0; y < 3; y++)
					printf("%10i ", tab[x][y]);
				printf("\n");
			}
		}
		fclose(fp);
	}
	return 0;
}
