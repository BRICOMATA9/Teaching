package Holstein;
public class WhippedCream extends IceCreamDecorator {
 // the dessert we are decorating
 // notice the use of composition rather than inheritance
 protected Dessert flavor; 

 public static final double COST = 0.25;

 public WhippedCream(Dessert flavor) {
  this.flavor = flavor;
 }
 
 public String getDescription() {
  return flavor.getDescription() + " with a Whipped Cream";
 }

 public double cost() {
  return flavor.cost() + COST;
 }
}
