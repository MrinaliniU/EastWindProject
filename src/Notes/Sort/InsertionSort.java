package Notes.Sort;


public class InsertionSort {
    /*
        NOTE: Insertion sort inserts each element in it's correct location by shifting elements greater than current
        element, where as Selection sort swaps elements after comparing them.
     */
    public void insertionSort(int[] toSort){
        int length = toSort.length;
        for(int i = 1; i < length; i++){
            int j = i - 1;
            int temp = toSort[i];
            while(j >= 0 && toSort[j] > temp){
                toSort[j + 1] = toSort[j];
                j--;
            }
            toSort[j + 1] = temp;
        }
    }

    public static void main(String[] args){
        int[] toSort = {5, 23, 27, 37, 16, 34, 29, 43};
        new InsertionSort().insertionSort(toSort);
        for(int i : toSort){
            System.out.print(i + " ");
        }
    }
}
