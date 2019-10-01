cd ~/Bureau/Emploi_du_temps

javac -d bin -sourcepath src -cp lib/Mysql.jar:lib/Date.jar src/Interface/Login.java
java -cp bin:lib/Mysql.jar:lib/Date.jar Interface.Login
