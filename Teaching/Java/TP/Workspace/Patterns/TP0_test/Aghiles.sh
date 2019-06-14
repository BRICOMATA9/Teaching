javadoc -docletpath ~/Téléchargements/UmlGraph.jar -doclet org.umlgraph.doclet.UmlGraph -package -attributes -operations -types src/b_Money/*.java
dot -Tpng -ograph.png graph.dot

javac -d ./bin -sourcepath ./test:./src -cp ./lib/junit-4.11.jar ./test/a_Introductory/FibonacciTest.java
java -cp ./bin:./lib/junit-4.11.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore a_Introductory.FibonacciTest

javac -d ./bin -sourcepath ./test:./src -cp ./lib/junit-4.11.jar ./test/a_Introductory/LineTest.java
java -cp ./bin:./lib/junit-4.11.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore a_Introductory.LineTest

javac -d ./bin -sourcepath ./test:./src -cp ./lib/junit-4.11.jar ./test/a_Introductory/PointTest.java
java -cp ./bin:./lib/junit-4.11.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore a_Introductory.PointTest


javac -d ./bin -sourcepath ./test:./src -cp ./lib/junit-4.11.jar ./test/a_Introductory/QuadrilateralTest.java
java -cp ./bin:./lib/junit-4.11.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore a_Introductory.QuadrilateralTest


javac -d ./bin -sourcepath ./test:./src -cp ./lib/junit-4.11.jar ./test/a_Introductory/Vector2DTest.java
java -cp ./bin:./lib/junit-4.11.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore a_Introductory.Vector2DTest

javac -d ./bin -sourcepath ./test:./src -cp ./lib/junit-4.11.jar ./test/b_Money/AccountTest.java
java -cp ./bin:./lib/junit-4.11.ja:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore b_Money.AccountTest

javac -d ./bin -sourcepath ./test:./src -cp ./lib/junit-4.11.jar ./test/b_Money/BankTest.java
java -cp ./bin:./lib/junit-4.11.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore b_Money.BankTest

javac -d ./bin -sourcepath ./test:./src -cp ./lib/junit-4.11.jar ./test/b_Money/CurrencyTest.java
java -cp ./bin:./lib/junit-4.11.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore b_Money.CurrencyTest

javac -d ./bin -sourcepath ./test:./src -cp ./lib/junit-4.11.jar ./test/b_Money/MoneyTest.java
java -cp ./bin:./lib/junit-4.11.jar:./lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore b_Money.MoneyTest