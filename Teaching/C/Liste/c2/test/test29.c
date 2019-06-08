#include<stdio.h>
#include<stdlib.h>
#include<string.h>
main()
{
 char* p=(char*)malloc(20);
 char a;
 scanf("%s",&a);
 scanf("%s",p);
 printf("%d\n",strlen(p));
 int i=0,k=0;
 char* b="NULL";
 printf("%s\n",p);
 while(p[i]!='\0'&&k==0) 
  {
   if (a==*(p+i)) {b=p+i;k=1;}
  i++;
  }
 printf("%s\n",b);
}
 
