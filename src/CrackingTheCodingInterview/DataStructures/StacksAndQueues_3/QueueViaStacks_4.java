package CrackingTheCodingInterview.DataStructures.StacksAndQueues_3;

import java.util.*;
/*
    Implement a MyQueue class which implements a queue using two stacks.
 */
class MyQueue <T extends Comparable<T>>{
    private Stack<T> stack;
    private Stack<T> reverseStack;
    MyQueue(){
        stack = new Stack<>();
        reverseStack = new Stack<>();
    }
    void push(T item){
        stack.push(item);
    }
    T peek(){
        while(!stack.isEmpty()){
            reverseStack.push(stack.pop());
        }
        T result = reverseStack.peek();
        while(!reverseStack.isEmpty()){
            stack.push(reverseStack.pop());
        }
        return result;
    }
    T pop(){
        while(!stack.isEmpty()){
            reverseStack.push(stack.pop());
        }
        T result = reverseStack.pop();
        while(!reverseStack.isEmpty()){
            stack.push(reverseStack.pop());
        }
        return result;
    }
    boolean isEmpty(){
        return stack.isEmpty();
    }
}

public class QueueViaStacks_4 {

    public static void main(String[] args){
        MyQueue<Integer> queue = new MyQueue<>();
        queue.push(10);
        queue.push(3);
        queue.push(8);
        queue.push(12);
        queue.push(9);
        queue.push(99);
        queue.push(14);
        queue.push(13);
        queue.push(12);
        queue.push(16);
        queue.push(9);
        System.out.print(queue.pop() + " ");
        System.out.print(queue.pop() + " ");
        System.out.print(queue.pop() + " ");
        System.out.println();
        System.out.println("peek" + "-" + queue.peek() + " ");
        System.out.print(queue.pop() + " ");
        System.out.print(queue.pop() + " ");
        System.out.print(queue.pop() + " ");
        System.out.println();
        System.out.println("peek" + "-" + queue.peek() + " ");
        System.out.print(queue.pop() + " ");
        System.out.print(queue.pop() + " ");
        System.out.print(queue.pop() + " ");
    }
}
