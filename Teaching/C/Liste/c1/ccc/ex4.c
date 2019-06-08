#include <unistd.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <stdio.h>
#include <signal.h>

int main(void) {
  pid_t pid=fork();
  if (pid<0) {
    perror("fork");
    return EXIT_FAILURE;
  }
  if (pid==0) {
    execlp("my_program","my_program",NULL);
    perror("execlp");
    return EXIT_FAILURE;
  }
  int status;
  if (waitpid(pid,&status,0)<0) {
    perror("waitpid");
    kill(pid,SIGKILL);
    wait(NULL);
    return EXIT_FAILURE;
  }
  if (WIFEXITED(status)) {
    printf("exit status: %d\n",WEXITSTATUS(status));
  }
  else if (WIFSIGNALED(status)) {
    printf("signal received: %d\n",WTERMSIG(status));
  }
  else {
    printf("bug in program\n");
    return EXIT_FAILURE;
  }
  return EXIT_SUCCESS;
}
  
