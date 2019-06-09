/**
 * This is the abstract class forming the basis of our factory.
 *
 */
public abstract class IceCreamShop {
 
 public IceCream orderCone(String type) {
  IceCream cone;
  
  cone = getIceCream(type);
  
  cone.scoop();
  
  return cone;
 }
 
 /**
  * Returns an IceCream based upon the specified type.
  */
 public abstract IceCream getIceCream(String type);

}
