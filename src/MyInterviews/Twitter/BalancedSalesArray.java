package MyInterviews.Twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BalancedSalesArray {

    public static int balancedSum(List<Integer> sales){
        int index = 0;
        int rightSales = totalSalesFromIndex1(sales);
        int leftSales = 0;
        while (leftSales != rightSales){
            leftSales += sales.get(index);
            index++;
            rightSales -= sales.get(index);

        }
        return index;
    }

    public static int totalSalesFromIndex1(List<Integer> sales){
        int sum = 0;
        for(int i = 1; i < sales.size(); i++){
            sum += sales.get(i);
        }
        return sum;
    }

    public static void main(String[] args){
        //List<Integer> sales = new ArrayList<>(Arrays.asList(1, 2, 3, 3));
        List<Integer> sales = new ArrayList<>(Arrays.asList(1, 2, 1));
        System.out.println("The middle index is " + balancedSum(sales));
    }
}
