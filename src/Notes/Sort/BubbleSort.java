package Notes.Sort;

/*
    1. Start by comparing elements at index 0 and 1.
    2. Swap if element at 0 is greater than element at 1.
    3. Do this comparision to next to pairs i.e 1 and 2.
    4. Continue pair comparision till end of array is reached.
    5. Step 1 - 4 is put inside a while loop.
    6. This while loop returns if and only if not a single swap occurs from beginning to end
        of the array.
 */

public class BubbleSort {
    public void bubbleSort(int[] toSort){
        int length = toSort.length;
        boolean swapFlag = true;
        while(swapFlag){
            swapFlag = false;
            for(int i = 0, j = 1; j < length; i++, j++) {
                if (toSort[i] > toSort[j]) {
                    int temp = toSort[i];
                    toSort[i] = toSort[j];
                    toSort[j] = temp;
                    swapFlag = true;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] toSort = {23, 37, 5, 27, 16, 34, 29, 43};
        new BubbleSort().bubbleSort(toSort);
        for(int i : toSort){
            System.out.print(i + " ");
        }
    }
}
