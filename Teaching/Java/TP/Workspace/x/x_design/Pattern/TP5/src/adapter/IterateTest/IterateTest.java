package adapter.IterateTest;

import java.util.*;

public class IterateTest
{
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		v.add("one");		
		v.add("two");		
		v.add("three");		
		v.add("four");		

		// the recommended technique ....
		Iterator i = v.iterator();

		System.out.println("Iteration ..... the \"new-style\" way");
		while (i.hasNext())
			System.out.println(i.next());
	}
}
