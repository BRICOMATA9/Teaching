#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <netdb.h>
#include <arpa/inet.h>
/*#include <netinet/in.h>*/
#define str(x) # x

int main(){

	//Lecture du port
	char listenPort[6];
	memset(listenPort, 0, sizeof listenPort);	// Mise à zéro du tampon
	puts("Entrez le numéro de port utilisé en écoute (entre 1500 et 65000) : ");
	scanf("%"str(5)"s", listenPort);

	struct addrinfo hints, *servinfo;
	memset(&hints, 0, sizeof hints);
	hints.ai_family = AF_INET;			 // IPv4
	hints.ai_socktype = SOCK_STREAM; // TCP
	hints.ai_flags = AI_PASSIVE;		 // Toutes les adresses disponibles
	//Lecture de servinfo
	int status;
	if ((status = getaddrinfo(NULL, listenPort, &hints, &servinfo)) != 0) 
		exit(EXIT_FAILURE);
	//SOCKET de connexion
	int listenSocket;
	if ((listenSocket = socket(servinfo->ai_family, servinfo->ai_socktype, servinfo->ai_protocol)) == -1) 
		exit(EXIT_FAILURE);
	//BIND
	if (bind(listenSocket, servinfo->ai_addr, servinfo->ai_addrlen) == -1)
		close(listenSocket);
	freeaddrinfo(servinfo);
	//LISTEN
	if (listen(listenSocket, 5) == -1) exit(EXIT_FAILURE);
	//
	struct sockaddr_in clientAddress;
	socklen_t clientAddressLength = sizeof clientAddress;
	int connectSocket;
	char msg[81];

	while (1) {
		//ACCEPT
		printf("Attente de connexion TCP sur le port %s\n", listenPort);
		if ((connectSocket = accept(listenSocket, (struct sockaddr *) &clientAddress, &clientAddressLength)) == -1)
			close(listenSocket);
		printf(">>	connecté à %s", inet_ntoa(clientAddress.sin_addr));
		printf(":%hu\n", ntohs(clientAddress.sin_port));
		//RECEIVE
		memset(msg, 0, sizeof msg);
		while (recv(connectSocket, msg, sizeof msg, 0) > 0) {
			if (strlen(msg) > 0) {
				printf("	--	%s\n", msg);
			// SEND
				if (send(connectSocket, msg, strlen(msg) + 1, 0) == -1) 
					close(listenSocket);
				memset(msg, 0, sizeof msg);	// Mise à zéro du tampon
			}
		}
	}
}
