package Notes.Sort;

public class MergeSort {

    public void mergeSort(int[] toSort, int start, int end){
            if(start < end){
                int mid = (end + start) / 2;
                mergeSort(toSort, start, mid);
                mergeSort(toSort, mid + 1, end);
                merge(toSort, start, mid, end);
            }
    }

   private void merge(int[] toSort, int start, int mid, int end){
        int[] tempToSort = new int[(end - start) + 1];
        int i = start; // Pointer to iterate from start to mid. (Left half)
        int j = mid + 1; // Pointer to iterate from mid + 1 to end. (Right Half)
        int k = 0; // Pointer to fill up the tempToSort array.
       /* Fill up tempToSort in such a way that if smallest number gets into tempToSort[k] first*/
        while(i <= mid && j <= end){
            if(toSort[i] < toSort[j]){
                tempToSort[k++] = toSort[i++];
            }else{
                tempToSort[k++] = toSort[j++];
            }
        }
        /* The following two while loops handle any remaining elements in the
        left and right half of the array.
         */
        while (i <= mid){
            tempToSort[k++] = toSort[i++];
        }
        while (j <= end){
            tempToSort[k++] = toSort[j++];
        }
        /* Fill up the sorted tempToSort into the original array to be sorted */
        for(int m = 0; m < tempToSort.length; m++){
            toSort[start + m] = tempToSort[m];
        }
    }

    /* A more space efficient solution. */

    public void mergeSort(int[] toSort){
        /* This is where you are saving space. Instead of creating tempToSort multiple times inside
        merge method, create it once here.
        */
        int[] tempToSort = new int[toSort.length];
        mergeSort(toSort, tempToSort, 0, toSort.length - 1);
    }
    private void mergeSort(int[] toSort, int[] tempToSort, int start, int end){
        if(start < end){
            int middle = start + (end - start) / 2;
            mergeSort(toSort, tempToSort, start, middle);
            mergeSort(toSort, tempToSort, middle + 1, end);
            merge(toSort, tempToSort, start, middle, end);
        }
    }

    private void merge(int[] toSort, int[] tempToSort, int start, int middle, int end){
        /*
            Temp array is re-used instead of creating empty arrays. Here copy all elements in toSort arrays
            to tempToSort. Comparision is done on tempToSort and copied to toSort in a sorted fashion.
         */
        for(int i = start; i <= end; i++){
            tempToSort[i] = toSort[i];
        }
        int i = start;
        int j = middle + 1;
        int k = start;
        while(i <= middle && j <= end){
            if(tempToSort[i] <= tempToSort[j]){
                toSort[k++] = tempToSort[i++];
            }else{
                toSort[k++] = tempToSort[j++];
            }
        }
        /* Copy left half of tempToSort to toSort */
        while(i <= middle){
            toSort[k++] = tempToSort[i++];
        }
    }
    public static void main(String[] args){
        int[] toSort = {23, 37, 5, 27, 16, 34, 29, 43};
        //new MergeSort().mergeSort(toSort, 0, toSort.length - 1);
        new MergeSort().mergeSort(toSort);
        for(int i : toSort){
            System.out.print(i + " ");
        }
    }

}