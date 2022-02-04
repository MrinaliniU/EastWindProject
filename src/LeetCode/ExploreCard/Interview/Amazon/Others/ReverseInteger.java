package LeetCode.ExploreCard.Interview.Amazon.Others;

/*
    Runtime: 1 ms 100% java
    Memory Usage: 36.7 MB
 */
public class ReverseInteger {
    public int reverse(int x) {
        double sol = 0;
        boolean isNeg = x < 0;
        while(x != 0){
            sol = sol * 10 + Math.abs(x % 10);
            if(sol > Integer.MAX_VALUE) return 0;
            x /= 10;
        }
        return isNeg ? (int) -sol : (int) sol;
    }

    public static void main(String[] args){
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(Integer.MIN_VALUE));
    }
}
