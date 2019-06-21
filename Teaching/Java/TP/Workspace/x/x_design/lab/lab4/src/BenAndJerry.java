/**
 * An implementation of IceCreamShop
 */

public class BenAndJerry extends IceCreamShop {

 public IceCream getIceCream(String type) {
  if (type.equals("Chunky Monkey"))
   return new ChunkyMonkey();
  else if (type.equals("Cherry Garcia"))
   return new CherryGarcia();
  else
   return null;
 }
 
 public static void main(String[] args) {
   IceCreamShop bAndJ = new BenAndJerry();
   IceCream cone;
   
   cone = bAndJ.orderCone("Cherry Garcia");
   System.out.println("Enjoying some " + cone.getDescription() + " which costs " + cone.cost());
 }

}
