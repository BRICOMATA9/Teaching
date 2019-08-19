package question1;

public class VisiteurParDefaut<T> extends VisiteurExpression<T>{

  public T visite(Constante c){return null;}
  public T visite(Variable v){return null;}
  public T visite(Division d){return null;}
  public T visite(Addition a){return null;}
  public T visite(Multiplication m){return null;}
  public T visite(Soustraction s){return null;}
  
  public Contexte contexte(){return null;}
  
}
