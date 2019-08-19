--- udp_listner.c  2013-04-07 17:13:05.000000000 +0200
+++ tcp_listner.c      2013-04-07 17:08:29.000000000 +0200
@@ -11,6 +11,7 @@
 #define PORT_ARRAY_SIZE (MAX_PORT+1)
 #define MAX_MSG 80
 #define MSG_ARRAY_SIZE (MAX_MSG+1)
+#define BACKLOG 5
 // Utilisation d'une constante x dans la définition
 // du format de saisie
 #define str(x) # x
@@ -18,7 +19,7 @@
 
 int main()
 {
-  int listenSocket, status, i;
+  int listenSocket, connectSocket, status, i;
   unsigned short int msgLength;
   struct addrinfo hints, *servinfo;
   struct sockaddr_in clientAddress;
@@ -31,7 +32,7 @@
 
   memset(&hints, 0, sizeof hints);
   hints.ai_family = AF_INET;       // IPv4
-  hints.ai_socktype = SOCK_DGRAM;  // UDP
+  hints.ai_socktype = SOCK_STREAM; // TCP
   hints.ai_flags = AI_PASSIVE;     // Toutes les adresses disponibles
 
   if ((status = getaddrinfo(NULL, listenPort, &hints, &servinfo)) != 0) {
@@ -54,44 +55,62 @@
   // Libération de la mémoire occupée par les enregistrements
   freeaddrinfo(servinfo);
 
-  printf("Attente de requête sur le port %s\n", listenPort);
+  // Attente des requêtes des clients.
+  // Appel non bloquant et passage en mode passif
+  // Demandes d'ouverture de connexion traitées par accept
+  if (listen(listenSocket, BACKLOG) == -1) {
+    perror("listen");
+    exit(EXIT_FAILURE);
+  }
 
   while (1) {
+    printf("Attente de connexion TCP sur le port %s\n", listenPort);
 
-    // Mise à zéro du tampon de façon à connaître le délimiteur
-    // de fin de chaîne.
-    memset(msg, 0, sizeof msg);
-    if (recvfrom(listenSocket, msg, sizeof msg, 0,
+    // Appel accept() bloquant
+    // connectSocket est une nouvelle prise indépendante
+    if ((connectSocket = accept(listenSocket, 
                  (struct sockaddr *) &clientAddress,
-                 &clientAddressLength) == -1) {
-      perror("recvfrom:");
+                               &clientAddressLength)) == -1) {
+      perror("accept:");
       close(listenSocket);
       exit(EXIT_FAILURE);
     }
 
-    msgLength = strlen(msg);
-    if (msgLength > 0) {
       // Affichage de l'adresse IP du client.
-      printf(">>  depuis %s", inet_ntoa(clientAddress.sin_addr));
-
-      // Affichage du numéro de port du client.
+    // inet_ntoa() convertit une adresse IP stockée sous forme binaire en une
+    // chaîne de caractères
+    printf(">>  connecté à %s", inet_ntoa(clientAddress.sin_addr));
+
+    // Affichage du numéro de port client
+    // ntohs() convertit un entier court (short) de l'agencement réseau (octet
+    // de poids fort en premier) vers l'agencement hôte (sur x86 on trouve
+    // l'octet de poids faible en premier).
       printf(":%hu\n", ntohs(clientAddress.sin_port));
 
-      // Affichage de la ligne reçue
-      printf("  Message reçu : %s\n", msg);
+    // Lecture de la chaîne sur le socket en utilisant recv(). La chaîne est
+    // stockée dans le tableau msg. Si aucun message n'arrive, recv() reste en
+    // attente.
+    // On remplit le tableau avec des zéros de façon à connaître la fin de
+    // chaîne de caractères
+    memset(msg, 0, sizeof msg);
+    while (recv(connectSocket, msg, sizeof msg, 0) > 0) {
+      msgLength = strlen(msg);
+      if (msgLength > 0) {
+        printf("  --  %s\n", msg);
 
       // Conversion de cette ligne en majuscules.
       for (i = 0; i < msgLength; i++)
         msg[i] = toupper(msg[i]);
 
       // Renvoi de la ligne convertie au client.
-      if (sendto(listenSocket, msg, msgLength, 0,
-                 (struct sockaddr *) &clientAddress,
-                 clientAddressLength) == -1) {
-        perror("sendto:");
+        if (send(connectSocket, msg, msgLength + 1, 0) == -1) {
+          perror("send:");
         close(listenSocket);
         exit(EXIT_FAILURE);
       }
+
+        memset(msg, 0, sizeof msg);  // Mise à zéro du tampon
+      }
     }
   }
 }
