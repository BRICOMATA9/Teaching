cd /home/aghiles/Bureau/gestion/JavaMyAdmin

javac -d bin -sourcepath src src/javamyadmin/LoginDialog.java
java -cp bin:lib/mysql.jar javamyadmin.LoginDialog
