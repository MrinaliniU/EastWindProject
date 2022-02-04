package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.May2020;

public class ValidPerfectSquare {
    /*
        Binary search Method
        say x is the square root of num
        for any num - x will be greater than 1 and less than num / 2;
        so within this range we can do a binary search for an integer
        and if that integer I results in I * I == num then it is a
        perfect square.
     */
    /*
        Runtime: 0 ms, faster than 100.00%
        Memory Usage: 36.6 MB, less than 6.12%
     */
    public boolean isPerfectSquare(int num) {
        if(num < 2) return false; // no perfect squares below 2
        long left = 2, right = num / 2; // has to be long
        while (left <= right){
            long mid = left + (right - left) / 2;
            if(mid * mid == num) return true;
            if(mid * mid > num) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
    public static void main(String[] args){
        ValidPerfectSquare vps = new ValidPerfectSquare();
        System.out.print(vps.isPerfectSquare(4));
    }
}
