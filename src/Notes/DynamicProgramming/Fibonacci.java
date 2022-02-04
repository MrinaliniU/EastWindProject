package Notes.DynamicProgramming;

public class Fibonacci {

    public int fib(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        int a = 0;
        int b = 1;
        for(int i = 2; i < n; i++){
            int c = a + b;
            a = b;
            b = c;
        }
        return a + b;
    }

    public static void main(String[] args){
        int n = 6;
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("The " + n + "th Fibonacci number is " + fibonacci.fib(n) + ".");
    }
}
