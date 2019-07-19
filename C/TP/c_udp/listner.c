#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <netdb.h>
#include <arpa/inet.h>
#include <netinet/in.h>
#define str(x) # x

int main(){
	int listenSocket, connectSocket, status;
	unsigned short int msgLength;
	struct addrinfo hints, *servinfo;
	struct sockaddr_in clientAddress;
	socklen_t clientAddressLength = sizeof clientAddress;
	char msg[81], listenPort[6];

	memset(listenPort, 0, sizeof listenPort);	// Mise à zéro du tampon
	puts("Entrez le numéro de port utilisé en écoute (entre 1500 et 65000) : ");
	scanf("%"str(5)"s", listenPort);

	memset(&hints, 0, sizeof hints);
	hints.ai_family = AF_INET;			 // IPv4
	hints.ai_socktype = SOCK_STREAM; // TCP
	hints.ai_flags = AI_PASSIVE;		 // Toutes les adresses disponibles

	if ((status = getaddrinfo(NULL, listenPort, &hints, &servinfo)) != 0) 
		exit(EXIT_FAILURE);
	//SOCKET
	if ((listenSocket = socket(servinfo->ai_family, servinfo->ai_socktype,servinfo->ai_protocol)) == -1) 
		exit(EXIT_FAILURE);
	//BIND
	if (bind(listenSocket, servinfo->ai_addr, servinfo->ai_addrlen) == -1) 
		close(listenSocket);
	freeaddrinfo(servinfo);
	//LISTEN
	if (listen(listenSocket, 5) == -1) exit(EXIT_FAILURE);

	while (1) {
		//ACCEPT
		printf("Attente de connexion TCP sur le port %s\n", listenPort);
		if ((connectSocket = accept(listenSocket, (struct sockaddr *) &clientAddress,&clientAddressLength)) == -1)
			close(listenSocket);
		printf(">>	connecté à %s", inet_ntoa(clientAddress.sin_addr));
		printf(":%hu\n", ntohs(clientAddress.sin_port));
		//RECEIVE
		memset(msg, 0, sizeof msg);
		while (recv(connectSocket, msg, sizeof msg, 0) > 0) {
			if (msgLength = strlen(msg) > 0) {
				printf("	--	%s\n", msg);
			// SEND
				if (send(connectSocket, msg, msgLength + 1, 0) == -1) 
					close(listenSocket);
				memset(msg, 0, sizeof msg);	// Mise à zéro du tampon
			}
		}
	}
}
