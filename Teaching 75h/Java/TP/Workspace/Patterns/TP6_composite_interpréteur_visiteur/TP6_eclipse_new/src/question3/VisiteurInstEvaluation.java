package question3;

import question1.*;
import question2.*;
/**
 * Visisteur dinstruction, chaque classe concrete possede une implementation de la visite
 * 
 */
public class VisiteurInstEvaluation extends VisiteurInstruction<Contexte>{

  private VisiteurExpression<Integer> vi;
  private VisiteurExpressionBooleenne<Boolean> vb;
  
  /** Creation dun visiteur dinstructions
   * @param vi le visiteur dexpressions arithmetiques
   * @param vb le visiteur dexpression booleennes
   */
  public VisiteurInstEvaluation(VisiteurExpression<Integer> vi, VisiteurExpressionBooleenne<Boolean> vb){
    this.vi = vi;
    this.vb = vb;
  }

  /** obtention du contexte, ici celui du visiteur dexpression arithmetiques 
   * @return le contexte ici de vi(le visiteur dexpression)
   */
  public Contexte contexte(){
    return this.vi.contexte();
  }

  /** Visite dune instance de la classe Affectation.
   * 
   * laffectation, X = Exp, Exp est une expression arithmetique <br> 
   * <code>
   * 
   *     M,Exp -interprete-> N       <br>      
   * ________________________________<br>               
   * M, X = Exp -interprete-> M[X]=N <br>
   * </code>
   * 
   * @param a  une affectation
   * @return la memoire resultante 
   */
  public Contexte visite(Affectation a){
    // a completer
    
    return null; // a completer en retournant le contexte modifie;
  }
  
  /** Visite dune sequence seq(I1,I2) <br>
   * <code>
   * 
   *    M,I1 -interprete-> M1        <br>
   *    M1,I2 -interprete-> M2       <br>
   * ________________________________<br>
   *    M,seq(I,I2)-interprete-> M2  <br>
   *</code>
   * 
   * @param seq  une sequence
   * @return la memoire resultante 
   */
 public Contexte visite(Sequence seq){
    seq.i1().accepter(this);
    seq.i2().accepter(this);
    return this.vi.contexte();
  }
  
  /** Visiste dune selection si (Bexp) alors I1 sinon I2 fsi <br>
   * ou si (Bexp) alors I1 fsi <br>
   *
   * <code>
   * 
   *      M,Bexp-interprete-> vrai             <br>
   *      M,I1 -interprete-> M1                <br>
   * _________________________________________ <br>               
   * M,si(Bexp)alorsI1 sinon I2-interprete-> M1<br>
   * 
   *      M,Bexp -interprete-> faux            <br>
   *      M,I2 -interprete-> M2                <br>
   * __________________________________________<br>
   * M,si(Bexp)alorsI1 sinon I2-interprete->M2 <br>
   * </code>
   * 
   * @param sel  une selection
   * @return la memoire resultante 
   */
 public Contexte visite(Selection sel){
// a completer
// a completer
// a completer
// a completer
    return null; // a completer en retournant le contexte modifie;
  }
  
  /** La boucle tantque(Bexp,I1)<br>
   * <code>
   * 
   *     M,Bexp -interprete->faux              <br>
   * _________________________________________ <br>
   * M,tantque(Bexp) faire I1-interprete-> M   <br>
   * <br>
   * M,Bexp -interprete-> vrai                          <br>
   * M,seq(I1,tantque(Bexp)faire I1)-interprete-> M1    <br>
   * ___________________________________________________<br>                 
   * M,tantque(Bexp)faire I1-interprete-> M1
   * </code>
   * 
   * @param tq  une iteration de la classe tantque
   * @return la memoire resultante 
   */
  public Contexte visite(TantQue tq){
    // a completer
    // a completer
    return this.vi.contexte();
  }

  


  /** La boucle pour(init,Bexp,inc)I1<br>
   * <code>
   * M,seq(init,tantque(Bexp)seq(I1,inc))-visite->faux <br>
   * _____________________________________________________ <br>
   * M,pour(init,Bexp,inc) faire I1-visite-> M         <br>
   * </code>
   * 
   * @param pour  une iteration de la classe Pour
   * @return la memoire resultante 
   */  
  public Contexte visite(Pour pour){
// a completer
// a completer
// a completer
// a completer
    return null; // a completer en retournant le contexte modifie;
  }
  


  /** Laffichage<br>
   * <code>
   *     
   *    M,Exp-visite-> n                              <br>
   * ________________________________System.out.print(n)<br>                 
   * M,afficher(Exp)-visite-> M
   * </code>
   * 
   * @param a  une instruction daffichage dune expression arithmetique
   * @return la memoire intacte 
   */
  public Contexte visite(Afficher a){
    System.out.println(a.exp().accepter(this.vi));
    return this.vi.contexte();
  }
  

  
  /** Une assertion, 
   * si celle-ci echoue une exception est levee, 
   * emploi de la clause <a href=http://java.sun.com/j2se/1.5.0/docs/guide/language/assert.html> assert</a> Expr : "un Message";
   * 
   * @param a  une assertion
   * @return la memoire intacte 
   * @throws une exception AssertionError
   */
  public Contexte visite(Assertion a) {
// a completer
// a completer par lusage de assert de java, installer loption \"-ea\" ligne 480 de bluej.defs soit bluej.vm.args=-ea
// a completer
// a completer
    return null; // a completer en retournant le contexte modifie;
  }
  


}
