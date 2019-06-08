javac -d bin -sourcepath src src/Holstein/Holstein.java
java -cp bin Holstein.Holstein

javac -d bin -sourcepath src src/IO/IO.java
java -cp bin IO.IO

javac -d bin -sourcepath src src/IO/IOExample.java
java -cp bin IO.IOExample

javadoc -docletpath ~/Téléchargements/UmlGraph.jar -doclet org.umlgraph.doclet.UmlGraph -package -attributes -operations -types src/Holstein/*.java
dot -Tpng -ograph.png graph.dot

javadoc -docletpath ~/Téléchargements/UmlGraph.jar -doclet org.umlgraph.doclet.UmlGraph -package -attributes -operations -types src/IO/*.java
dot -Tpng -ograph.png graph.dot
