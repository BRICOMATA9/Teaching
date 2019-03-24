javac -d bin -sourcepath src src/
java -cp bin 

javadoc -docletpath ~/Téléchargements/UmlGraph.jar -doclet org.umlgraph.doclet.UmlGraph -package -attributes -operations -types src/*.java
dot -Tpng -ograph.png graph.dot
