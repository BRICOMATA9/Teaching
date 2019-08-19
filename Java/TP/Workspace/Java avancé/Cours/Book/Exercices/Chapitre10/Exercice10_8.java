/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 2 : Communiquer une information
#	Exercice : 10.8
#	Fichier  : Exercice10_8.java
#	Class    : Exercice10_8 
*/
import java.io.*;
public class Exercice10_8 {
   public static void main(String[] args) {

      String encodage = System.getProperty("file.encoding");
      System.out.println("Encodage par défaut : " + encodage);
      String proverbe = "Qui s\u00E8me le vent, r\u00E9colte la temp\u00EAte" ;  
      try {
          String proverbeEncode = new String ( proverbe.getBytes(), encodage );
          System.out.println("Proverbe encode : " + proverbeEncode );
        
      } catch (UnsupportedEncodingException e) {
          System.out.println("L'encodage " + encodage + " n'est pas supporté par l'interpréteur Java");
      }    
   } 
}