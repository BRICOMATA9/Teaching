#include<stdio.h>
typedef int vect[60];
main() 
{
 vect v;
 int i,j,x,n;
 char c;
 printf("donnez le nombre\n");
 scanf("%d",&n);
 printf("\n le programme qui fait le tri par bulles \n\n ");
 printf(" \n donnez les %d element du vecteur \n\n ",n);
 for(i=0;i<n;i++)
 {
  printf("v[%d]=",i);
  scanf("%d",&x);
  v[i]=x;
 }
 i=n-1;
 while(i>0)
 {
  j=0;
  while(j<n-1)
  {
  if(v[j+1]<v[j])
  {
  x=v[j];
  v[j]=v[j+1];
  v[j+1]=x;
  }
  j++;
  }
  i--;
 }
 printf(" \n\n voici les elzments du tableau trié \n\n\t ");
 for (i=0;i<n;i++)
 printf("%d > ",v[i]);
}


