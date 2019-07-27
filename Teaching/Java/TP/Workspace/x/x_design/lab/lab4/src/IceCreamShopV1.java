/**
 * Demonstration of the Factory pattern
 */

public class IceCreamShopV1 {

 private IceCreamFactory factory;
 
 public IceCreamShopV1(IceCreamFactory factory) {
  this.factory = factory;
 }
 
 public IceCream orderCone(String type) {
  IceCream cone;
  
  cone = factory.getIceCream(type);
  
  cone.scoop();
  
  return cone;
 }
 
 public static void main(String[] args) {
  IceCreamFactory factory = new IceCreamFactory();
  IceCreamShopV1 shop = new IceCreamShopV1(factory);
  
  shop.orderCone("Chocolate");
 }
}
