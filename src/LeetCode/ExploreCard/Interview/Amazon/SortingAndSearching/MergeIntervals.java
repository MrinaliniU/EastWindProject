package LeetCode.ExploreCard.Interview.Amazon.SortingAndSearching;

import java.util.*;

public class MergeIntervals {
    public int[][] merge(int[][] intervals){
        if(intervals.length == 0) return new int[0][];
        ArrayList<int[]> merged_intervals = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for(int[] i : intervals){
            int size = merged_intervals.size();
            if(size == 0 || merged_intervals.get(size - 1)[1] < i[0])
                merged_intervals.add(i);
            else merged_intervals.get(size - 1)[1] = Math.max(merged_intervals.get(size - 1)[1], i[1]);
        }
        return merged_intervals.toArray(new int[merged_intervals.size()][]);
    }

}
