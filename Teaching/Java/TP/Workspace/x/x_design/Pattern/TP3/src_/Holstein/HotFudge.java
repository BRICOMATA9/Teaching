package Holstein;
public class HotFudge extends IceCreamDecorator {
 // the dessert we are decorating
 // notice the use of composition rather than inheritance
 protected Dessert flavor; 

 public static final double COST = 0.60;

 public HotFudge(Dessert flavor) {
  this.flavor = flavor;
 }
 
 public String getDescription() {
  return flavor.getDescription() + " with a Hot Fudge";
 }

 public double cost() {
  return flavor.cost() + COST;
 }
}
