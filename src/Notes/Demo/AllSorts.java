package Notes.Demo;

import Notes.Sort.*;

public class AllSorts {

     private static void printArray(int[] sortedArray){
         for(int i : sortedArray){
             System.out.print(i + " ");
         }
        System.out.println();
    }

    public static void main(String[] args){
         /* Data */
        int[] insertion = {23, 37, 5, 27, 16, 34, 29, 43};
        int[] selection = {23, 37, 5, 27, 16, 34, 29, 43};
        int[] bubble = {23, 37, 5, 27, 16, 34, 29, 43};
        int[] quick = {23, 37, 5, 27, 16, 34, 29, 43};
        int[] merge = {23, 37, 5, 27, 16, 34, 29, 43};
        /* Initialize all the sorting class */
        InsertionSort insertionSort = new InsertionSort();
        SelectionSort selectionSort = new SelectionSort();
        BubbleSort bubbleSort = new BubbleSort();
        QuickSort quickSort = new QuickSort();
        MergeSort mergeSort = new MergeSort();
        /* Perform Sorts */
        insertionSort.insertionSort(insertion);
        System.out.println("Array sorted by Insertion Sort Algorithm");
        printArray(insertion);
        selectionSort.selectionSort(selection);
        System.out.println("Array sorted by Selection Sort Algorithm");
        printArray(selection);
        bubbleSort.bubbleSort(bubble);
        System.out.println("Array sorted by Bubble Sort Algorithm");
        printArray(bubble);
        quickSort.quickSort(quick, 0, quick.length - 1);
        System.out.println("Array sorted by Quick Sort Algorithm");
        printArray(quick);
        mergeSort.mergeSort(merge, 0 , merge.length - 1);
        System.out.println("Array sorted by Merge Sort Algorithm");
        printArray(merge);
    }


}
