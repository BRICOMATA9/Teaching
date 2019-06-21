import java.util.Scanner;
import java.lang.String;
public class Test12
{
 private static boolean sous_chaine(String str1,String str2)
 {
  if(str1.indexOf(str2)==-1) return false;
   else return true;
 }
 private static Scanner scan=new Scanner(System.in);
 public static void main (String[] args)
 {
  System.out.println(sous_chaine(scan.nextLine(),scan.nextLine()));
 }
}  
