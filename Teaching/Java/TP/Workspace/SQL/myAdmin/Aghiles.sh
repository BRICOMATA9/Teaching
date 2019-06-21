cd Bureau/JavaMyAdmin
export CLASSPATH=$CLASSPATH:/home/aghiles/Bureau/JavaMyAdmin/lib/mysql-connector-java-5.1.13-bin.jar
export CLASSPATH=$CLASSPATH:/home/aghiles/Bureau/JavaMyAdmin/lib/mysql-connector-java-5.1.17-bin.jar
export CLASSPATH=$CLASSPATH:/home/aghiles/Bureau/JavaMyAdmin/lib/mysql-connector-java-5.1.19-bin.jar

javac -d bin -sourcepath src src/javamyadmin/*.java
java -cp lib/mysql-connector-java-5.1.19-bin.jar:bin javamyadmin.Main
