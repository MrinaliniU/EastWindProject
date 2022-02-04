package HackerRank.Medium;

/*
    Given a string n and int k, find string p which concatenates n k times.
    Example: n = "123" k = 3 then p = "123123123". (123 3 times)
    The end goal is to find the superDigit of p.
    A super digit is a SINGLE digit number that is obtained by adding all digits in p till the sum results in a single
    digit.
    in given case p = "123123123" sum of all digits is 18, since this is not a single digit we add digits of this
    result again 1 + 8 = 9 resulting in single digit.
    Hence the super digit of p is 9.
 */
public class RecursiveDigitSum {

    public static int superDigit(String n, int k){
        String N_by_K = findString_N_by_K(n, k);
        while(N_by_K.length() > 1){
            N_by_K = Integer.toString(findDigitSum(N_by_K));
        }
        return Integer.parseInt(N_by_K);
    }
    private static String findString_N_by_K(String n, int k){
        int stringToInt = findDigitSum(n);
        return Integer.toString(stringToInt * k);
    }
    /* Recursive method */
    private static int findDigitSum(String n, int index, int result){
        if(index < 0)
            return result;
        result = result + Character.getNumericValue(n.charAt(index));
        return findDigitSum(n, index - 1, result);
    }
    /* Non - recursive method */
    private static int findDigitSum(String n){
        int result = 0;
        for(int i = 0; i < n.length(); i++){
            result = result + Character.getNumericValue(n.charAt(i));
        }
        return result;
    }
    public static void main(String[] args){
        int test = superDigit("123", 3);
        System.out.println("Result: " + test);
    }
}
