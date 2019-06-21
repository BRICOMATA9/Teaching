/**
 * AbstractTemplate.java
 *
 * This abstract class identifies the template method
 * pattern whereby the steps of an algorithm are defined
 * and it allows subclasses to to provide an implementation
 * for one or more steps.
 */

public abstract class AbstractTemplate {
	/**
	 * The steps of the algorithm
	 * We declare this is final as we
	 * do not want the subclasses to change
	 * the algorithm.
	 */
	final void templateMethod() {
		operation1();
		operation2();
		operation3();
	}
	
	abstract void operation1();
	
	abstract void operation2();
	
	final void operation3() {
		System.out.println("I am defined in the super class.");
	}
}
