package Notes.Sort;

/*
    The idea of Selection Sort.
    1. Start from index 0.
    2. Find the smallest element in the array by comparing all other elements to index 0.
    3. Swap the smallest element with index 0.
    4. Move to index 1 and repeat.
    5. Do this till end of array is reached.
 */

public class SelectionSort {

    public void selectionSort(int[] toSort){
        int length = toSort.length;
        for(int i = 0; i < length; i++){
            int min = i;
            for(int j = i + 1; j < length; j++){
                if(toSort[j] < toSort[min]){
                    min = j;
                }
            }
            int temp = toSort[i];
            toSort[i] = toSort[min];
            toSort[min] = temp;
        }
    }
    public static void main(String[] args){
        int[] toSort = {23, 37, 5, 27, 16, 34, 29, 43};
        new SelectionSort().selectionSort(toSort);
        for (int value : toSort) {
            System.out.print(value + " ");
        }
    }
}
