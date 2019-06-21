import java.util.Scanner;
public class Test11
{ 
 private static Scanner scan=new Scanner(System.in);
 public static void main (String[] args)
 {
  String str="";
  int n=scan.nextInt();
  Test10[] A=new Test10[n];
  String T[]=new String[n];
  for(int i=0;i<n;i++) T[i]=scan.nextLine();
  for(int i=0;i<n;i++) A[i]=new Test10(T[i]);
  int max=0;
  for(int i=0;i<n;i++) if (A[i].LongSequence()>max) {max=A[i].LongSequence();str=A[i].str;}
  System.out.println(str);
 }
}
