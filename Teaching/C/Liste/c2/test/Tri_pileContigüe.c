/******************    PILES ****************/
#include<stdio.h>
#define max 100

typedef int typelem;
typedef struct { typelem t[max];
                 int sommet;
               } pile;
pile initpile()
{pile p;
 p.sommet=-1;
 return(p);
}
int pilevide(pile p)
{ if(p.sommet==-1) return 1 ;
  else return 0;
}
int pilepleine(pile p)
{ if (p.sommet==max) return 1;
  else return 0;
}
void empiler(pile *p, typelem x)
{ p->sommet++;
  p->t[p->sommet]=x;
}
void desempiler(pile *p, typelem *x)
{ *x=p->t[p->sommet];
  p->sommet--;
}
typelem sommetpile(pile p)
{
  return (p.t[p.sommet]);
}
/**********************************************************************************/

pile remplirpile()
{ int i,n; pile p=initpile(); typelem x;

  printf("Donner le nombre de valeurs a mettre dans la pile: ");
  scanf("%d",&n);

  printf("Donner %d nombre entiers\n",n);
  for (i=0;i<n;i++) {scanf("%d",&x);empiler(&p,x);}
  return(p);
}

void affichpile(pile p)
{  
     typelem x;
     while(!pilevide(p)){desempiler(&p,&x);printf("%d\t",x);}
}


pile TriPile(pile P)
{
    pile R=initpile(), S=initpile();  typelem x, maxi;

    while (!pilevide(P))
    {
        desempiler(&P,&maxi);
        while (!pilevide(P))
        {
            desempiler(&P,&x);
            if(x>maxi) {empiler(&R,maxi);maxi=x; }
            else empiler(&R,x);
        }
        empiler(&S,maxi);
        while (!pilevide(R))
        {
            desempiler(&R,&x); empiler(&P,x);
        }
    }
    return S;
}

void TriPile2(pile *P)
{
    pile R=initpile(), S=initpile();  typelem x, min;

    while (!pilevide(*P))
    {
        desempiler(P,&min);
        while (!pilevide(*P))
        {
            desempiler(P,&x);
            if(x<min) {empiler(&R,min);min=x; }
            else empiler(&R,x);
        }
        empiler(&S,min);
        while (!pilevide(R))
        {
            desempiler(&R,&x); empiler(P,x);
        }
    }
   while (!pilevide(S))
        {
            desempiler(&S,&x); empiler(P,x);
        } 
}

main()
{pile A;

 A=remplirpile();
 //A=TriPile(A);
 A=TriPile(A);
 printf("\n**************** Pile triee dans l'ordre croissant *******************\n\n");
 affichpile(A);
}

