package LeetCode.Algorithms.Easy;

public class SubtractDigitProductAndSum {
    /*
        Runtime: 0 ms, faster than 100.00%
        Memory Usage: 36.3 MB, less than 100.00%
     */
    public int subtractProductAndSum(int n) {
        int sum = 0, product = 1;
        if(n < 10) return 0;
        while (n > 0){
            int mod = n % 10;
            sum += mod;
            product *= mod;
            n /= 10;
        }
        return product - sum;
    }
    public static void main(String[] args){
        SubtractDigitProductAndSum sd = new SubtractDigitProductAndSum();
        System.out.println(sd.subtractProductAndSum(4421));
    }
}
