/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 2 : Communiquer une information
#	Section  : La saisie de données
#	Fichier  : TestLectureClavier.java
#	Class    : TestLectureClavier
*/
import java.util.*;
public class TestLectureClavier {
 public static void main (String [] Arg) {
   int intLu;
   float floatLu;
   double doubleLu;
   char charLu;
   byte byteLu;
   long longLu;
   short shortLu;
   String stringLu;

   Scanner lectureClavier = new Scanner(System.in);
   lectureClavier.useLocale(Locale.US);

   System.out.println("Entrez un short : ");
   shortLu = lectureClavier.nextShort();
   System.out.println("Entrez un byte : ");
   byteLu = lectureClavier.nextByte();
   System.out.println("Entrez un int : ");
   intLu = lectureClavier.nextInt();
   System.out.println("Entrez un long : ");
   longLu = lectureClavier.nextLong();
   System.out.println("Entrez un float : ");
   floatLu = lectureClavier.nextFloat();
   System.out.println("Entrez un double : ");
   doubleLu = lectureClavier.nextDouble();
   System.out.println("Entrez un String: ");
   stringLu = lectureClavier.next();
   System.out.println("Entrez un char : ");
   charLu = lectureClavier.next().charAt(0);
   System.out.println("entier : " + intLu);
   System.out.println("float : " + floatLu);
   System.out.println("double : " + doubleLu);
   System.out.println("char : " + charLu);
   System.out.println("byte : " + byteLu);
   System.out.println("short : " + shortLu);
   System.out.println("String : " + stringLu);
   System.out.println("long : " + longLu);
 }
}