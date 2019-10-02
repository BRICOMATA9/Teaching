import java.util.Scanner;
import java.lang.StringBuffer;
import java.lang.String;
import java.lang.Math;
public class test6
{
 private static Scanner scan=new Scanner(System.in);
 public static void main(String[]args)
 {
  String chaine="";
  long start = System.nanoTime();
  int i;
   for(i=0;i<1000;i++)
   chaine+=i+",";
   for(i=0;i<10000;i++)
   chaine+=i+",";
   for(i=0;i<20000;i++)
   chaine+=i+",";
   for(i=0;i<40000;i++)
   chaine+=i+",";
   for(i=0;i<60000;i++)
   chaine+=i+",";  
   System.out.println(chaine);
   long duree = System.nanoTime() - start;
   System.out.println(duree+" nano seconde");
 } 
}
 


