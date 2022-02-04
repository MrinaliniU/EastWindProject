package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.May2020;

public class FirstBadVersion {
    boolean[] versions = {false, false, false, false, true};
    boolean isBadVersion(int version){
        return versions[version - 1];
    }
    public int firstBadVersion_better(int n) {
        if(isBadVersion(1)) return 1;
        int left = 1, right = n;
        while (left < right){
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    /*
        Runtime: 33 ms
        Memory Usage: 35.9 MB
     */
    public int firstBadVersion(int n) {
        if(isBadVersion(1)) return 1;
        int left = 1, right = n;
        while (left <= right){
            int mid = left + (right - left) / 2;
            boolean isMid = isBadVersion(mid);
            boolean isPrev = isBadVersion(mid - 1);
            if(mid - 1 > 0 && isMid && !isPrev) return mid;
            if(isBadVersion(mid)) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
    public static void main(String[] args){
        FirstBadVersion fv = new FirstBadVersion();
        System.out.println(fv.firstBadVersion_better(5));
    }
}
