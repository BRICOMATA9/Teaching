#include <stdio.h>
#include <stdlib.h>
#include <sys/socket.h>

#define handle_error(msg) \
  do { perror(msg); exit(EXIT_FAILURE); } while (0)

int main(int argc, char **argv)
{
  int sockfd;

  sockfd = socket(AF_UNIX, SOCK_STREAM, 0);

  if(sockfd == -1){
    handle_error("Erreur: socked")
  }
  return EXIT_SUCCESS;
}

 
{

}
