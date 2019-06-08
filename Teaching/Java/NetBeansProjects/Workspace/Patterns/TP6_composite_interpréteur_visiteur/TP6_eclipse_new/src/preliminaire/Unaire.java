package preliminaire;

public abstract class Unaire extends Expression{

  protected Expression op;

  public Unaire(Expression op){
    this.op = op; 
  }
}