package LeetCode.Algorithms.Medium;
import java.util.*;
public class MergeIntervals {
    /*
        Runtime: 8 ms, faster than 20.13%
        Memory Usage: 42.2 MB, less than 49.28%
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        merged.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] _interval = merged.getLast();
            if(_interval[1] >= intervals[i][0])
                _interval[1] = Math.max(intervals[i][1], _interval[1]);
            else merged.add(intervals[i]);
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args){
        MergeIntervals mi = new MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        // int[][] intervals = {{1, 4}, {4, 5}};
        // int[][] intervals = {{1, 4}, {0, 4}};
        // int[][] intervals = {{1, 4}, {2, 3}};
        // int[][] intervals = {{1,4},{0,2},{3,5}};
        int[][] result = mi.merge(intervals);
        for(int[] i : result) System.out.print(Arrays.toString(i) + " ");
    }
}
