package CrackingTheCodingInterview.DataStructures.StacksAndQueues_3;
import java.util.*;
/*
	Imagine a literal stack of plates. If the stack gets too high, it might topple. Therefore, in real life,
	we would likely start a new stack when the previous stack exceeds some threshold. Implement a data structure
	SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and should create a new stack once
	the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single
	stack (that is, pop() should return the same value as it would if there were just a single stack).
FOLLOW UP
Implement a function popAt (int index) which performs a pop operation on a specific sub-stack.
*/
class SetOfStacks <T>{
    List<Stack<T>> listOfStacks;
    int individualStackCapacity;
    SetOfStacks(int individualStackCapacity){
        this.listOfStacks = new ArrayList<>();
        this.individualStackCapacity = individualStackCapacity;
    }
    void push(T item){
        if(this.listOfStacks.size() == 0 || this.listOfStacks.get(listOfStacks.size() - 1).size() == this.individualStackCapacity) listOfStacks.add(new Stack<>());
        this.listOfStacks.get(listOfStacks.size() - 1).push(item);
    }
    T pop(){ // remove stack from list if this pop makes the stack empty
        // TODO: 3/22/2020 if listOfStacks is empty
        T result = this.listOfStacks.get(listOfStacks.size() - 1).pop();
        if(this.listOfStacks.get(listOfStacks.size() - 1).size() == 0) this.listOfStacks.remove(listOfStacks.size() - 1);
        return result;
    }
    T peek(){
        // TODO: 3/22/2020 if the listOfStacks is empty
        return this.listOfStacks.get(listOfStacks.size() - 1).peek();
    }
    boolean isEmpty(){
        return listOfStacks.size() == 0 || listOfStacks.get(0).size() == 0;
    }
    T popAt(int stackIndex){ // remove stack from list if this pop makes the stack empty. StackIndex is zero based.
        // TODO: 3/22/2020 if stackIndex is out of bound
        T result = this.listOfStacks.get(stackIndex).pop();
        if(this.listOfStacks.get(stackIndex).size() == 0) this.listOfStacks.remove(stackIndex);
        return result;
    }
}

public class StackOfPlates_3 {
    public static void main(String[] args){
        SetOfStacks<Integer> stack = new SetOfStacks<>(5);
        stack.push(18);
        stack.push(5);
        stack.push(9);
        stack.push(10);
        stack.push(8);
        stack.push(13);
        stack.push(5);
        stack.push(2);
        stack.push(12);
        stack.push(2);
        stack.push(14);
        stack.push(19);
        stack.push(100);
        stack.popAt(1);
        stack.push(55);
        stack.pop();
        stack.push(13);
        stack.push(18);
        stack.push(6);
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        stack.push(10);
    }
}
