javac -d ./bin -sourcepath ./test:./src -cp ../junit-4.11.jar ./test/a_Introductory/FibonacciTest.java

java -cp ./bin:../junit-4.11.jar junit.textui.TestRunner a_Introductory.FibonacciTest
