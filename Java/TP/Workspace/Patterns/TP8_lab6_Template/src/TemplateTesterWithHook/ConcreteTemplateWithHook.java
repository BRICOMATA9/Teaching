package TemplateTesterWithHook;

public class ConcreteTemplateWithHook extends AbstractTemplateWithHook {
	void operation1() {
		System.out.println ("I am defined in the sub class.");
	}

	void operation2() {
		System.out.println ("I am defined in the sub class.");
	}

	/**
	 * Here the subclass decides to override the hook defined
	 * in the parent class.
	 */
	boolean hook() {
		java.util.Random random = new java.util.Random();
		boolean rv = random.nextBoolean();
		return false;
	}
}
