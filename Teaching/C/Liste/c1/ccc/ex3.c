#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdbool.h>
#include <fcntl.h>

int main(void) {
  int fdr=open("input.txt",O_RDONLY);
  if (fdr<0) {
    perror("open");
    return EXIT_FAILURE;
  }
  if (dup2(fdr,0)<0) {
    perror("dup2");
    close(fdr);
    return EXIT_FAILURE;
  }
  close(fdr);
  int fdw=open("output.txt",O_WRONLY|O_CREAT|O_TRUNC,0666);
  if (fdw<0) {
    perror("open");
    return EXIT_FAILURE;
  }
  if (dup2(fdw,1)<0) {
    perror("dup2");
    close(fdw);
    return EXIT_FAILURE;
  }
  close(fdw);
  execlp("my_program","my_program",NULL);
  perror("execlp");
  return EXIT_FAILURE;
}
