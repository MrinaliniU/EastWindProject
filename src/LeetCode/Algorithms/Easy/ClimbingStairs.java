package LeetCode.Algorithms.Easy;

/*
    Problem No. 70
    Fundamental Dynamic Programming.
    This is like Fibonacci Series.
 */
public class ClimbingStairs {

    /* O(2^n) runtime O(n) space depth of recursion */
    public int climbStairs(int n){
        if(n == 0)
            return 1;
        if(n < 0)
            return 0;
        return climbStairs(n - 2) + climbStairs(n - 1);
    }
    /* O(n) runtime. O(1) space */
    public int climbingStairsBottomUp(int n){
        int a = 1;
        int b = 1;
        int c = 1; // for when n = 1.
        for(int i = 2; i <= n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /* O( log n) runtime. O(1) space*/

   /* public int binetsMethod(int n){

    }*/

    public static void main(String[] args){
        int n = 8;
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(n));
        System.out.println(cs.climbingStairsBottomUp(n));

    }
}
