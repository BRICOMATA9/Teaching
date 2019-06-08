#include "info.h"


bool detect(const char* const path);

unsigned int count(const char* const path);

void printInfo(const char* const path, const bool countFile){
    /*Si countFile on appelle la fonction de dédcompte et on affiche la valeur*/
    if(countFile){
        printf("'%s': %d files found in this library\n",path,count(path));
    }
    /*Sinon on appelle detect.
        On en profite pour rappeler la notation ternaire :
        val = (test)?valeurSiVrai:valeurSinon;
        Equivalent à:
        if(test) val=valeurSivrai; else val=valeurSinon;*/
    else{
        printf((detect(path))?"'%s': There are audio files in this library\n":"'%s': There is no audio file in this library\n",path);
    }
}

/*la fonction retourne VRAI si il y a des fichiers musicaux dans le dossier en cours, 
FAUX sinon. Elle est recursive sur les sous dossiers*/
bool detect(const char* const path){
    DIR* dir;
    struct dirent* in_file;
    /*Si on ne peut pas ouvrir le dossier, on considère qu'il ne contient pas de fichiers audios*/
    if(!(dir=opendir(path))){
        return FALSE;
    }
    /*Pour tous les fichiers et sous-dossiers du dir*/
    while((in_file = readdir(dir))){
        /*On ignore les dossiers '.' et '..' qui correspondent au dossier en cours et au dossier parent
        Sinon, boucle infinie, la fonction est recursive sur les dossiers listés*/
        if(!(strcmp(in_file->d_name,".") && strcmp(in_file->d_name,".."))){
            continue;
        }
        /*Si le fichier est un fichier régulier*/
        if(in_file->d_type==DT_REG){
            /*Si son extension est une extension de musique*/
            if((strendswith(in_file->d_name,".mp3") || strendswith(in_file->d_name,".flac") || strendswith(in_file->d_name,".ogg") || strendswith(in_file->d_name,".wma") || strendswith(in_file->d_name,".m4a"))){
                return TRUE;
            }
            /*On test aussi les MAJUSCULES*/
            else if((strendswith(in_file->d_name,".MP3") || strendswith(in_file->d_name,".FLAC") || strendswith(in_file->d_name,".OGG") || strendswith(in_file->d_name,".WMA") || strendswith(in_file->d_name,".M4A"))){
                return TRUE;
            }
        }
        /*Si le fichier est un dossier, on calcule le nouveau path, et on appelle recursivement la fct*/
        else if(in_file->d_type==DT_DIR){
            char sonpath[256];
            strcpy(sonpath,path);
            strcat(sonpath,"/");
            strcat(sonpath,in_file->d_name);
            if(detect(sonpath)){
                return TRUE;
            }
        }
    }
    /*On arrive ici si aucun fichier n'a été détecté, ni dans le dossier en cours, ni dans les sous dossiers
    On retourne false*/
    return FALSE;
}

/*Même fonction que ci dessus mais au lieu de faire un return TRUE, on incrémente un compteur*/
unsigned int count(const char* const path){
    DIR* dir;
    struct dirent* in_file;
    int counter=0;

    if(!(dir=opendir(path))){
        printf("Unable to open: %s\n",path);
        return 0;
    }

    while((in_file = readdir(dir))){
        if(!(strcmp(in_file->d_name,".") && strcmp(in_file->d_name,".."))){
            continue;
        }
        if(in_file->d_type==DT_REG){
            if((strendswith(in_file->d_name,"mp3") || strendswith(in_file->d_name,"flac") || strendswith(in_file->d_name,"ogg") || strendswith(in_file->d_name,"wma") || strendswith(in_file->d_name,"m4a"))){
                counter++;
            }
            else if((strendswith(in_file->d_name,"MP3") || strendswith(in_file->d_name,"FLAC") || strendswith(in_file->d_name,"OGG") || strendswith(in_file->d_name,"WMA") || strendswith(in_file->d_name,"M4A"))){
                counter++;
            }
        }
        else if(in_file->d_type==DT_DIR){
            char sonpath[256];
            strcpy(sonpath,path);
            strcat(sonpath,"/");
            strcat(sonpath,in_file->d_name);
            counter+=count(sonpath);
        }
    }
    return counter;
}


/*Cette fonction retourne TRUE si la string str fini par la string suffix*/
bool strendswith(const char* const str, const char* const suffix) {
    /*Si str ou suffix nulles, alors on retourne faux*/
    if( str == NULL || suffix == NULL ){
        return FALSE;
    }
    /*On récupère la longeur des strings*/
    size_t str_len = strlen(str);
    size_t suffix_len = strlen(suffix);
    /*Si le suffix est plus long que la string, on retourne faux*/
    if(suffix_len > str_len){
        return FALSE;
    }
    /*str est un pointeur de tableau, on effectue sur str un décalage correspondant a la différence de taille
    les deux string comparées sont de même taille
    Si elle sont identiques alors strcmp renvoie 0 et le test est vrai
    Car oui, un test n'est pas réservé aux conditions, c'est une valeur numérique comme une autre, elle peut être retournée*/
    return (strcmp(str+str_len-suffix_len,suffix)==0);
}
