package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.May2020;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int countJewel = 0;
        for(int i = 0; i < S.length(); i++){
            if(J.indexOf(S.charAt(i)) >= 0) countJewel++;
        }
        return countJewel;
    }
}
