package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.May2020;

import java.util.*;

public class OnlineStockSpan {
    Stack<Integer> priceStack, weightStack;

    public OnlineStockSpan() {
        this.priceStack = new Stack<>();
        this.weightStack = new Stack<>();
    }

    public int next(int price) {
        int tempWeight = 1;
        if(!priceStack.isEmpty() && priceStack.peek() <= price) {
            while (!priceStack.isEmpty() && priceStack.peek() < price){
                tempWeight += weightStack.pop();
                priceStack.pop();
            }
        }
        weightStack.add(tempWeight);
        priceStack.add(price);
        return tempWeight;
    }

    public static void main(String[] args){
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        OnlineStockSpan spanner = new OnlineStockSpan();
        for(int price : prices){
            System.out.print(spanner.next(price) + " ");
        }

    }
}
