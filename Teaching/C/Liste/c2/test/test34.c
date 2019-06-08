#include<stdio.h>
#include<stdlib.h>
typedef struct no*liste;
typedef struct no {int elm;liste svt;}noeud;
liste creer() /****************************************creer*/
{
 liste l=(liste)malloc(sizeof(noeud));
 if (!l)  
 { 
  printf("erreur d'allocation");
  exit(-1);
 }
return(l);
} 
void ajout (liste *l,int e)  /***************************ajout en tete*/
{
 liste n=creer();
 n->elm=e;
 n->svt=*l;
 *l=n;
}
void ajoutt (liste l,int e)  /****************ajout apres une adress*/
{
 liste n=creer();
 n->elm=e;
 n->svt=l->svt;
 l->svt=n;
}
void suprim (liste *l) /*****************************suprimer la tete*/
{
 liste p=*l;
 *l=(*l)->svt;
 free(p);
}
void suprimm (liste l)  /**********supression apres une adress*/
{
 liste p=l->svt;
 l->svt=p->svt;
 free(p);
}
liste fifo()   /******************************************FIFO*/
{   
 int i,n,e;
 liste p,l;
 printf("le nbr d'elm\n");
 scanf("%d",&n);
 printf("le premier elm\n");
 scanf("%d",&e);
 ajout(&l,e);
 l->svt=NULL;
 p=l;
 for(i=2;i<=n;i++)
 {
  printf("le %d eme elm\n",i);
  scanf ("%d",&e);
  ajoutt (p,e);
  p=p->svt;
 }
return(l);
}
liste lifo()  /******************************************LIFO*/
{
 liste l;
 int i,e,n;
 l=NULL;
 printf("le nbr d'elm");
 scanf("%d",&n);
 for(i=1;i<=n;i++)
 {
  printf("le %d eme elm",i);
  scanf("%d",&e);
  ajout(&l,e);
 }
 return(l);
}
void affich (liste l)  /************************************affichage*/
{
 while(l!=NULL)
 {
  printf("%d ",(l)->elm);
  l=(l)->svt;
 }
}
liste recherche1 (liste l,int e,liste *p)  /*recher ds une liste trier*/
{
 int sup=(l->elm)<e;
 while((l!=NULL)&&(sup==1))
 {
   if((l->elm)>=e)sup=0;
   else
   {
    *p=l;
    l=l->svt;
   }
 }
 return(l);
}
liste recherche2 (liste l,int e,liste *p) /*****************recherche*/
{
 int trouv=0;
 while ((trouv==0)&&(l!=NULL))
 {
  if (l->elm==e)trouv=1;
  else
  {
   *p=l;
   l=l->svt;
  }
 }
}
liste modifier (liste l,int x,int y) /************************modifier*/
{
 liste q;
 liste p=recherche2(l,x,&q);
 if (p==NULL) printf("la valeur n'existe pas");
 else p->elm=y;
 return(l);
} 
liste insert(liste l,int e)/************insertion ds une liste trier*/
{
 liste q;
 liste p=recherche1(l,e,&q);
 if(l==p) ajout (&l,e);
 else ajoutt(q,e);
 return(l);
}
liste suprimmer (liste l,int e)/***************************suprimmer**/
{
 liste q;
 liste p=recherche2(l,e,&q);
 if(!p) printf("la valeur n'existe pas");
 else if (l==p)suprim(&l);
      else suprimm(q);
 return(l);
}
void affichage (liste l)
{
 if(l->svt==NULL) printf("%d",l->elm);
  else {printf("%d ",l->elm);affichage (l->svt);}
}
int verifier(liste l,int e)
{
 while(l!=NULL&&l->elm!=e)l=l->svt;
 if (l)return(1);
 else return(0);
}
main()/***************************************************************/ 
{
liste l=fifo();
if ((l->svt)->elm == 1) printf("hhhh");
int e;
scanf("%d",&e);
int v=verifier(l,e);
affichage(l);
}
