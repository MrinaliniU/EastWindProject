package Notes.DynamicProgramming.Tabulation;

public class Knapsack {

    public int maxProfit(int[] weights, int[] profits, int bagSize){
        int n = weights.length;
        int k[][] = new int[n + 1][bagSize + 1];
        for(int i = 0; i <= n; i++){
            for(int w = 0; w <= bagSize; w++){
                if(i == 0 || w == 0)
                    k[i][w] = 0;
                else if(weights[i - 1] <= w)
                    k[i][w] = Math.max((profits[i - 1] + k[i - 1][w - weights[i - 1]]), k[i - 1][w]);
                else
                    k[i][w] = k[i - 1][w];
            }
        }
        return k[n][bagSize];
    }

    public static void main(String[] args){
        Knapsack ks = new Knapsack();
        int[] weights = {1, 3, 4, 5};
        int[] profits = {1, 4, 5, 7};
        int bagSize = 7;
        System.out.println("The maximum profit with the given bag is " + ks.maxProfit(weights, profits, bagSize));
    }
}
