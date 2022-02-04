package CrackingTheCodingInterview.DataStructures.StacksAndQueues_3;
/*
   How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element?
   Push, pop and min should all operate in O(1) time.
 */
import java.util.*;
class MinStack <T extends Comparable<T>>{
    private Stack<T> myStack;
    private Stack<T> minStack;
    MinStack(){
        this.myStack = new Stack<>();
        this.minStack = new Stack<>();
    }
    void push(T item){
        if(myStack.isEmpty()) minStack.push(item);
        else if(item.compareTo(minStack.peek()) <= 0) minStack.push(item);
        myStack.push(item);
    }
    T pop(){
        if(myStack.peek().compareTo(minStack.peek()) == 0) minStack.pop();
        return myStack.pop();
    }
    T peek(){
        return myStack.peek();
    }
    T min(){
        return minStack.peek();
    }
}

public class StackMin_2 {
    public static void main(String[] args){
      MinStack<Integer> minStack = new MinStack<>();
      minStack.push(18);
      minStack.push(50);
      minStack.push(9);
      minStack.push(10);
      minStack.push(13);
      minStack.push(15);
      minStack.push(12);
      minStack.push(12);
      minStack.push(20);
      minStack.push(14);
      minStack.push(19);
      minStack.push(100);
      minStack.push(8);
      minStack.push(55);
      minStack.push(13);
      minStack.push(18);
      minStack.push(6);
      System.out.println("Min Item -: " + minStack.min());
      minStack.pop();
      System.out.println("Min Item -: " + minStack.min());
      minStack.pop();
      minStack.pop();
      minStack.pop();
      System.out.println("Min Item -: " + minStack.min());
      minStack.pop();
      System.out.println("Min Item -: " + minStack.min());
    }
}
