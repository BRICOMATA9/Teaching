/**
 * Test the implementation of the CompositionStack.
 */

class TestCompositionStack
{
 public static void main(String[] args) {
  CompositionStack<String> dishes = new CompositionStack<String>();

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
    * We can't do the following any longer w/o a compile error!
   *
   * dishes.insertElementAt("Genghis",3);
   */

  // the stack now contains Frank, Genghis, Carol, Bob,  Alice

  System.out.println("The Stack Contains ...");
  while (!dishes.empty())
   System.out.println(dishes.pop());
 }
}
