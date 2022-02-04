package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

import java.util.*;
import LeetCode.Util.BinaryMatrix;

public class LeftmostColumnWithAtLeastAOne {
    /*
        Runtime: 0 ms
        Memory Usage: 39.9 MB
     */
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int _row = dimension.get(0), _col = dimension.get(1);
        int left = 0, right = _col - 1, mid;
        int result_col = Integer.MAX_VALUE;
        while (left <= right){
            mid = left + (right - left) / 2;
            boolean hasOne = hasOne(mid, _row, binaryMatrix);
            if(hasOne) {
                result_col = Math.min(result_col, mid);
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return result_col == Integer.MAX_VALUE ? - 1 : result_col;
    }

    public boolean hasOne(int col, int row_size, BinaryMatrix binaryMatrix){
        for(int i = 0; i < row_size; i++){
            if(binaryMatrix.get(i, col) == 1) return true; // r times call to get(x, y)
        }
        return false;
    }

    public static void main(String[] args){
        LeftmostColumnWithAtLeastAOne l = new LeftmostColumnWithAtLeastAOne();
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(0, 0)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0)));
        /*matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 1, 1, 1)));*/
        int i = l.leftMostColumnWithOne(new BinaryMatrix(matrix));
        System.out.println(i);
    }
}
