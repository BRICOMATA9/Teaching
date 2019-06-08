interface Animal{
	void washInTheTub() throws TooBigToWashException;
	String noise();
}

class Cat implements Animal{
	public void washInTheTub(){
		System.out.println("I'm washing a cat");
	}
	public String noise() {
		return "Miaou";
	}

}

class Dog implements Animal{
	public void washInTheTub(){
		System.out.println("I'm washing a dog");
	}
	public String noise() {
		return "Wooof";
	}

}

class Bear implements Animal{
	public void washInTheTub() throws TooBigToWashException {
		throw new TooBigToWashException();
	}
	public String noise() {
		return "Grrr";
	}
	public void f() {
	try {
	washInTheTub();
	}
	catch (TooBigToWashException e) {
	System.out.println(e);	
	}
	}

}

class TooBigToWashException extends Exception {}