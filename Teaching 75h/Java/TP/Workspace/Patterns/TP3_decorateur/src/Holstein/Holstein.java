package Holstein;
// Test code for the decorator pattern.

public class Holstein {
 public static void main(String[] args) {
	 
  Dessert vanille = new Vanilla();
  System.out.println(vanille.getDescription());
  System.out.println(vanille.cost());
  
  // now decorate the vanilla with a cherry
  IceCreamDecorator cherry = new Cherry(vanille);
  System.out.println(cherry.getDescription());
  System.out.println(cherry.cost());
  
  // now add a WhippedCream
  IceCreamDecorator whippedCream = new WhippedCream(vanille);
  System.out.println(whippedCream.getDescription());
  System.out.println(whippedCream.cost());
  
  // now add HotFudge
  IceCreamDecorator hotFudge = new HotFudge(vanille);
  System.out.println(hotFudge.getDescription());
  System.out.println(hotFudge.cost());

 }
}
