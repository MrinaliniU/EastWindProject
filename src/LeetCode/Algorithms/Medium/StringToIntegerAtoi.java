package LeetCode.Algorithms.Medium;

/* Problem Number: 8. */

public class StringToIntegerAtoi {
    /*
        Run Time : 2 ms
        Memory = 35.9 MB
     */
    private static int myAtoi(String str){
        long result = 0;
        int sign = 0, i = 0;
        String trimString = str.trim();
        char[] trimCharArray = trimString.toCharArray();
        int charArrayLength = trimCharArray.length;
        if(charArrayLength == 0) return 0;
        if(trimCharArray[0] == '-'){
            sign = -1;
            i = 1;
        } else if(trimCharArray[0] == '+') {
            sign = 1;
            i = 1;
        }
        for(; i < charArrayLength; i++){
            if(!Character.isDigit(trimCharArray[i])) break;
            result = result * 10 + trimCharArray[i] - '0';
            if(result > Integer.MAX_VALUE && (sign == 1 || sign == 0)) return Integer.MAX_VALUE;
            else if(result < Integer.MIN_VALUE || (sign == -1 && result > Integer.MAX_VALUE) ) return Integer.MIN_VALUE;

        }
        if(result == 0) return 0;
        if(sign == -1) return -Math.toIntExact(result);
        return Math.toIntExact(result);
    }

    public static void main(String[] args){
        int result = myAtoi("-2147483648");
        System.out.println(result);
    }
}
