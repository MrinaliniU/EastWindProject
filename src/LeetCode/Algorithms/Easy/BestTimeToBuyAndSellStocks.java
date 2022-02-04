package LeetCode.Algorithms.Easy;

/*
    Problem No. 121.
 */
public class BestTimeToBuyAndSellStocks {

    /* Runtime: 2 ms, faster than 21.44%
    Memory Usage: 41.2 MB, less than 5.31%
    Best Runtime so far...
 */
    public int maxProfit1(int[] prices) {
        if(prices.length == 0) return 0; // what kind of test case is this? Seriously
        int solution = 0; // max
        int min = prices[0];
        for(int price : prices){
            if(price < min) min = price;
            else solution = Math.max(solution, price - min);
        }
        return solution;
    }

    /*
        Runtime: 261 ms, faster than 5.67%
        Memory Usage: 42.9 MB, less than 5.31%
        O(n^2) runtime because of nested for loops.
     */
    public int maxProfit(int[] prices){
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            int buy = prices[i];
            int sell = findBestSell(buy, i, prices);
            maxProfit = Math.max(maxProfit, sell - buy);
        }
        return maxProfit;
    }
    private int findBestSell(int buy, int index, int[] prices){
        if(index >= prices.length - 1)
            return -1;
        int max = -1;
        for(int i = index + 1; i < prices.length; i++){
            max = Math.max(max, prices[i]);
            if(buy > max)
                max = -1;
        }
        return max;
    }
    /*
        O(n) runtime;
    */
    public int maxProfit_faster(int[] prices){
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            if (price < min)
                min = price;
            else if (price - min > max)
                max = price - min;
        }
        return max;
    }
    public static void main(String[] args){
        //int[] prices = {7, 5, 3, 6, 4, 1};
        int[] prices = {7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSellStocks best = new BestTimeToBuyAndSellStocks();
        System.out.println("Best profit " + best.maxProfit_faster(prices));
    }
}
