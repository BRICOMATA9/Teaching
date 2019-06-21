/**
 * A Stack implementation.
 * This uses the java.util.LinkedList class in the Java
 * Collections package.
 */

import java.util.*;

public class CompositionStack<T>
{
        private LinkedList<T> theStack;
    
        /**
         * create an empty stack
         */
 public CompositionStack() {
  theStack = new LinkedList<T>();
 }
    
        /** 
         * push an object onto the stack
         * @param Object o - the object to be pushed
         */
 public boolean push(T o) {
  theStack.addFirst(o);

  return true;
 }

        /**
         * peek at the item on top of the stack
         * @throws StackEmptyException
         */
 public T peek() {
  return theStack.getFirst();
 }

        /**
         * pop the item off the top of the stack
         * @return Object - the item at the top of the stack
         */
 public T pop() {
  return theStack.removeFirst();
 }
        
        /**
         * Determines if the stack is empty or not.
         * @return boolean - true if the stack is empty, false otherwise
         */
 public boolean empty() {
  if (theStack.size() == 0)
   return true;
  else
   return false;
 }
}

