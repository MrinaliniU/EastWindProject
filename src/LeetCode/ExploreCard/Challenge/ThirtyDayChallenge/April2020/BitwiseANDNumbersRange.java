package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

public class BitwiseANDNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) {
            n = n & (n - 1);
        }
        return m & n;
    }
}
