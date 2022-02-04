package HackerRank.Medium;

import java.math.BigInteger;

/* The problem is to find factorial of big numbers. Hence BigInteger is used.*/

public class ExtraLongFactorials {

    public void extraLongFactorials(int n){
        BigInteger result = new BigInteger("1");
        System.out.println(extraLongFactorials(n, result));

    }
    private BigInteger extraLongFactorials(int n, BigInteger result){
        if(n == 1)
            return result;
        result = new BigInteger(Integer.toString(n)).multiply(extraLongFactorials(n - 1, result));
        return result;
    }

    public static void main(String[] args){
        ExtraLongFactorials ef = new ExtraLongFactorials();
    }
}
