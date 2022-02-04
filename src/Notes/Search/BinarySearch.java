package Notes.Search;

import java.util.Arrays;

/*
    Given an array find an element in that array.
 */
public class BinarySearch {
    private static int binarySearch(int[] array, int find){
        return binarySearch(0, array.length - 1, array, find);
    }

    // Logic for descending order array.
    private static int binarySearch(int left, int right, int[] array, int find){
        // The whole logic is within the condition that right is greater or equal to left.
        if(right >= left){
            // mid needs to be calculated every time.
            int mid = left + (right - left) / 2; // Note the formula.
            /*
                Check for three condition "==", ">" or "<".
                For each condition return a recursive call for binarySearch.
                Note no else statements.
             */
            if(find == array[mid]){
                return mid;
            }
            if(find < array[mid])
                return binarySearch(left, mid - 1, array, find);
            return binarySearch(mid + 1, right, array, find);
        }
        return -1; // Code reaches here only if element is not found.
    }
    public static void main(String[] args){
        int[] sortedArray = {1, 1, 2, 2};
        int find = 3;
        System.out.println("The index of " + find + " is " + binarySearch(sortedArray, find) +
                " as found by my algorithm.");
        System.out.println("The index of " + find +" is " + Arrays.binarySearch(sortedArray, find) +
                " as found by Arrays.binarySearch().");
    }
}
