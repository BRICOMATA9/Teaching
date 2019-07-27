#include<stdio.h>
#include<stdlib.h>
#include<string.h>
typedef struct{int n;int*t;}vecteur;
vecteur vide ()
{
 vecteur p;
 (p).t=NULL;(p).n=0;
 return p;
}
vecteur allouer(int nbr)
{
 vecteur p;
 p.t=(int*)malloc(0);
 if((p.t)!=NULL) 
   {
     (p).n=nbr;
     return(p);
   }
  else 
   {
     printf("erreur");
     return vide();
   }
}
vecteur lire(vecteur a)
{
  int i;
  for (i=0;i<(a).n;i++) scanf ("%d",&(a).t[i]);
  return a;
}
void affiche (vecteur z)
{
  int i;
  for (i=0;i<(z).n;i++) printf ("%d ",(z).t[i]);
}
vecteur fonction(char*m1,char*m2)
{
 vecteur p;
 int i,j;
 for(i=0;i<strlen(m1);i++) 
  {
   j=0;
   if (strstr(m1+i,m2)!=NULL)
     {
       p.t=(int*)malloc(j+1);
       p.t[j]=*strstr(m1+i,m2);
       j++;
     }
  }
 p.n=j;
 return p;
}
main()
{
 int n;
 char m1[20],m2[20];
 scanf("%s%s",m1,m2);
 affiche(fonction(m1,m2));
}
