package CrackingTheCodingInterview.DataStructures.StacksAndQueues_3;
/*
    Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary
    stack, but you may not copy the elements into any other data structure (such as an array). The stack supports the
    following operations : push, pop, peek and isEmpty.
 */
import java.util.*;
public class SortStack_5 <T extends Comparable<T>> {
    private Stack<T> myStack;
    private Stack<T> tempStack;
    SortStack_5(){
        myStack = new Stack<>();
        tempStack = new Stack<>();
    }
    void push(T item){
        if(myStack.isEmpty()) myStack.push(item);
        else{
            while(!myStack.isEmpty() && myStack.peek().compareTo(item) < 0){
                tempStack.push(myStack.pop());
            }
            myStack.push(item);
            while(!tempStack.isEmpty()){
                myStack.push(tempStack.pop());
            }
        }
    }
    T pop(){
        return myStack.pop();
    }
    T peek(){
        return myStack.peek();
    }
    boolean isEmpty(){
        return myStack.isEmpty();
    }

    public static void main(String[] args){
        SortStack_5<Integer> ss5 = new SortStack_5<>();
        ss5.push(10);
        ss5.push(3);
        ss5.push(8);
        ss5.push(12);
        ss5.push(9);
        ss5.push(99);
        ss5.push(14);
        ss5.push(13);
        ss5.push(12);
        ss5.push(16);
        ss5.push(9);
        while(!ss5.isEmpty()){
            System.out.print(ss5.pop() + " ");
        }
    }
}
