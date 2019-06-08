package TestSorter;

public class NonRecursive extends SortFactory{

	public SortingAlgorithm getAlgorithm(){
		if(algorithm == "Selection")
			return new SelectionSort();
		else
			return null;
	}
}
