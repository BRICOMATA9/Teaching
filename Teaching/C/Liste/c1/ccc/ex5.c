#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdbool.h>
#include <signal.h>
#include <string.h>
#include "write_all.h"

#define PIPE_READ 0
#define PIPE_WRITE 1

bool my_treatment(int fd) {
  int r;
  char buffer[1024];
  while((r=read(fd,buffer,sizeof(buffer)))!=0) {
    if (r<0) {
      perror("read");
      close(fd);
      return false;
    }
    write_all(STDIN_FILENO,buffer,r);
  }
  return true;
}
  

int main(int argc, char **argv) {
  int fd[2];
  if (pipe(fd)<0) {
    perror("pipe");
    return EXIT_FAILURE;
  }
  pid_t pid=fork();
  if (pid==0) {
    close(fd[PIPE_WRITE]);
    if (my_treatment(fd[PIPE_READ]))
      return EXIT_FAILURE;
    else
      return EXIT_SUCCESS;
  }
  close(fd[PIPE_READ]);
  for(int i=1;i<argc;i++) {
    if (!write_all(fd[PIPE_WRITE],argv[i],strlen(argv[i]))) {
      perror("write");
      kill(pid,SIGKILL);
      wait(NULL);
      return EXIT_FAILURE;
    }
  }
  if (close(fd[PIPE_WRITE])<0) {
    perror("close");
    kill(pid,SIGKILL);
    wait(NULL);
    return EXIT_FAILURE;
  }
  if (waitpid(pid,NULL,0)<0) {
    perror("waitpid");
    kill(pid,SIGKILL);
    wait(NULL);
    return EXIT_FAILURE;
  }
  return EXIT_SUCCESS;
}
