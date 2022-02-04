package Notes.Recursion.Easy;

public class PrintArray {

    /* All Helpers */
    private void printInOrderHelper(int[] array, int index){
        if(index == array.length)
            return;
        System.out.println(array[index++]);
        printInOrderHelper(array, index);
    }
    /* Given an array print in order */
    public void printInOrder(int[] array){
        printInOrderHelper(array, 0);
    }
    /* Given an array print in reverse order */
    /* Given an array print in pairs */
}
