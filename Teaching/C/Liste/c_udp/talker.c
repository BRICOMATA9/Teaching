#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <netdb.h>
#include <netinet/in.h>
#define str(x) # x

int main(){
	int socketDescriptor, status;
	unsigned int msgLength;
	struct addrinfo hints, *servinfo;
	char msg[81], serverPort[6];

	puts("Entrez le nom du serveur ou son adresse IP : ");
	memset(msg, 0, sizeof msg);	// Mise à zéro du tampon
	scanf("%"str(80)"s", msg);

	puts("Entrez le numéro de port du serveur : ");
	memset(serverPort, 0, sizeof serverPort);	// Mise à zéro du tampon
	scanf("%"str(5)"s", serverPort);

	memset(&hints, 0, sizeof hints);
	hints.ai_family = AF_INET;
	hints.ai_socktype = SOCK_STREAM;

	if ((status = getaddrinfo(msg, serverPort, &hints, &servinfo)) != 0) 
		exit(EXIT_FAILURE);
	//SOCKET
	if ((socketDescriptor = socket(servinfo->ai_family, servinfo->ai_socktype, servinfo->ai_protocol)) == -1) 
		exit(EXIT_FAILURE);
	//CONNECT
	if (connect(socketDescriptor, servinfo->ai_addr, servinfo->ai_addrlen) == -1) 
		close(socketDescriptor);
	freeaddrinfo(servinfo);

	while (strcmp(msg, ".")) {
		puts("Saisie du message : ");
		memset(msg, 0, sizeof msg);
		scanf(" %"str(80)"[^\n]%*c", msg);
	
		if ((msgLength = strlen(msg)) > 0) {
			//SEND
			if (sendto(socketDescriptor, msg, msgLength, 0, servinfo->ai_addr, servinfo->ai_addrlen) == -1) 
				close(socketDescriptor);
			//RECEIVE
			memset(msg, 0, sizeof msg);	// Mise à zéro du tampon
			if (recv(socketDescriptor, msg, sizeof msg, 0) == -1) 
				close(socketDescriptor);
		}
	}

	close(socketDescriptor);

	return 0;
}


