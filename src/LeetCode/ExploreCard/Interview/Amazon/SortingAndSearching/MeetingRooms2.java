package LeetCode.ExploreCard.Interview.Amazon.SortingAndSearching;

import java.util.*;

public class MeetingRooms2 {
    /*
        Runtime: 7 ms
        Memory Usage: 38.9 MB
     */

    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> finishTime = new PriorityQueue<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for(int[] i : intervals){
            if(!finishTime.isEmpty() && finishTime.peek() <= i[0]) finishTime.poll();
            finishTime.offer(i[1]);
        }
        return finishTime.size();
    }
    /*
        Runtime: 2 ms 96.13 %
        Memory Usage: 39.1 MB
     */
    public int chronologicalOrdering(int[][] intervals){
        int len = intervals.length;
        int rooms = 0;
        int[] startTime = new int[len];
        int[] endTime = new int[len];
        for(int i = 0; i < len; i++){
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }
        Arrays.sort(endTime);
        Arrays.sort(startTime);
        for(int startPointer = 0, endPointer = 0; startPointer < len; ){
            if(startTime[startPointer] < endTime[endPointer]) rooms++;
            else endPointer++;
            startPointer++;
        }
        return rooms;
    }
    public static void main(String[] args){
        MeetingRooms2 m2 = new MeetingRooms2();
        int[][] intervals = {{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}};
        System.out.print(m2.chronologicalOrdering(intervals));
    }
}
