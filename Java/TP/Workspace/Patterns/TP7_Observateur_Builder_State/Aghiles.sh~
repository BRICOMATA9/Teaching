javac -d bin -sourcepath src src/builder/ParseTest.java
java -cp bin builder.ParseTest

javac -d bin -sourcepath src src/state/GumballMachineTestDrive.java
java -cp bin state.GumballMachineTestDrive

javac -d bin -encoding Cp1252 -sourcepath src -cp bin:lib/junit-4.11.jar src/question1/*.java
java -cp bin:lib/junit-4.11.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore question1.PatternObservateur

javac -d bin -encoding Cp1252 -sourcepath src -cp bin:lib/junit-4.11.jar src/question2/*.java
java -cp bin:lib/junit-4.11.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore question2.

javac -d bin -encoding Cp1252 -sourcepath src -cp bin:lib/junit-4.11.jar src/question3/*.java
java -cp bin:lib/junit-4.11.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore question3.PileModeleTest


javadoc -encoding Cp1252 -cp ./lib/junit-4.11.jar -docletpath ~/Téléchargements/UmlGraph.jar -doclet org.umlgraph.doclet.UmlGraph -package -attributes src/question1/*.java
dot -Tpng -ograph.png graph.dot
