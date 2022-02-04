package Notes.Search;

import java.util.ArrayList;
import java.util.List;
/*
    Given a Sorted Array and an integer, insert the int in the array
    so that the resulting array is still sorted. Return the index.
 */

public class BinarySearchInsert {

/*    private static int binarySearchInsert(int left, int right, int[] array, int insert){
        if(right >= left){
            int mid = left + (right - left) / 2;

            if(insert == array[mid]){
                return mid;
            }
            if(insert > array[mid]){
                return binarySearchInsert(left, mid - 1, array, insert);
            }
            return binarySearchInsert(mid + 1, right, array, insert);
        }
        return left; // This makes all the difference. Gives the index where to insert the element.
    }*/

    public void insert(List<Integer> array, int num){
        int indexToInsert = binarySearchInsert(array, num);
        array.add(indexToInsert, num);
    }
    private int binarySearchInsert(List<Integer> array, int num){
        int left = 0, right = array.size() - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(array.get(mid) == num) return mid;
            if(array.get(mid) > num) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
    public static void main(String[] args){
        List<Integer> scores = new ArrayList<>();
        scores.add(50);
        scores.add(60);
        scores.add(70);
        scores.add(80);
        scores.add(90);
        scores.add(100);
        BinarySearchInsert bi = new BinarySearchInsert();
        bi.insert(scores, 81);
        System.out.print(scores);
    }
}
