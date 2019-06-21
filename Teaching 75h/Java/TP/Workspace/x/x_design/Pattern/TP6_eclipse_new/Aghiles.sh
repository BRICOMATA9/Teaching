javac -d ./bin -cp ./lib/junit-4.11.jar -sourcepath ./src src/preliminaire/*.java
java -cp ./bin:./lib/junit-4.11.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore preliminaire.TestGlobal

javac -d ./bin -cp ./lib/junit-4.11.jar -sourcepath ./src src/question1/*.java
java -cp ./bin:./lib/junit-4.11.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore question1.MemoireTest
java -cp ./bin:./lib/junit-4.11.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore question1.TestsAVerifier
java -cp ./bin:./lib/junit-4.11.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore question1.TestsACompleter

javac -d ./bin -sourcepath ./src src/question2/*.java
java -cp ./bin:./lib/junit-4.11.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore question2.TestsDuVisiteurBoolEvaluation
java -cp ./bin:./lib/junit-4.11.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore question2.TestsDuVisiteurBoolToJava
java -cp ./bin:./lib/junit-4.11.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore question2.TestsDuVisiteurBoolToString

javac -d ./bin -sourcepath ./src src/question3/*.java
java -cp ./bin:./lib/junit-4.11.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore question3.ClasseJavaTest
java -cp ./bin:./lib/junit-4.11.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore question3.TestsAVerifier
java -cp ./bin:./lib/junit-4.11.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore question3.TestsDesAssertionsAVerifier

javadoc -cp ./lib/junit-4.11.jar -docletpath ~/Téléchargements/UmlGraph.jar -doclet org.umlgraph.doclet.UmlGraph -package -attributes -operations -types src/*/*.java
dot -Tpng -ograph.png graph.dot

sed -i '1iLigne1' test.txt
