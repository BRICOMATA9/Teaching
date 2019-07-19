#include<stdio.h>
#include<math.h>
main()
{float a,b,c;
float x0,x1,x2;
float d;
printf("\n programme sur la resolution d'une equation \n\n ");
printf("donnez la valeur de a : ");
scanf("%f",&a);
printf("\n");
printf(" donnez la naleur de b : " );
scanf("%f",&b);
printf("\n");
printf(" donnez la naleur de c : ");
scanf("%f",&c);
printf("\n");
if ((a!=0)||(b!=0))
{
if ((a==0)&&(b!=0))
{
printf("on obtient une equation de prelier degre \n\n");
x0=-c/b;
printf(" la solution dde l'equation est %f ",x0);
}
else {d=(b*b)-4*(a*c);
if (d==0){
x0=-b/(2*a);
printf("solution fouble : x0=%f ",x0);
}
else {if(d>0){x1=-b-sqrt(d)/(2*a);
x2=-b+sqrt(d)/(2*a);
printf(" deux solutions differentes : \n ");
printf ("\tx1=%f\n ",x1);
printf ("\tx2=%f\n ",x2);
}else{printf(" pas de somutions reelles \n ");
}}}}else {printf(" equaion impossible " );
}}
