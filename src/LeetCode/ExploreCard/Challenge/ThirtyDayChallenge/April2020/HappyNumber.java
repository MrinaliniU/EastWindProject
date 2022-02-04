package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;

import java.util.HashSet;

public class HappyNumber {
    public boolean isHappy(int n){
        HashSet<Integer> set = new HashSet<>();
        while(n != 1){
            if(!set.add(n)) return false;
            n = findSquareSum(n);
        }
        return true;
    }
    public int findSquareSum(int n){
        int sol = 0;
        while(n != 0){
            sol += Math.pow((n % 10), 2);
            n /= 10;
        }
        return sol;
    }
    public static void main(String[] args){
        HappyNumber hn = new HappyNumber();
        int number = 19001;
        boolean isHappyNumber = hn.isHappy(number);
        System.out.println("The number is happy " + isHappyNumber);
    }
}
