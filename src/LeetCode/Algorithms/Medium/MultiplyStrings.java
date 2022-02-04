package LeetCode.Algorithms.Medium;

/*
    Problem No. 43.
 */
/*
    The length of both num1 and num2 is < 110.
    Both num1 and num2 contain only digits 0-9.
    Both num1 and num2 do not contain any leading zero, except the number 0 itself.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class MultiplyStrings {

    /*
        Runtime: 4 ms, faster than 67.60% of Java
        Memory Usage: 39 MB, less than 16.67%
     */
    public String multiply(String num1, String num2){
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] d = new int[num1.length() + num2.length()];
        for(int i = 0; i < n1.length(); i++){
            for(int j = 0; j < n2.length(); j++){
                d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < d.length; i++){
            int mod = d[i] % 10;
            int carry = d[i] / 10;
            if(i + 1 < d.length) {
                d[i + 1] += carry;
            }
            sb.insert(0, mod);
        }
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        int x = 9;
        int y = 99;
        String s = "9";
        String l = "99";
        MultiplyStrings ms = new MultiplyStrings();
        System.out.println("String Solution " + ms.multiply(s, l) + " Int solution " + x * y);
    }
}
