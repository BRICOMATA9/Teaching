#include<stdio.h>
main()
{
int t[10][20],i,j,n,m,a,aide[20],k,l,max;
scanf ("%d%d",&n,&m);
for (i=0;i<n;i++)
 for(j=0;j<m;j++)
  scanf ("%d",&t[i][j]);
for (i=0;i<n/2;i++)
 for(j=0;j<m;j++)
 { 
  aide[j]=t[n-1-i][j];
  t[n-1-i][j]=t[i][j];
  t[i][j]=aide[j];
 }
for (i=0;i<n;i++)
 {
  max=t[i][0];
  for(j=0;j<m;j++) if (t[i][j]>=max) {max=t[i][j];k=i;l=j;}
  a=t[k][l];
  t[k][l]=t[i][i];
  t[i][i]=a;
 }
for (i=0;i<n;i++)
 {
  for(j=0;j<m;j++) printf ("%d",t[i][j]);
  printf("\n");
 } 
}


