/**
 * This program demonstrates when *not* to use inheritance
 * the class java.util.Stack is derived from java.util.Vector
 * This means you can perform Vector operations on a stack as well.
 */
 
class TestJavaUtilStack
{
 public static void main(String[] args) {
  java.util.Stack<String> dishes = new java.util.Stack<String>();
 
  String[] names = new String[5];
  names[4] = "Eric";
  names[3] = "Dave";
  names[2] = "Carol";
  names[1] = "Bob";
  names[0] = "Alice";

  for (int i = 0; i < names.length; i++)
   dishes.push(names[i]);

  // let's try a few stack statements
  System.out.println(dishes.peek());
  System.out.println(dishes.pop());
  System.out.println(dishes.pop());
  dishes.push("Frank");
  System.out.println(dishes.peek());

  // so far .. so good
  // the stack now contains Frank, Carol, Bob, Alice

  /**
   * but java.util.Stack is derived from java.util.Vector
   * insertElementAt() is a method from the Vector class
   */
  dishes.insertElementAt("Genghis",3);

  // the stack now contains Frank, Genghis, Carol, Bob,  Alice
  //
  // we have broken the contract of the stack!

  System.out.println("The Stack Contains ...");
  while (!dishes.empty())
   System.out.println(dishes.pop());
 }
}
