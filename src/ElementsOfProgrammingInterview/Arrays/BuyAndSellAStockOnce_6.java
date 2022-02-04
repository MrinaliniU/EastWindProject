package ElementsOfProgrammingInterview.Arrays;

import java.util.Arrays;
import java.util.List;

public class BuyAndSellAStockOnce_6 {

    public static int maxProfit(List<Integer> array) {
        int smallestYet = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int a : array) {
            smallestYet = Math.min(smallestYet, a);
            maxProfit = Math.max(maxProfit, a - smallestYet);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(310, 315, 275, 295, 260, 270, 290, 230, 255, 250);
        System.out.println(maxProfit(array));
    }
}
