#include <stdio.h>
#include <math.h>
#define MAX_NB 10000

int main (int argc, char *argv[])
{
   // le tableau des nombres
   int tab[MAX_NB] = { 2, 3, 5, 7 };
   int nb = 11, index = 4, racine, index2, x;

   // remplissage du tableau :
   retour:
   index2 = 0;
   nb += 2;
   racine = (int) sqrt (nb) + 1;
   while (racine >= tab[index2])
      {
      if (!(nb % tab[index2]))
      goto retour;
      index2++;
      }
   if (index < MAX_NB)
      {
      tab[index] = nb;
      index++;
      goto retour;
      }

   // affichage du tableau :
   for (x = 0; x < MAX_NB; x++)
      {
      if (!(x % 11))
         printf("%d\n",tab[x]);
      else
         printf("%d\t",tab[x]);
      }

   return 0;
}
