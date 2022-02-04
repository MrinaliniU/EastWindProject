package LeetCode.ExploreCard.Interview.Amazon.ArraysAndStrings;
/*
    Solving this long back I can tell that this problem has lots of edge cases to be taken care of.
    These are the exact steps to get a valid result:
        - Initialize the result var as a long so that as you build the result the minute it exceeds the int limits
            you can then decide if you need to RETURN a MIN_VALUE or MAX_VALUE based on sign immediately.
        - IMPORTANT if(result > Integer.MAX_VALUE) if(sign == 1) return Integer.MIN_VALUE; else return Integer.MAX_VALUE;
        - Keep a var for sign whose state tell you if it is going to be a +ve or -ve number.
 */
/*
    Runtime: 2 ms beats 78.58%
    Memory Usage: 39.4 MB
 */
public class StringToInteger_atoi {
    public int myAtoi(String str) {
        // Trim.
        str = str.trim();
        if (str.length() == 0) return 0;
        byte sign = 0; // 0 for positive 1 for -ve
        long result = 0;
        int index = 0;
        // work on assigning a value to the sign variable
        sign = str.charAt(index) == '-' ? 1 : str.charAt(index) == '+' ? (byte) index++ : 0;
        // remember if sign is assigned to 1 then index is not yet incremented do that
        if(sign == 1) index++;
        while(index < str.length() && Character.isDigit(str.charAt(index))){
            result = result * 10 + str.charAt(index) - '0';
            if(result > Integer.MAX_VALUE) if(sign == 1) return Integer.MIN_VALUE; else return Integer.MAX_VALUE;
            index++;
        }
        return sign == 1 ? -Math.toIntExact(result) : Math.toIntExact(result);
    }

    public static void main(String[] args){
        StringToInteger_atoi atoi = new StringToInteger_atoi();
        int result = atoi.myAtoi("+");
        int result1 = atoi.myAtoi("");
        int result2 = atoi.myAtoi("20000000000000000000");
        int result3 = atoi.myAtoi("-91283472332");
        int result4 = atoi.myAtoi("-a91283472332abb345");
        int result5 = atoi.myAtoi("42");
        int result6 = atoi.myAtoi("-2147483648");
        System.out.println(result6);
    }
}