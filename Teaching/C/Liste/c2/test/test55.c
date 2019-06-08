#include<stdio.h>
#include<stdlib.h>
typedef struct no*liste;
typedef struct no {int elm;liste svt;}noeud;
void triliste(liste *tete,liste p)
{
 if(!(*tete)->svt);
  else 
   if(!p) triliste(&(*tete)->svt,(*tete)->svt);
    else 
     if((*tete)->elm>p->elm)
     {
      int q=(*tete)->elm;
          (*tete)->elm=p->elm;
          p->elm=q;
     }
     else
      triliste(tete,p->svt);
}
main()
{
}
