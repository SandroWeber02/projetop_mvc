@ECHO OFF
CLS

javac -verbose .\model\ConexaoBd.java
javac -verbose .\model\Usuario.java
javac -verbose .\model\Emprestimo.java -Xlint:unchecked
javac -verbose .\model\Reserva.java

javac -verbose -classpath C:\xampp\tomcat\lib\servlet-api.jar;. .\controller\ServletAutenticacao.java
javac -verbose -classpath C:\xampp\tomcat\lib\servlet-api.jar;. .\controller\ServletExtrato.java
javac -verbose -classpath C:\xampp\tomcat\lib\servlet-api.jar;. .\controller\ServletRenovacao.java

ECHO.
ECHO.
PAUSE