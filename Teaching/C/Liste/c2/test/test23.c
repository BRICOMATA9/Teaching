#include<stdio.h>
main()
{
int n,m,i,j,x,y,a,min,k,l,t[10][10],z;
scanf ("%d%d",&n,&m);
for (i=0;i<n;i++)
 for(j=0;j<m;j++)
  scanf ("%d",&t[i][j]);
for (i=0;i<n;i++)
 for(j=0;j<m;j++)
  {
   z=j;
   min=t[i][j];x=i;y=j;
   for (k=i;k<n;k++)
   {
    for(l=z;l<m;l++) 
     if (t[k][l]<=min) {min=t[k][l];x=k;y=l;}
    z=0;
   }
   a=t[i][j];
   t[i][j]=t[x][y];
   t[x][y]=a;
  }
for (i=0;i<n;i++)
 {
  for(j=0;j<m;j++) printf ("%d ",t[i][j]);
  printf("\n");
 } 
}     
                                       
    
