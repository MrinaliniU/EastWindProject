package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

public class PerformStringShifts {
/*
    Runtime: 0 ms
    Memory Usage: 37.6 MB
 */
    public String stringShift(String s, int[][] shift) {
        int left = 0, right = 0;
        String _s = s + s;
        for(int[] i : shift) if(i[0] == 1) right += i[1]; else left += i[1];
        if(left > right){
            left = (left - right) % s.length();
            right = 0;
        }else if(right > left){
            right = (right - left) % s.length();
            left = 0;
        }else {
            right = 0;
            left = 0;
        }
        if(left > right) return _s.substring(left, s.length() + left);
        else if (right > left) return _s.substring(s.length() - right, 2 * s.length() - right);
        else return s;
    }
    public static void main(String[] args){
        PerformStringShifts pf = new PerformStringShifts();
        String s = "abcdefg";
        int[][] shift = {{1, 1}, {1, 1}, {0, 2}, {1, 3}};
        System.out.println(pf.stringShift(s, shift));
    }
}
