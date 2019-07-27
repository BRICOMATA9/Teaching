javac -d ./bin -sourcepath ./src src/CheckSum.java
java -cp ./bin CheckSum CRC32 fichier.txt

javac -d ./bin -sourcepath ./src src/RandomNumbers.java
java -cp ./bin RandomNumbers

javadoc -docletpath ~/Téléchargements/UmlGraph.jar -doclet org.umlgraph.doclet.UmlGraph -package -attributes -operations -types src/*.java
dot -Tpng -ograph.png graph.dot

sed -i '1iLigne1' test.txt
