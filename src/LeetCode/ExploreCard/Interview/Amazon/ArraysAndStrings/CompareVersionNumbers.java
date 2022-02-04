package LeetCode.ExploreCard.Interview.Amazon.ArraysAndStrings;
/*
    1. Made an assumption while solving this problem, that the versioning length can go
    up-to 4 levels. That was not true, look at the test case.
    2. Tried to return v1.compareTo(v2) that is not right because 1.1 compared to
        1.10 will say the versions are equal which is wrong. V2 is larger.
    3.  Simply returning v1.compareTo(v2) is also wrong, the result could be any -ve number like -2
        to indicate v1 is smaller, but we need to just send -1, 0, or 1.
 */
public class CompareVersionNumbers {
    /*
        Runtime: 1 ms
        Memory Usage: 37.4 MB
     */
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int n = Math.max(s1.length, s2.length); // for point 1
        int[] v1 = new int[n]; // for point 1
        int[] v2 = new int[n];
        for(int i = 0; i < s1.length; i++) v1[i] = Integer.parseInt(s1[i]);
        for(int i = 0; i < s2.length; i++) v2[i] = Integer.parseInt(s2[i]);
        for(int i = 0; i < n; i++){ // for point 2 above
            if(v1[i] < v2[i]) return -1;
            else if(v1[i] > v2[i]) return 1;
        }
        return 0;
    }

    public static void main(String[] args){
        CompareVersionNumbers cv = new CompareVersionNumbers();
        // String version1 = "0.1", version2 = "1.1"; // -1
        // String version1 = "1.0.1", version2 = "1"; // 1
        // String version1 = "7.5.2.4", version2 = "7.5.3"; // -1
        // String version1 = "1.01", version2 = "1.001"; // 0
        // String version1 = "1.0", version2 = "1.0.0"; // 0
        // String version1 = "1.0", version2 = "1.2";
        // String version1 = "1.2", version2 = "1.10";
        String version1 = "0.9.9.9.9.9.9.9.9.9.9.9.9", version2 = "1.0";
        System.out.println("Compare " + cv.compareVersion(version1, version2));
    }
}