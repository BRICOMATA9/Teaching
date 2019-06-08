public class Test8
{
 private int age;
 private String nom,prenom;
 private String adress;
 public Test8 (int age,String nom,String prenom,String adress)
 {
  this.age=age;
  this.nom=nom;
  this.prenom=prenom;
  this.adress=adress;
 }
 public void presentation (int k)
 {
  System.out.println("je m'appelle "+nom+" "+prenom+", j'ai "+age+" ans, j'habite à "+adress);
  k=5;
 }
} 
