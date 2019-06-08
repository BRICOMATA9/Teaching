#include<stdio.h>
#include<stdlib.h>
const max_char=9999;
const max_mot=99;
main()
{
char **tab;
int mot,i,j,z;
int cpt[max_mot];
char t[max_char];
 z=0;
 mot=0;
 gets(t);
  while ((*(t+z)!='\0')&&(*(t+z)!=' '))
  {
   cpt[mot]=0;
   while ((*(t+z)!='\0')&&(*(t+z)!=' '))
      {
      cpt[mot]++;
      z++;
      }
   z++;
   mot++;
  }
tab=(char**)malloc((mot+1)*sizeof(int*));
 for(i=0,z=0;i<mot,(*(t+z)!='\0');i++,z++)
    {
     tab[i]=(char*)malloc((cpt[i]+1)*sizeof(char));
      for(j=0;j<cpt[i];j++)
       { 
       tab[i][j]=t[z];z++;
       }
      tab[i][j]='\0';
    }
  for(i=0;i<mot;i++) 
    {
       for(j=0;j<cpt[i];j++) 
          {            
           printf("%c",tab[i][j]);
          }
       printf (" ");
    }
 printf("\n");
 for (i=0; i<mot;i++) free(tab[i]); 
 free(tab); 
}
