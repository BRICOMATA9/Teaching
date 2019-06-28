#include<stdio.h>
typedef struct {int heure,minute,seconde;}temps;
int transforme (temps t)
{
int b;
b=t.heure*3600+t.minute*60+t.seconde;
return b;
}
temps decompose (int s)
{
temps p;
p.heure=s/3600;
s%=3600;
p.minute=s/60;
s%=60;
p.seconde=s;
return p;
}
main()
{
temps t1,t2,t3;
scanf("%d%d%d",&t1.heure,&t1.minute,&t1.seconde);
scanf("%d%d%d",&t2.heure,&t2.minute,&t2.seconde);
t3=decompose(transforme(t1)+transforme(t2));
printf("%dh %dm %ds",t3.heure,t3.minute,t3.seconde);
}
