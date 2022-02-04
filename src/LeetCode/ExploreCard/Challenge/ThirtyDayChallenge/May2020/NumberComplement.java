package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.May2020;

public class NumberComplement {
    /*
        Runtime: 1 ms
        Memory Usage: 36.5 MB
     */
    public int findComplement(int num) {
        String binaryString = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for(char c : binaryString.toCharArray()){
            if(c == '1') sb.append("0");
            else sb.append("1");
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
