cd ~/Bureau/Reseau/Projet/Serveur
javac -d bin -sourcepath src src/serveurs/MandelbrotServer.java 
java -cp bin serveurs.MandelbrotServer 8080 9090
#cd ~/Bureau/Reseau/Projet/Serveur/bin
#jar cmf MANIFEST.MF Serveur.jar serialization serveurs utilities 
