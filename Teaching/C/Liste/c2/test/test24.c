#include<stdio.h>
main()
{
int n,m,i,j,t[11][11],f[2][2],b;
scanf ("%d%d",&n,&m);
for (i=0;i<n;i++)
 for(j=0;j<m;j++)
  scanf ("%d",&t[i][j]);
for (i=0;i<2;i++)
 for(j=0;j<2;j++)
  scanf ("%d",&f[i][j]);
b=0;
for (i=0;i<n-1;i++)
 for(j=0;j<m-1;j++) if (t[i][j]==f[0][0]&&t[i+1][j]==f[1][0]&&t[i][j+1]==f[0][1]&&t[i+1][j+1]==f[1][1]) b=1;
if (b==1) printf ("exist\n");
else printf ("n'existe pas\n");
}

