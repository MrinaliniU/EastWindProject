package MyInterviews.Twitter;

import java.util.*;

public class FinalDiscountedPrice {

    public static void finalPrice(List<Integer> prices){
        long total = 0;
        List<Integer> indices = new ArrayList<>();
        for(int i = 0; i < prices.size(); i++){
            int j = i + 1;
            while(j < prices.size()){
                if(prices.get(j) <= prices.get(i)){
                    break;
                }
                j++;
            }
            if(j < prices.size()) {
                total += prices.get(i) - prices.get(j);
            }else{
                total += prices.get(i);
                indices.add(i);
            }
        }
        System.out.println(total);
        for(int x = 0; x < indices.size() - 1; x++){
            System.out.print(indices.get(x) + " ");
        }
        System.out.print(indices.get(indices.size() - 1));
    }

    public static void main(String[] args){
        //List<Integer> input = new ArrayList<>(Arrays.asList(5, 1, 3, 4, 6, 2));// 14 [1, 5]
        //List<Integer> input = new ArrayList<>(Arrays.asList(1, 3, 3, 2, 5)); // 9 [0, 3, 4]
        //List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)); //15 [0, 1, 2, 3, 4]
        //List<Integer> input = new ArrayList<>(Arrays.asList(100, 10, 5, 3, 2, 5)); //105 [4, 5]
        //List<Integer> input = new ArrayList<>(Arrays.asList(3, 2, 1)); // 3 [2]
        List<Integer> input = new ArrayList<>(Arrays.asList(1)); // 1 [0]
        //List<Integer> input = new ArrayList<>(Arrays.asList(3, 2, 5)); // 8 [1, 2]
        //List<Integer> input = new ArrayList<>(Arrays.asList(100, 4, 5, 3, 2, 5)); // 107 [4, 5]
        finalPrice(input);
    }
}
