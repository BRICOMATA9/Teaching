#include<stdio.h>
#include<string.h>
typedef char chaine[20];
int differ (chaine m1,chaine m2)
{
 int cpt=0,i;
 for (i=0;i<strlen(m1);i++) if (strchr(m2,m1[i])==NULL) cpt++;
 return cpt;
}
main()
{
 int i,cpt,n;
 chaine m1,m2;
 scanf("%s%s",m1,m2);
 int m=differ (m1,m2);
 printf("%d\n",m);
 chaine  m3[20];
 cpt=0;
 scanf ("%d",&n);
 for (i=0;i<n;i++) 
  {
   scanf("%s",m3[i]);
   m=differ (m3[i],m1);
   if (m<4) cpt++;
  }
 printf("%d\n",cpt);
}
