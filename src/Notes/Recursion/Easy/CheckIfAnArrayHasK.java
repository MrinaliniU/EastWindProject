package Notes.Recursion.Easy;

import java.util.Arrays;

public class CheckIfAnArrayHasK {

    public boolean hasK(int[] array, int k){
        return helper(array, k, 0);
    }

    public boolean helper(int[] array, int k, int index){
        if(index == array.length) return false;
        if(array[index] == k) return true;
        return helper(array, k, index + 1);
    }

    public static void main(String[] args){
        int[] array = {1, 2, 3, 1};
        int k = 1;
        CheckIfAnArrayHasK ck = new CheckIfAnArrayHasK();
        System.out.println("The array " + Arrays.toString(array) + " has " + k + " : " + ck.hasK(array, k));
    }
}
