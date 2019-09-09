cd ~/Bureau/schedular
javac -d bin -sourcepath src src/*/*.java
java -cp bin:lib/mysql.jar schedular.Schedular

javadoc -docletpath ~/Téléchargements/UmlGraph.jar -doclet org.umlgraph.doclet.UmlGraph -package -attributes -operations -types src/*/*.java
dot -Tpng -ograph.png graph.dot