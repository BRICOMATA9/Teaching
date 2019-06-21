#include<stdio.h>
#include<stdlib.h>
typedef struct ne* liste;
typedef struct ne {int elm;liste svt;}noeud;
void inser(liste *tete,int e)
{
 liste new=(liste)malloc(sizeof(noeud));
    new->elm=e;
    new->svt=*tete;
    *tete=new;
}
void insert(liste*tete,int e)
{
 if(*tete==NULL)inser(tete,e);
 else
 {
  liste new=(liste)malloc(sizeof(noeud));
  new->elm=e;
  new->svt=(*tete)->svt;
  (*tete)->svt=new;
 }
}
void inserertete(liste *tete,int e)
{
 if(e==0) inser(tete,e);
  else
   {
    inser(tete,e);
    scanf("%d",&e);
    inserertete(tete,e);
   }
}
void affichage(liste l)
{
 if (l->svt==NULL) printf("%d",l->elm);
  else {printf("%d",l->elm);affichage (l->svt);}
}
main()
{
liste l=NULL;
int e;
scanf("%d",&e);
inserertete(&l,e);
affichage(l);
}
