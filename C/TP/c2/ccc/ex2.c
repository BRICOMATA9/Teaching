#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdlib.h>
#include "write_all.h"

void usage(void) {
  fprintf(stderr,"...\n");
}

int main(int argc, char **argv) {
  if (argc!=3) {
    usage();
    return EXIT_FAILURE;
  }
  int fdr=open(argv[1],O_RDONLY);
  if (fdr<0) {
    perror("open");
    return EXIT_FAILURE;
  }
  int fdw=open(argv[2],O_WRONLY|O_CREAT|O_TRUNC,0666);
  if (fdw<0) {
    close(fdr);
    perror("open");
    return EXIT_FAILURE;
  }
  int r;
  char buffer[1024];
  while((r=read(fdr,buffer,sizeof(buffer)))!=0) {
    if (r<0) {
      perror("read");
      close(fdr);
      close(fdw);
      return EXIT_FAILURE;
    }
    write_all(fdw,buffer,r);
  }
  close(fdw);
  close(fdr);
  return EXIT_SUCCESS;
}
