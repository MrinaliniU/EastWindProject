package MyInterviews.Twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PurchaseStock {
    public static int restock(List<Integer> itemCount, int target){
        int purchase = 0;
        for(int i : itemCount){
            if(purchase < target){
                purchase += i;
            }
        }
        if(purchase < target) return target - purchase;
        return purchase - target;
    }
    public static void main(String[] args){
        ArrayList<Integer> itemCount = new ArrayList<Integer>(Arrays.asList(6, 1, 2, 1));
        int target = 100;
        System.out.println(restock(itemCount, target));
    }
}
