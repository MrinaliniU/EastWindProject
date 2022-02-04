package LeetCode.Algorithms.Medium;

import java.util.Arrays;
import java.util.Comparator;

class Points{
    int[] point;
    double distance;
    Points(int[] point){
        this.point = point;
        distance = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
    double getDistance(){
        return this.distance;
    }
}
public class KClosestPointsToOrigin {
    /*
        Runtime: 29 ms, faster than 47.90%
        Memory Usage: 47.7 MB, less than 100.00%
     */
    public int[][] kClosest(int[][] points, int K) {
        Points[] origin_distance = new Points[points.length];
        for(int i = 0; i < points.length; i++){
            origin_distance[i] = new Points(points[i]);
        }
        Arrays.sort(origin_distance, Comparator.comparingDouble(Points::getDistance));
        int[][] result = new int[K][];
        for(int i = 0; i < result.length; i++){
            result[i] = origin_distance[i].point;
        }
        return result;
    }
}
