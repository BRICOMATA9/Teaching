#include <stdio.h>
typedef struct ne *list;
typedef struct ne {
	int elm;
	list svt;
} noeud;
list creer() {
	list l;
	l = (list)malloc(sizeof(noeud));
	return (l);
}
main() {
	list p = creer();
	(*p).elm = 5;
	printf("%d", (*p).elm);
}
