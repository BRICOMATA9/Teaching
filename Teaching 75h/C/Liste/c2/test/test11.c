#include<stdio.h>
main()
{
int t[10][20],i,j,n,m,a[10];
scanf("%d",&n);
scanf("%d",&m);
for(i=0;i<n;i++)
for (j=0;j<m;j++)
scanf("%d",&t[i][j]);
for (i=0;i<n/2;i++)
 for(j=0;j<m;j++)
 {
 a[j]=t[i][j];
 t[i][j]=t[n-1-i][j];
 t[n-1-i][j]=a[j];
 }
for(i=0;i<n;i++)
{
for (j=0;j<m;j++)
printf("%d ",t[i][j]);
printf("\n");
}
}

 

 

