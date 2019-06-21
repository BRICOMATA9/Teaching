#ifndef INFO_H_INCLUDED
#define INFO_H_INCLUDED
#define tiny_int char
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <dirent.h>
#include <unistd.h>
#include <errno.h>

/*bool n'est pas defini par defaut, on le define*/
#define bool char
#define FALSE 0
#define TRUE 1
/*Fin des define booleens*/

/*la fonction qui prend en parametre une string et un booleen*/
void printInfo(const char* const path, const bool countFile);
/*Explications sur: const char* const path
const char* str : cela signifie que votre fonction ne peut changer le pointeur:
  En précisant const sur un pointeur vous êtes sur que la fonction travaillera
  toujours sur le même espace mémoire (et donc sur la valeur de la variable),et vous éviterez beaucoup d'erreurs DANS VOTRE FONCTION
  EXEMPLE: void foo(const char* path){
              path=malloc(10); <--- LE COMPILATEUR NE COMPILERA PAS
              path[5]='c' <---- SI JE MODIFIE PATH, la fonction ne modifiera pas le 6eme caractère de la chaine envoyée
           }
char* const path : Encore plus intéressant ! cela signifie que la fonction NE PEUT PAS modifier la valeur pointée !
  Si une fonction déclare un pointeur suivi de const, le compilateur garanti que l'espace mémoire visé par le pointeur ne sera pas modifié
  EXEMPLE: int a=4; foo(&a); <--- Quoi que fasse la fonction, après son appel, a vaudra toujours 4 ! vous évitez l'effet de bord !
    Il faut toujours utilisé const lorsque l'on peut, car pour débugger, si vos fonctions prennent des pointeurs non constants, vous ne savez plus qui a modifié quoi !!
const char* const path : on sait que la fonction ne va QUE lire la valeur pointée (2eme const), et pas une autre (1er const)!*/


/*Cette fonction renvoie 1 (TRUE) si str fini par suffix, 0 (FALSE) sinon*/
bool strendswith(const char* const str, const char* const suffix);

#endif
