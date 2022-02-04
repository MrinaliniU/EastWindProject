package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

import java.util.Stack;

/*
    Problem No. 155.
    Runtime: 5 ms, faster than 73.21%
    Memory Usage: 41.4 MB, less than 10.15%
 */
public class MinStack {
    Stack<Integer> myStack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        this.myStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        if(this.myStack.isEmpty() || x <= minStack.peek())
            this.minStack.add(x);
        this.myStack.add(x);
    }

    public void pop() {
        if(this.myStack.pop().equals(this.minStack.peek())) this.minStack.pop();
    }

    public int top() {
        return this.myStack.peek();
    }

    public int getMin() {
        return this.minStack.peek();
    }

    public static void main(String[] args){
        /* Test Case 1 */
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Minimum element test case 1 " + minStack.getMin());
        minStack.pop();
        System.out.println("Top element test case 1 " + minStack.top());
        System.out.println("Minimum element test case 1 " + minStack.getMin());
        /* Test Case 2 */
        MinStack minStack2 = new MinStack();
        minStack2.push(10);
        minStack2.push(-2);
        minStack2.push(-2);
        minStack2.push(3);
        System.out.println("Minimum element test case 2 " + minStack2.getMin());
        minStack2.pop();
        minStack2.pop();
        System.out.println("Minimum element test case 2 " + minStack2.getMin());
        /* Test Case 3 */
        /* Test Case 4 */
    }
}
