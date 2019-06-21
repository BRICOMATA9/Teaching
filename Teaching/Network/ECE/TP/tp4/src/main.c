#include "info.h"

int main(int argc, char *argv[]){
    char defaultPath[] = "./";
    char* path = defaultPath;
    bool count = FALSE;
    int i;
    for(i=1;i<argc;i++){
        if(!(strcmp(argv[i],"--count"))){
            count = TRUE;
        }
        else{
            if(path==defaultPath){
                path=argv[i];
            }
            else{
                printf("USAGE: musicinfo [path] [--count]");
                return 0;
            }
        }
    }
    printInfo(path,count);
    return 0;
}
