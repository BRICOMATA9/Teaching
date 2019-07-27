/******************    PILES ****************/
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define max 100


typedef char typelem[30];

typedef struct { typelem mot;  // les éléments de la pile s
                 int occ;
               } typelem2;

typedef struct { typelem t[max]; // pile p
                 int sommet;
               } pile;
typedef struct { typelem2 t[max]; // pile s
                 int sommet;
               } pile2;


pile initpile()/*****************************************************/
{pile p;
 p.sommet=-1;
 return(p);
}
int pilevide(pile p)/***********************************************/
{ if(p.sommet==-1) return 1 ;
  else return 0;
}
int pilepleine(pile p)/********************************************/
{ if (p.sommet==max) return 1;
  else return 0;
}
void empiler(pile *p, typelem x)/**********************************/
{ p->sommet++;
  strcpy(p->t[p->sommet],x);
}
void desempiler(pile *p, typelem x)/********************************/
{ strcpy(x,p->t[p->sommet]);
  p->sommet--;
}
char * sommetpile(pile p) // cette fonction ne peut pas retourner typelem qui est un tableau de char
{
  char* q=p.t[p.sommet];
  return (q);
}

void affichpile(pile p)/******************************************/
{
     typelem x; printf("\n\n");
     while(!pilevide(p)){desempiler(&p,x);printf("%s\t",x);}
}
///  Les fonctions de la pile S  *************************
pile2 initpile2() /************************************************/
{pile2 p;
 p.sommet=-1;
 return(p);
}
int pilevide2(pile2 p)/*******************************************/
{ if(p.sommet==-1) return 1 ;
  else return 0;
}
int pilepleine2(pile2 p)/********************************************/
{ if (p.sommet==max) return 1;
  else return 0;
}
void empiler2(pile2 *p, typelem2 x)/*********************************/
{ p->sommet++;
  p->t[p->sommet]=x;
}
void desempiler2(pile2 *p, typelem2 *x)/*****************************/
{ (*x)=p->t[p->sommet];
  p->sommet--;
}
typelem2 sommetpile2(pile2 p)
{
  return p.t[p.sommet];
}

void affichpile2(pile2 p)/*************************************************/
{
     typelem2 x;
     while(!pilevide2(p)){desempiler2(&p,&x);printf("%s\t%d\n",x.mot,x.occ);}
}

//******************************************************************************
pile Const_Pile()/**************************************************************/
{ int i,n,b; pile p=initpile(),r=initpile(); typelem x, mot;
  
  printf("Donner le nombre de mots a mettre dans la pile: ");
  scanf("%d",&n);

  printf("Donner %d mots\n",n);
  for (i=1;i<=n;i++)
  {  scanf("%s",mot); 
     while (!pilevide(p) && strlen(mot)> strlen(sommetpile(p)) )
     {
       desempiler(&p,x);
       empiler(&r,x);
     }
     empiler(&p,mot);

     while (!pilevide(r))
       {desempiler(&r,x); empiler(&p,x); }
   }
  printf("fin construction\n");return(p);
}

pile2 occur(pile p)/***********************************************************/
{ pile2 s=initpile2(); pile r=initpile(); typelem x,y; int nb; typelem2 z;

  while (!pilevide(p))
  {  desempiler(&p,x);nb=1;
     while (!pilevide(p))
      { desempiler(&p,y);
        if( strcmp(x,y)==0) nb++;
        else empiler(&r,y);
       }
      strcpy(z.mot,x); z.occ=nb; empiler2(&s,z);
      while (!pilevide(r))
      { desempiler(&r,x);
        empiler(&p,x);
      }
   }
   return s;

 }

main()/*******************************************************************/
{pile A; pile2 s;

 A=Const_Pile();
 printf("\n Nouvelle pile occurences des mots:\n");
 s=occur(A);
 affichpile2(s);
}

