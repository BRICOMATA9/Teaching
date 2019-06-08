#include<stdio.h>
#include<stdlib.h>
int* lirepoly()
{
 int i,n,*t;
 t=(int*)malloc(21*sizeof(int));
 scanf("%d",&n);
 for(i=0;i<n;i++) scanf("%d",t+i);
 return (t);
}
main()
{
}
