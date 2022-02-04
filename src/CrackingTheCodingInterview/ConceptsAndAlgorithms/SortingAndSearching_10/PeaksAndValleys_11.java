package CrackingTheCodingInterview.ConceptsAndAlgorithms.SortingAndSearching_10;

import java.util.*;

public class PeaksAndValleys_11 {
    ArrayList<Integer> peaks = new ArrayList<>();
    ArrayList<Integer> valleys = new ArrayList<>();

    /* Solution given in CCI. */
    public void sortValleyPeak(int[] array){
        for(int i = 1; i < array.length; i += 2){
            int biggestIndex = maxIndex(array, i - 1, i, i + 1);
            if(i != biggestIndex) swap(array, i, biggestIndex);
        }
    }
    int maxIndex(int[] array, int a, int b, int c){
        int len = array.length;
        int aValue = a >= 0 && a < len ? array[a] : Integer.MIN_VALUE;
        int bValue = b >= 0 && b < len ? array[b] : Integer.MIN_VALUE;
        int cValue = c >= 0 && c < len ? array[c] : Integer.MIN_VALUE;

        int max = Math.max(aValue, Math.max(bValue, cValue));
        return aValue == max ? a : bValue == max ? b : c;
    }
    void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
    /*
    My brute force approach in solving the problem. The worst case scenario for this is O(n^2).
    If the input array is sorted.
    */
    public ArrayList<Integer> sortByPeaksAndValleys(ArrayList<Integer> toSort){
        toSort = findPeaksAndValleys(toSort);
        while (!toSort.isEmpty()){
            toSort = findPeaksAndValleys(toSort);
        }
        return sort(peaks, valleys);
    }
    public ArrayList<Integer> sort(ArrayList<Integer> peaks, ArrayList<Integer> valleys){
        ArrayList<Integer> sorted = new ArrayList<>();
        int i = 0; int j = 0;
        for(; i < peaks.size() && j < valleys.size(); i++, j++){
            sorted.add(peaks.get(i));
            sorted.add(valleys.get(j));
        }
        while (i < peaks.size()){
            sorted.add(peaks.get(i));
            i++;
        }
        while (j < valleys.size()){
            sorted.add(peaks.get(j));
            j++;
        }
        return sorted;
    }
    public ArrayList<Integer> findPeaksAndValleys(ArrayList<Integer> array){
        ArrayList<Integer> nothingList = new ArrayList<>();
        int leftPointer = -1;
        for(int i = 0; i < array.size(); i++){
            int rightPointer = i + 1;
            if(leftPointer == -1 || rightPointer >= array.size()) {
                int pointer = leftPointer == -1 ? rightPointer : leftPointer;
                if(array.get(i) >= array.get(pointer)) peaks.add(array.get(i));
                else valleys.add(array.get(i));
            }else{
                if(array.get(i) >= array.get(leftPointer) && array.get(i) >= array.get(rightPointer)) peaks.add(array.get(i));
                else if(array.get(i) <= array.get(leftPointer) && array.get(i) <= array.get(rightPointer)) valleys.add(array.get(i));
                else nothingList.add(array.get(i));
            }
            leftPointer++;
        }
        return nothingList;
    }
    /* One way to do this is to sort the array and swap two elements at a time in pairs
    * 0 1 2 3 4 5 will be "1 0 3 2 5 4" and we have a peak-valley-peak pattern in our array. This logic works
    * for an odd length array as well 0 1 2 3 4 becomes 1 0 3 2 4
    * The run-time is equal to n log n as in java Arrays.sort takes n log n time.*/
    public void sortAndArrange(int[] toSort){
        Arrays.sort(toSort);
        for(int i = 0, j = 1; j < toSort.length; i += 2, j += 2){
            int temp = toSort[i];
            toSort[i] = toSort[j];
            toSort[j] = temp;
        }
    }
    /* This can be solved in O(n) time */

    public static void main(String[] args){
        PeaksAndValleys_11 pv11 = new PeaksAndValleys_11();
        //ArrayList<Integer> toSort = new ArrayList<>(Arrays.asList(5, 3, 1, 2, 3));
        //ArrayList<Integer> toSort = new ArrayList<>(Arrays.asList(5, 8, 6, 2, 3, 4, 6));
        //ArrayList<Integer> toSort = new ArrayList<>(Arrays.asList(9, 1, 0, 4, 8, 7));
        ArrayList<Integer> toSort1 = new ArrayList<>(Arrays.asList(7, 1, 11, 15, 4, 0, 8, 14, 7));
        int[] toSort2 = {7, 1, 11, 15, 4, 0, 8, 14, 7};
        int[] toSort3 = {7, 1, 11, 15, 4, 0, 8, 14, 7};
        ArrayList<Integer> mySolution = pv11.sortByPeaksAndValleys(toSort1);
        for(int i : mySolution){
            System.out.print(i + " ");
        }
        System.out.println();
        pv11.sortValleyPeak(toSort2);
        for(int i : toSort2)
            System.out.print(i + " ");
        System.out.println();
        pv11.sortAndArrange(toSort3);
        for(int i : toSort3)
            System.out.print(i + " ");
        System.out.println();
    }
}

