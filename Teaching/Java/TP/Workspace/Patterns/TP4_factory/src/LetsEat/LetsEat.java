package LetsEat;

public class LetsEat {
 
 public static void main(String[] args) {
  IceCreamShop shop1 = new DairyQueen();
  shop1.orderCone("Chocolate");

  IceCreamShop shop2 = new BenAndJerry();
  shop2.orderCone("Cherry Garcia");
  
 }
}
