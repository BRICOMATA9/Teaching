#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <netdb.h>
#include <arpa/inet.h>
#include <netinet/in.h>

#define str(x) # x

int main(){
  int listenSocket, connectSocket, status, i;
  unsigned short int msgLength;
  struct addrinfo hints, *servinfo;
  struct sockaddr_in clientAddress;
  socklen_t clientAddressLength = sizeof clientAddress;
  char msg[81], listenPort[6];

  memset(listenPort, 0, sizeof listenPort);  // Mise à zéro du tampon
  memset(&hints, 0, sizeof hints);

  puts("Port Serveur: [1500-65000]");
  scanf("%"str(5)"s", listenPort);
  hints.ai_family = AF_INET;       // IPv4
  hints.ai_socktype = SOCK_STREAM; // TCP
  hints.ai_flags = AI_PASSIVE;     // Toutes les adresses disponibles

  if ((status = getaddrinfo(NULL, listenPort, &hints, &servinfo)) != 0) exit(EXIT_FAILURE);
	//SOCKET
  if ((listenSocket = socket(servinfo->ai_family, servinfo->ai_socktype, servinfo->ai_protocol)) == -1) exit(EXIT_FAILURE);
	//BIND
  if (bind(listenSocket, servinfo->ai_addr, servinfo->ai_addrlen) == -1) { close(listenSocket); exit(EXIT_FAILURE);}
  freeaddrinfo(servinfo); // Libération de la mémoire occupée par les enregistrements
	//LISTEN
  if (listen(listenSocket, 5) == -1) { close(listenSocket); exit(EXIT_FAILURE);}

  while (1) {
  	//ACCEPT
    printf("Attente de connexion TCP sur le port %s\n", listenPort);
    if ((connectSocket = accept(listenSocket, (struct sockaddr *) &clientAddress, &clientAddressLength)) == -1) { close(listenSocket); exit(EXIT_FAILURE);}
    printf("<<  nouveau client %s", inet_ntoa(clientAddress.sin_addr));
    printf(":%hu\n", ntohs(clientAddress.sin_port));


    memset(msg, 0, sizeof msg);
    while (recv(connectSocket, msg, sizeof msg, 0) > 0) {
      msgLength = strlen(msg);
      if (msgLength > 0) {
        printf("  --  %s\n", msg);

      // Conversion de cette ligne en majuscules.
      for (i = 0; i < msgLength; i++)
        msg[i] = toupper(msg[i]);

      // Renvoi de la ligne convertie au client.
        if (send(connectSocket, msg, msgLength + 1, 0) == -1) {
          perror("send:");
        close(listenSocket);
        exit(EXIT_FAILURE);
      }

        memset(msg, 0, sizeof msg);  // Mise à zéro du tampon
      }
    }
    
/*		//RECEIVE*/
/*    memset(msg, 0, sizeof msg);*/
/*    */
/*    while (recv(connectSocket, msg, sizeof msg, 0) > 0) {*/
/*    	msgLength = strlen(msg);*/
/*    	printf("%d",msgLength);*/
/*     	if (msgLength > 0) {*/
/*        printf("  --  %s\n", msg);*/
/*      	if (send(connectSocket, msg, msgLength + 1, 0) == -1) { close(listenSocket); exit(EXIT_FAILURE);}*/
/*      	memset(msg, 0, sizeof msg);  // Mise à zéro du tampon*/
/*    	}*/
/*    }*/
  }
}
