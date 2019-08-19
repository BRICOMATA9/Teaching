#include<stdio.h>
#include<string.h>
void verifier (char *mot,int l)
{
 if(strlen(mot)==l/2) printf("carré");
  else
   {
    printf("%d\n",strlen(mot));
    if((*mot)!=*(mot+l/2)) printf("pas carré");
    else verifier(mot+1,l);
   }
}
main()
{
char mot[21];
scanf("%s",mot);
int l=strlen(mot);
verifier (mot,l);
}
