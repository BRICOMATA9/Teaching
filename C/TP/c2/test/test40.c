#include<stdio.h>
void add (int*t1,int*t2,int*t3,int d)
{
 int retenu=0,i;
 for (i=d-1;i>=0;i--)
  {
   if((t1[i]+t2[i]+retenu)<10) {t3[i+1]=t1[i]+t2[i]+retenu;retenu=0;}
    else {t3[i]=t3[i+1]=(t1[i]+t2[i]+retenu)%10;retenu=1;}
  }
 t3[i+1]=retenu;
}  
main()
{
 int a[21],b[21],c[22],d,i;
 scanf("%d",&d);
 for(i=0;i<d;i++) scanf("%d",a+i);
 for(i=0;i<d;i++) scanf("%d",b+i);
 add (a,b,c,d);
 for (i=0;i<=d;i++) printf("%d",c[i]);
 printf("\n");
}
