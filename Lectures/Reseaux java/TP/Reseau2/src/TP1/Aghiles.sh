cd ~/s8/Reseau/TP1

javac -d bin -sourcepath src src/Server.java

javac -d bin -sourcepath src src/Client.java

java -cp bin Server

java -cp bin Client
