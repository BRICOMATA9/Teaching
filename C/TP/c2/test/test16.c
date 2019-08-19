#include<stdio.h>
#include<string.h>
typedef char chaine[100];
typedef struct {int f;char c;}elem;
typedef elem tab[27];
void frequence (chaine t,tab m)
{
int cpt,i,j,b,k=0;
for (i=0;i<strlen(t);i++)
 {
 b=0;
 for(j=i+1;j<strlen(t)&&b==0;j++)
  if (t[i]==t[j]) b=1;
 if (b==0) {m[k].c=t[i];k++;}
 }
 for (i=0;i<k;i++)
 {
  cpt=0; 
  for (j=0;j<strlen(t);j++)
   if (m[i].c==t[j]) cpt++;
  m[i].f=cpt;
 }
for (i=0;i<k;i++) printf ("%c %d\n",m[i].c,m[i].f);
}
main()
{
int i=0,j;
char l[30];
chaine m;
gets(m);
while (m[i]!='\0')
{
 j=0;
 while (m[i]!=' '&&m[i]!='\0')
  {
   l[j]=m[i];j++;i++;
  }
 l[j]='\0';
 printf("%s",l);
 while (m[i]==' '&&m[i]!='\0') i++;
}
}
