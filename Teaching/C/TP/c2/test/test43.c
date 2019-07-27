#include<stdio.h>
#include<stdlib.h>
void fct (int l)
{
 l=l+1;
}
main()
{
int *t,n,i;
t=(int*)malloc(21*sizeof(int));
scanf("%d",&n);
for(i=0;i<n;i++) scanf("%d",t+i);
fct (*t);
for(i=0;i<n;i++) printf("%d",t[i]);
}

