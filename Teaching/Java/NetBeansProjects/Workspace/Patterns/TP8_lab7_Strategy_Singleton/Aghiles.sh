javac -d ./bin -sourcepath ./src src/CheckSum/CheckSum.java
java -cp ./bin CheckSum.CheckSum CRC32 fichier.txt

javac -d ./bin -sourcepath ./src src/Singleton/Singleton.java
java -cp ./bin Singleton.Singleton

javac -d ./bin -sourcepath ./src src/Singleton/MathLibrary.java
java -cp ./bin Singleton.MathLibrary

javac -d ./bin -sourcepath ./src src/Random/Main.java
java -cp ./bin Random.Main

javadoc -docletpath ~/Téléchargements/UmlGraph.jar -doclet org.umlgraph.doclet.UmlGraph -package -attributes -operations -types src/*.java
dot -Tpng -ograph.png graph.dot

sed -i '1iLigne1' test.txt
