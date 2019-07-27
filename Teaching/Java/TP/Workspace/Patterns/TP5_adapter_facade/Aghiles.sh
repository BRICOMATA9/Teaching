javadoc -docletpath ~/Téléchargements/UmlGraph.jar -doclet org.umlgraph.doclet.UmlGraph -package -attributes -operations -types src/adapter/TestAdapter/*.java
dot -Tpng -ograph.png graph.dot

javac -d ./bin -sourcepath ./src src/adapter/EnumerateTest/EnumerateTest.java
java -cp ./bin adapter.EnumerateTest.EnumerateTest

javac -d ./bin -sourcepath ./src src/adapter/IterateTest/IterateTest.java
java -cp ./bin adapter.IterateTest.IterateTest

javac -d ./bin -sourcepath ./src src/adapter/PlanetClient/PlanetClient.java
java -cp ./bin adapter.PlanetClient.PlanetClient

javac -d ./bin -sourcepath ./src src/adapter/PlanetClientNoAdapter/PlanetClientNoAdapter.java
java -cp ./bin adapter.PlanetClientNoAdapter.PlanetClientNoAdapter

javac -d ./bin -sourcepath ./src src/adapter/TestAdapter/TestAdapter.java
java -cp ./bin adapter.TestAdapter.TestAdapter


javac -d ./bin -sourcepath ./src src/facade/MakeTea/MakeTea.java
java -cp ./bin facade.MakeTea.MakeTea

javac -d ./bin -sourcepath ./src src/facade/MakeTeaInParallel/MakeTeaInParallel.java
java -cp ./bin facade.MakeTeaInParallel.MakeTeaInParallel

javac -d ./bin -sourcepath ./src src/adapter/IterateTestAdapter/IterateTest.java
java -cp ./bin adapter.IterateTestAdapter.IterateTest


