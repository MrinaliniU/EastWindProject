package LeetCode.Algorithms.Medium;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        int result = 0;
        boolean isNegative = dividend < 0 || divisor < 0;
        if(dividend < 0 && divisor < 0) isNegative = false;
        dividend = Math.abs(dividend); divisor = Math.abs(divisor);
        while (divisor < dividend){
            dividend -= divisor;
            result++;
        }
        return isNegative ? -result : result;
    }
    public static void main(String[] args){
        DivideTwoIntegers d = new DivideTwoIntegers();
        int dividend  = 7 , divisor = -3;
        System.out.println(d.divide(dividend, divisor));
    }
}
