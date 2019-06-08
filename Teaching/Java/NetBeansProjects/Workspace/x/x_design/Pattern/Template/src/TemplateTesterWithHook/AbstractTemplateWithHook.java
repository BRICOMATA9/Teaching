package TemplateTesterWithHook;
public abstract class AbstractTemplateWithHook {
 final void templateMethod() {
  operation1();
  operation2();
	if (hook())
		operation3();  // note the call to the hook()
 }
 
 abstract void operation1();
 
 abstract void operation2();
 
 final  void operation3() {
  System.out.println("I am defined in the super class.");
 }
 
 /**
   * A hook allows a subclass to "hook" into the algorithm
  * if they wish to. Its default implementation is empty and
  * a subclass can override the hook if it wishes.
  */
 boolean hook() {
  return true;
 }
}
