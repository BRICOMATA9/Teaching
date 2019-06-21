package TestSorter;

public abstract class SortFactory {
 protected String algorithm;

 public void setFactory(String algorithm) {
  this.algorithm = algorithm;
 }

 public abstract SortingAlgorithm getAlgorithm();
}
