import java.util.Scanner;
import java.lang.String;
public class test7
{
 private static Scanner scan =new Scanner(System.in);
 
 public static void main (String[] args)
 {
//  String chaine=scan.nextLine();
  System.out.println(occurence('a',scan.next()));
//  int t[]=new int[21];
//  t[0]=t[1]=t[2]=t[3]=t[4]=t[5]=0;
//  for(int i=0;i<chaine.length();i++)
// {
//  if(chaine.charAt(i)=='a'||chaine.charAt(i)=='A')t[0]++;
//  if(chaine.charAt(i)=='e'||chaine.charAt(i)=='E')t[1]++;
//  if(chaine.charAt(i)=='i'||chaine.charAt(i)=='I')t[2]++;
//  if(chaine.charAt(i)=='o'||chaine.charAt(i)=='O')t[3]++;
//  if(chaine.charAt(i)=='u'||chaine.charAt(i)=='U')t[4]++;
//  if(chaine.charAt(i)=='y'||chaine.charAt(i)=='Y')t[5]++;
//  }
//  System.out.println(t[0]+" fois la lettre a");
//  System.out.println(t[1]+" fois la lettre e");
//  System.out.println(t[2]+" fois la lettre i");
//  System.out.println(t[3]+" fois la lettre o");
//  System.out.println(t[4]+" fois la lettre u");
//  System.out.println(t[5]+" fois la lettre y");
 }
 
 public static int occurence(char ch,String s){
 	int i,cpt=i=0;
 	while(s.indexOf(ch,i)!=-1){
 		cpt++;
 		i=s.indexOf(ch,i)+1;
 	}
 	return(cpt);
 }
} 
 
