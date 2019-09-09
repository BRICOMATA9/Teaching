package adapter.IterateTestAdapter;

import java.util.*;

public class IterateTest
{
	public static void main(String[] args) {
		OldStyleList<String> osl = new OldStyleList<String>();
		osl.add("one");		
		osl.add("two");		
		osl.add("three");		
		osl.add("four");

		// the recommended technique ....
		Enumeration<String> e = osl.elements();
		Iterator<String> i = new EnumerationAdapter<String>(e);

		System.out.println("Iteration ..... the \"new-style\" way");
		while (i.hasNext())
			System.out.println(i.next());
	}
}