package Notes.LinkedList.MyLinkedLists;

public class EmptyListException extends Exception {
    EmptyListException(){
        System.err.println("The Linked List is Empty");
    }
}
