/******************    PILES ****************/
#include<stdio.h>
#include<stdlib.h>
#include<conio.h>

 typedef int typelem ;
 typedef struct np *pile; 
 typedef struct np  { typelem valeur ;
                      pile svt ;
                    } noeud ;
                      
pile  initpile()
{ 
      return(NULL) ;
}

int  pilevide(pile p) 
{ if (p==NULL) return(1);
  else return(0);
} 

typelem  sommetpile(pile p)
{ typelem  x ;       
  x=p->valeur ;
   return(x) ;                                                             
}
pile creer_noeud()
{ pile p=(pile)malloc(sizeof(noeud));
  if (!p) { printf("erreur d'allocation\n");
            exit(-1);
           }    
 }
void empiler(pile *p, typelem x)         
{  pile temp = creer_noeud();
   temp ->valeur = x ;     
   temp->svt=*p ; *p=temp ;
 }

void desempiler(pile *p, typelem *x)         
{  pile temp ;
   *x = (*p)->valeur  ;     
    temp=*p ;
   *p=(*p)->svt; free(temp) ;
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


pile TriPile1(pile P)
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
{
 pile A;
 A=remplirpile();
 A=TriPile1(A);
 // ou bien  TriPile2(&A); 
 //pour l'exécuter il faut enlever le commentaire et mettre TriPile1 en commentaire
 printf("\n**************** Pile triee dans l'ordre croissant *******************\n\n");
 affichpile(A);
 getch();
}

