javac -d ./bin -sourcepath ./src src/TestJavaUtilStack.java
java -cp ./bin TestJavaUtilStack

javac -d ./bin -sourcepath ./src src/UseList.java
java -cp ./bin UseList

javac -d ./bin -sourcepath ./src src/TestCompositionStack.java
java -cp ./bin TestCompositionStack

javadoc -docletpath ~/Téléchargements/UmlGraph.jar -doclet org.umlgraph.doclet.UmlGraph -package src/*.java
dot -Tpng -ograph.png graph.dot

javadoc -docletpath ~/Téléchargements/UmlGraph.jar -doclet org.umlgraph.doclet.UmlGraph -nodefontsize 9 -edgefontsize 9 -nodefillcolor LemonChiffon -package -attributes -operations -types SortedVector.java

javadoc -docletpath ~/Téléchargements/UmlGraph.jar -doclet org.umlgraph.doclet.UmlGraph -package -attributes -operations -types src/*.java
dot -Tpng -ograph.png graph.dot
