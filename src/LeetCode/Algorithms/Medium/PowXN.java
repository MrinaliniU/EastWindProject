package LeetCode.Algorithms.Medium;

public class PowXN {
    /*
        Runtime: 0 ms, faster than 100.00%
        Memory Usage: 36.5 MB, less than 5.88%
     */
    public double myPow(double x, int n) {
        if(n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPower(x, n);
    }

    public double fastPower(double x, int n){
        if(n == 0) return 1.0;
        double A = fastPower(x , n / 2);
        if(n % 2 == 0) return A * A;
        else return  A * A * x;
    }

    public static void main(String[] args){
        double x = 2;
        int n = 10;
        PowXN p = new PowXN();
        System.out.println(p.myPow(x, n));
    }
}
