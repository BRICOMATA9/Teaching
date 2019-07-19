import java.lang.String;
public class Test10
{
 public String str;
 private int length;
 private char[] tab;  
 public Test10 (String str)
 {
  this.str=str;
  tab=new char[str.length()];
  for(int i=0;i<str.length();i++) tab[i]=str.charAt(i);
  length=str.length();
 }
 
 public boolean Sequence()
 { 
  boolean b=false;
  for(int i=0;i<length-1 && !b;i++) if (tab[i]==tab[i+1]) b=true;
  return b;
 }
 
 public int NbSequence()
 {
  int cpt=0;
  for(int i=0;i<length-1;i++)
   if(tab[i]==tab[i+1])
   {
    cpt++;
    while(i<length-1 && tab[i]==tab[i+1]) i++;
   }
   return cpt;
 }
 
 public int LongSequence()
 {
  int cpt,max,i=max=0;
  while(i<length-1)
   {
    cpt=1;
    while(i<length-1 && tab[i]==tab[i+1]) {i++;cpt++;}
    i++;
    if (cpt>max) max=cpt;
   }
   
   return max;
 }
}
 
