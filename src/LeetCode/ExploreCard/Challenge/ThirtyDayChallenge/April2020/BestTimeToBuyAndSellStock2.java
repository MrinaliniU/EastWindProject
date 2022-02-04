package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.April2020;
/*
    Problem No. 122
    - Say our array looks like this : 7, 1, 5, 3, 6, 4
    - The idea is that I'll buy stock at the first lowest price I see in array and see it at the immediate next
    price hike.
    - The tricky part is finding the next buy-sell pairs. In our case I buy at 1 (index 1) and sell at 5 (index 2).
    - Logically you would think that now we start looking  for the next pair starting from 3 (index 3) by
    keeping 3 (index 3) as the starting min value. But we start looking by taking 5 (index 2) as the starting min value.
    The reason why this worked is let's look at array that looks like this:
    for 7, 1, 5, 20.
        iteration 1 : look at 7 may be 7 is the min price to buy stock. 7 becomes smallest price seen so far
        iteration 2 : look at 1 compare with 7, hey no 1 is a better day to buy stock. 1 becomes smallest price
                      seen so far.
        iteration 3 : 5 is higher than the price I bought stock for, so let's sell it. Profit is now (5 - 1) = 4.
                      5 becomes the min price or the smallest price we have seen so far.
        iteration 4 : Look at 20, it's greater than the price 5 at which I bought stock
                      (though not really we will soon see why this works). So let's sell at 20. Profit is (20 - 5) = 15.
        Total profit is 4 + 15 = 19. 4 being the profit we got in iteration 3 and 15 in iteration 4.
        Look how 19 is the right answer if we buy stock at 1 and sell at 20 which is the highest profit you could make.
        This worked because what we essentially did was (5 - 1) + (20 - 5) = (20 - 1) = 90. What we essentially did
        was cancel out the 5 by considering it in the sub-array to look for next pair of buy-sell days.
 */
public class BestTimeToBuyAndSellStock2 {
    /*
        Runtime: 2 ms beats 6.4%
        Memory Usage: 41 MB
     */
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0; // what kind of test case is this? Seriously
        int solution = 0; // max
        int min = prices[0];
        for(int price : prices){
            if(price > min)
                solution += (price - min);
            min = price;
        }
        return solution;
    }
    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        BestTimeToBuyAndSellStock2 _2 = new BestTimeToBuyAndSellStock2();
        System.out.println(_2.maxProfit(prices));
    }
}
