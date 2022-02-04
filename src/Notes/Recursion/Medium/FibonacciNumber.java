package Notes.Recursion.Medium;

public class FibonacciNumber {

    public int fibonacci(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args){
        FibonacciNumber fn = new FibonacciNumber();
        int n = 6;
        System.out.println("The " + n + "th Fibonacci number is " + fn.fibonacci(n) +".");
    }
}
