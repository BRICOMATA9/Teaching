import java.util.Scanner;
import java.lang.String;
public class test3
{
 private static Boolean fonction(String ch1,String ch2)
 { 
  if(ch1.indexOf(ch2)!=-1) return(true);
    else return(false); 
 }
 private static Scanner scan=new Scanner(System.in);
 public static void main(String[]args)
 {
  System.out.println(fonction(scan.nextLine(),scan.nextLine()));
 }
}
