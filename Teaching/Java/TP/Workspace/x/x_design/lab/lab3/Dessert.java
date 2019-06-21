// This acts as the component
// Instances of this class will be decorated.

public abstract class Dessert {
 protected String description;

 // returns the description of the ice cream
 public String getDescription() {
  return description;
 }
 
 // returns the cost of the ice cream
 public abstract double cost();
}
