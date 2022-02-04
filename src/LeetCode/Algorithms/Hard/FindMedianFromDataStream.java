package LeetCode.Algorithms.Hard;
import java.util.*;

public class FindMedianFromDataStream {
    /*
        Runtime: 56 ms, faster than 27.50%
        Memory Usage: 50.4 MB, less than 100.00%
     */
    List<Integer> data;
    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
        this.data = new ArrayList<>();
    }

    public void addNum(int num) {
        int insertion_index = binarySearchIndex(num);
        data.add(insertion_index, num);
    }
    int binarySearchIndex(int num){
        int left = 0, right = data.size() - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(data.get(mid).equals(num)) return mid;
            if(data.get(mid) < num) left = mid + 1;
            if(data.get(mid) > num) right = mid - 1;
        }
        return left;
    }
    public double findMedian() {
        int mid = data.size() / 2;
       return  (data.size() % 2 == 0) ? (data.get(mid) + data.get(mid - 1)) / 2.0 : data.get(mid);
    }

    public static void main(String[] args){
        FindMedianFromDataStream f = new FindMedianFromDataStream();
        f.addNum(1);
        f.addNum(2);
        System.out.print(f.findMedian());
    }
}
