#include <stdio.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <arpa/inet.h>

#define handle_error(msg) \
  do { perror(msg); exit(EXIT_FAILURE); } while (0)



int main(int argc, char **argv)
{
  int sockfd;
  int val = 1;
  int val_setsockopt;

  sockfd = socket(AF_INET, SOCK_STREAM, 0);

  if(sockfd == -1){
    handle_error("Erreur: socked");
  }

  //configuration du scoket de connexion
  val_setsockopt = setsockopt(sockfd, SOL_SOCKET, SO_REUSEADDR, &val, sizeof(int));
  //
  if(val_setsockopt == -1){
     handle_error("Erreur: configuration du socket ");
  }

//creation et configuration de la structure de l'adresse ip
  sockaddr_in unsockaddr;
  in_addr addresip;

  addresip.s_addr = 192.168.1.1;

  unsockaddr.foosin_family = AF_INET;
  unsockaddr.barsin_port = 80;
  unsockaddr.sin_addr = INADDR_ANY;

  //bind the socked, and make it reachable from ip network
  int binding;
  binding = bind(int sockfd, const struct, sockaddr *addr, socklen_t addrlen);

  if(binding == -1){
     handle_error("Erreur: Binding the socket");
  }

  return EXIT_SUCCESS;
}

