package Notes.Sort;

/* */

public class QuickSort {
    public void quickSort(int[] toSort, int left, int right){
        if(left < right) {
            //int partition = partition(toSort, left, right);
            int partition = partitionCCI( toSort, left, right);
            quickSort(toSort, left, partition - 1);
            quickSort(toSort, partition, right); // This is not required if you use last element as pivot
        }
    }

    /* Code I wrote by picking the last element as the pivot */
    private int partition(int[] toSort, int left, int right){
        int pivot = toSort[right];
        int i = left - 1;
        for(int j = left; j < right; j++){
            if(toSort[j] < pivot){
                i++;
                int temp = toSort[i];
                toSort[i] = toSort[j];
                toSort[j] = temp;
            }
        }
        toSort[right] = toSort[i + 1];
        toSort[i + 1] = pivot;
        return i + 1;
    }
    /* Cracking the coding interview shows algorithm by picking the middle element as pivot */
    private int partitionCCI(int[] toSort, int left, int right){
        int pivot = toSort[left + (right - left) / 2];
        while(left <= right){
            /* Move from left to right looking for an element that is greater than pivot element */
            while(toSort[left] < pivot) left++;
            /* Move from right to left looking for an element that is less than pivot element */
            while(toSort[right] > pivot) right--;
            /* if an element greater than pivot is found on the left of pivot swap it with an
                element that was less than pivot and found to its right side
             */
            if(left <= right){
                int temp = toSort[left];
                toSort[left] = toSort[right];
                toSort[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
    public static void main(String[] args){
        int[] toSort = {23, 37, 5, 27, 16, 34, 29, 43};
        new QuickSort().quickSort(toSort, 0, toSort.length - 1);
        for(int i : toSort){
            System.out.print(i + " ");
        }
    }
}

