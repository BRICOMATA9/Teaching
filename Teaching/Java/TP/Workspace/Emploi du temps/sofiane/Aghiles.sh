cd ~/Bureau/sofiane/schedular

javac -d bin -cp lib/Mysql.jar -sourcepath src src/*/*.java

java -cp bin:lib/Mysql.jar schedular.Schedular

javadoc -cp ./lib/junit-4.11.jar:lib/Date.jar -docletpath ~/Téléchargements/UmlGraph.jar -doclet org.umlgraph.doclet.UmlGraph src/*/*.java
dot -Tpng -ograph.png graph.dot

