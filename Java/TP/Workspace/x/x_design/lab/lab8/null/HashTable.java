/**
 * This simulates a hash table.
 * 
 * At various (random) elements in the hashTable array
 * we store an iteration of elements
 */

import java.util.*;

public class HashTable
{
  static final int MAX = 11;
  
  public static void main(String[] args) {
    
    Random random = new Random();
    Object[]  hashTable = new Object[MAX];
    
    NullIterator n = new NullIterator();
    
    for (int i = 0; i < MAX; i++)
      hashTable[i] = n;
    
    // we are simulating placing lists into the hash table
    ArrayList<String> l1 = new ArrayList<String>();
    l1.add("alpha");
    l1.add("beta");
    l1.add("gamma");
    hashTable[random.nextInt(MAX)] = l1.iterator();
    
    ArrayList<String> l2 = new ArrayList<String>();
    l2.add("delta");
    l2.add("epsilon");
    l2.add("zeta");
    hashTable[random.nextInt(MAX)] = l2.iterator();
    
    ArrayList<String> l3 = new ArrayList<String>();
    l3.add("eta");
    l3.add("theta");
    l3.add("iota");
    hashTable[random.nextInt(MAX)] = l3.iterator();
    
    /**
     * This is how we would have to do it 
     * without a null iterator:
     
    for (int i = 0; i < MAX; i++) {
      System.out.println("\n\n"+ i +"::");
      if (hashTable[i] != null) {
        Iterator itr = (Iterator)hashTable[i];
        while (itr.hasNext())
          System.out.println(itr.next());
      }
    }
    */
    
    
    /**
     * This is how we would can do it 
     * with a null iterator:
    */
    for (int i = 0; i < MAX; i++) {
      System.out.println("\n\n"+ i +"::");
      Iterator itr = (Iterator)hashTable[i];
      while (itr.hasNext())
        System.out.println(itr.next());
    }
     
  }
}
