#!/bin/sh

javac -d bin -sourcepath src src/serveurs/MandelbrotServer.java
#java -cp bin serveurs.MandelbrotServer
cd bin
jar cfe Serveur.jar serveurs/MandelbrotServer serialization serveurs utilities 

