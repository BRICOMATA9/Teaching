package LetsEat;

public class Vanilla extends IceCream {
 public static final double COST = 1.25;
 
 public Vanilla() {
  description = "Flavor Vanilla";
 }

 public double cost() {
  return COST;
 }
}
