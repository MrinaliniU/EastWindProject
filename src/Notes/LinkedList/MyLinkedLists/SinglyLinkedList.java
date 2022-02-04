package Notes.LinkedList.MyLinkedLists;

import java.util.List;

public class SinglyLinkedList {
    private int length = 0;
    private Node head;
    private Node tail;

    public void add(int value){
        Node newNode = new Node(value);
        if(this.head == null)
            addToEmptyList(value);
        else{
            this.tail.next = newNode;
            this.tail = newNode;
            this.length++;
        }
    }
    public void add(int index, int value) throws InvalidIndexException{
        if(index == 0)
            addFirst(value);
        else if (0 < index && index <= length){
            Node currentNode = this.head;
            Node newNode = new Node(value);
            for(int i = 1; i < index; i++){
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            this.length++;
        }else{
            throw new InvalidIndexException();
        }
    }
    public void addAll(List<Integer> list){
        for(int i : list){
            this.add(i);
        }
    }
    public void addFirst(int value){
        Node newNode = new Node(value);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }
    private void addToEmptyList(int value){
        this.head = new Node(value);
        this.tail = this.head;
        this.length++;
    }

    public int size(){
        return this.length;
    }
    public int get(int index) throws EmptyListException, InvalidIndexException {
        if(index == 0)
            return getFirst();
        else if (0 < index && index < this.length){
            Node currNode = this.head;
            for(int i = 0; i < index; i++){
                currNode = currNode.next;
            }
            return currNode.value;
        }
        else{
            throw new InvalidIndexException();
        }
    }
    public int getFirst() throws EmptyListException {
        if(this.head != null)
            return this.head.value;
        else throw new EmptyListException();
    }
    public int getLast() throws EmptyListException{
        if(this.head != null)
            return this.tail.value;
        else throw new EmptyListException();
    }
    public void remove(int index) throws InvalidIndexException {
        if(index == 0)
            removeFirst();
        else if(index == this.length - 1)
            removeLast();
        else if(0 < index && index < this.length){
            Node currentNode = this.head;
            for(int i = 1; i < index; i++){
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
            this.length--;
        }
        else{
            throw new InvalidIndexException();
        }
    }
    public void removeFirst(){
        this.head = this.head.next;
        this.length--;
    }
    public void removeLast(){
        Node currentNode = this.head;
        for(int i = 0; i < this.length - 2; i++){
            currentNode = currentNode.next;
        }
        currentNode.next = null;
        this.tail = currentNode;
        this.length--;
    }
    public boolean contains(int value) throws EmptyListException{
        if(this.head == null)
            throw new EmptyListException();
        Node currentNode = this.head;
        if(currentNode.value == value)
            return true;
        for(int i = 1; i < this.size(); i++){
            currentNode = currentNode.next;
            if(currentNode.value == value)
                return true;
        }
        return false;
    }
    static class Node {
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }

}
