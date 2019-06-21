#include <stdio.h>
main ()
{
int i,compteur;
for(i=1;i<=11;i++)
{ 
printf ("affiche 10 fois %d\n",i);
for(compteur=1;compteur<=10;compteur++)
{
printf ("%d ",i);
}
printf ("\n");
}
}
