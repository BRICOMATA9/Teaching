package question3;

/** NFP121 question3, tp6
   source Java genere par lintermediaire d'un visiteur "toJava"
*/
public class Mult{

  public static void main(String[] args){
    int a=7;
    int b=85;
    int z=0;

    while(b > 0){
      
      if(((b - ((b / 2) * 2)) == 1)){
        z = (z + a);
        b = (b - 1);
      }else{
        a = (a * 2);
        b = (b / 2);
      };
    }
  }

}
