package Notes.Math;

public class TrailingZeros {

    public static int trailingZeros(int n){
        int result = 0;
        while(n >= 5){
            n /= 5;
            result += n;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(trailingZeros(99));
    }

}
