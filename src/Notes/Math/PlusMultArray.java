package Notes.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusMultArray {

    public static String plusMult(List<Integer> A) {
        int r_even = 0;
        int r_odd = 0;
        for(int i = 0; i < A.size(); i += 4){
            int j = i + 2;
            if(j < A.size())
                r_even = r_even + (A.get(i) * A.get(j));
            else  r_even = r_even + (A.get(i));
        }
        for(int i = 1; i < A.size(); i += 4){
            int j = i + 2;
            if(j < A.size())
                r_odd = r_odd + (A.get(i) * A.get(j));
            else  r_odd = r_odd + (A.get(i));
        }
        int finalR_even = r_even % 2;
        int finalR_odd = r_odd % 2;

        if(finalR_even == finalR_odd)
            return "NEUTRAL";
        else if(finalR_even > finalR_odd)
            return "EVEN";
        else
            return "ODD";
    }

    public static void main(String[] args){
        List<Integer> li = new ArrayList<Integer>(Arrays.asList());
        System.out.print(plusMult(li));
    }
}
