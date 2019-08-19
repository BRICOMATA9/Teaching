#include <stdio.h> 

#include <stdlib.h>

#include <string.h> 

main() 

{ char INTRO[500]; 

 char *TEXTE[10]; 

 int i; 

 for (i=0; i<10; i++) 

 { gets(INTRO); 

 TEXTE[i] = malloc(strlen(INTRO)+1); /* Réservation de la mémoire */ 

 if (TEXTE[i]) /* S'il y a assez de mémoire */ 

 strcpy(TEXTE[i], INTRO); /* copier la phrase à l'adresse fournie par malloc */ 

 else 

 { /* sinon quitter le programme après un message d'erreur. */ 

 printf("ERREUR: Pas assez de mémoire \n"); 

 exit(-1); 

 } 

 }
for (i=0;i<10;i++);
puts (TEXTE[i]);
}
