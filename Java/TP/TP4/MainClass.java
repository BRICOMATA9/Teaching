import java.util.Arrays;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.Collections;

class Person implements Comparable<Person> {
  private String firstName;
  private String surname;
  
  public Person(String firstName, String surname) {
    this.firstName = firstName;
    this.surname = surname;
  }
  public String getFirstName() {
    return firstName;
  }
  public String getSurname() {
    return surname;
  }
  public String toString() {
    return firstName + " " + surname;
  }
  
  public int compareTo(Person person) {
    int result = surname.compareTo(person.surname);
    return result == 0 ? firstName.compareTo(((Person) person).firstName) : result;
  }
}

class ComparePersons implements Comparator<Person> {

  public int compare(Person person1, Person person2) {
    int result = -person1.getSurname().compareTo(person2.getSurname());
    return result == 0 ? -person1.getFirstName().compareTo(person2.getFirstName()) : result;
  }
  
  public boolean equals(Object collator) {
    if (this == collator) {
      return true;
    }
    if (collator == null) {
      return false;
    }
    return getClass() == collator.getClass();
  }
}

public class MainClass {
  public static void main(String[] args) {
    ArrayList<Person> authors = new ArrayList<Person>();
//			authors.add(new Person("A", "S"));
//			authors.add(new Person("J", "G"));
//			authors.add(new Person("T", "C")); 
//			authors.add(new Person("C", "S")); 
//			authors.add(new Person("P", "C"));
//			authors.add(new Person("B", "B"));
    
//    System.out.println("Original order:");
//    for (Person author : authors) {
//      System.out.println(author);
//    }
    
//    Collections.sort(authors, new ComparePersons()); // Sort using comparator
//    System.out.println("\nOrder after sorting using comparator:");
//    for (Person author : authors) {
//      System.out.println(author);
//    }
    
    Collections.sort(authors); // Sort using Comparable method
    System.out.println("\nOrder after sorting using Comparable method:");
    for (Person author : authors) {
      System.out.println(author);
    }
    
  }
}
