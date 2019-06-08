#include<stdio.h>
void permut (int *p,int *q)
{
int aide;
aide=*p;
*p=*q;
*q= aide;
} 
main()
{
int a,b;
scanf("%d%d",&a,&b);
printf("a=%d,b=%d\n",a,b); 
permut (&a,&b);
printf("a=%d,b=%d\n",a,b); 
}
