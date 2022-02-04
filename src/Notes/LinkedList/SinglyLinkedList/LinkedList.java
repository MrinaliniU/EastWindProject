package Notes.LinkedList.SinglyLinkedList;

import Notes.DataStructures.ListNode;

public class LinkedList<T> {
    public int length = 0;
    public ListNode<T> head;
    public ListNode<T> tail;

    public void append(T value){
        ListNode<T> newNode = new ListNode<T>(value);
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
    }
    public void insert(T value, int index){
        ListNode<T> newNode = new ListNode<T>(value);
        if(this.head == null){
            if(index == 0){
                this.head = newNode;
                this.tail = newNode;
                this.length++;
            }
        }else{
            if(index == 0){
                newNode.next = this.head;
                this.head = newNode;
                this.length++;
            }
            else if(index == this.length){
                this.tail.next = newNode;
                this.tail = newNode;
                this.length++;
            }else if(0 < index && index < this.length){
                ListNode<T> currentNode = this.head;
                for(int i = 0; i < index; i++){
                    currentNode = currentNode.next;
                }
                newNode.next = currentNode.next;
                currentNode.next = newNode;
                this.length++;
            }
        }
    }
    public void delete(int index){
        if(this.head != null){
            if(index == 0){
                if(this.length == 1)
                    this.tail = null;
                this.head = this.head.next;
                this.length--;
            }else if (0 < index && index < this.length){
                ListNode<T> currentNode = this.head;
                for(int i = 1; i < index; i++){
                    currentNode = currentNode.next;
                }
                currentNode.next = currentNode.next.next;
                this.length--;
            }
        }
    }
    public boolean contains(T value){
        if(this.head != null){
            ListNode<T> currentNode = this.head;
            if(currentNode.value.equals(value))
                return true;
            for(int i = 1; i < length; i++){
                currentNode = currentNode.next;
                if(currentNode.value.equals(value))
                    return true;
            }
        }
        return false;
    }
}
