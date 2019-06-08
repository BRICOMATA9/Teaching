#include <unistd.h> //close
#include <stdio.h>	//printf
#include <stdlib.h> //exit
#include <string.h> //str
#include <netdb.h>	//network

#define str(x) # x

int main(){
	int listenSocket, status;
	unsigned int msgLength;
	struct addrinfo hints, *servinfo;
	char msg[81], serverPort[6];

	// IP address
	puts("IP Serveur: ");
	memset(msg, 0, sizeof msg);	// Mise à zéro du tampon
	scanf("%"str(80)"s", msg);

	// Port address
	puts("Port Serveur: ");
	memset(serverPort, 0, sizeof serverPort);	// Mise à zéro du tampon
	scanf("%"str(5)"s", serverPort);

	memset(&hints, 0, sizeof hints);
	hints.ai_family = AF_INET;
	hints.ai_socktype = SOCK_STREAM;

	if ((status = getaddrinfo(msg, serverPort, &hints, &servinfo)) != 0) exit(EXIT_FAILURE);
	//SOCKET
	if ((listenSocket = socket(servinfo->ai_family, servinfo->ai_socktype, servinfo->ai_protocol)) == -1) exit(EXIT_FAILURE);
	//CONNECT
	if (connect(listenSocket, servinfo->ai_addr, servinfo->ai_addrlen) == -1) exit(EXIT_FAILURE);
	puts("Connecté ");
	freeaddrinfo(servinfo);

	while (strcmp(msg, ".")) {
		// SEND
		memset(msg, 0, sizeof msg);	// Mise à zéro du tampon
		scanf(" %"str(80)"[^\n]%*c", msg);
		if (sendto(listenSocket, msg, msgLength, 0, servinfo->ai_addr, servinfo->ai_addrlen) == -1) exit(EXIT_FAILURE);

		//RECEIVE
		memset(msg, 0, sizeof msg);
		if (recv(listenSocket, msg, sizeof msg, 0) == -1) exit(EXIT_FAILURE);
		printf("<< : %s\n", msg);
	}

	//CLOSE
	close(listenSocket);

	return 0;
}
