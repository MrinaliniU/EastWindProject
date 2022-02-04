package LeetCode.ExploreCard.Interview.Amazon.SortingAndSearching;

import java.util.*;

public class KClosestPointsOrigin {
    /*
        Runtime: 43 ms
        Memory Usage: 47.4 MB
     */
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingDouble(this::getDistance));
        int[][] result = new int[K][];
        for(int i = 0; i < K; i++) result[i] = points[i];
        return result;
    }

    public double getDistance(int[] point){
        return Math.sqrt(Math.pow(-point[0], 2) + Math.pow(-point[1], 2));
    }

    public static void main(String[] args){

    }
}
