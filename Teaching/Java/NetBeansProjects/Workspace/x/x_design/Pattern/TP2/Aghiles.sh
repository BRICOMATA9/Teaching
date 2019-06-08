javac -d ./bin -sourcepath ./src src/Auction1/Auction.java
java -cp ./bin Auction1.Auction

javac -d ./bin -sourcepath ./src src/Auction2/Auction.java
java -cp ./bin Auction2.Auction

javadoc -docletpath ~/Téléchargements/UmlGraph.jar -doclet org.umlgraph.doclet.UmlGraph -package -attributes -operations -types src/Auction2/*.java
dot -Tpng -ograph.png graph.dot
