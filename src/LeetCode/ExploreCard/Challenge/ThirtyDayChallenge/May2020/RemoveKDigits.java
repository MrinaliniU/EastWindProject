package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.May2020;

import java.util.*;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            if (stack.size() > 0 && stack.peekLast() > num.charAt(i) && k != 0) {
                stack.removeLast();
                k--;
            }
            stack.add(num.charAt(i));
        }
        while (k > 0){
            stack.removeLast();
            k--;
        }
        while (!stack.isEmpty()) sb.append(stack.removeFirst());
        while ((sb.length() > 0 && sb.charAt(0) == '0')) sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits rk = new RemoveKDigits();
        // System.out.println(rk.removeKdigits("10", 2)); //0
        // System.out.println(rk.removeKdigits("112", 1));// 11
        //System.out.println(rk.removeKdigits("10200", 1)); //200
        //System.out.println(rk.removeKdigits("1111111", 3)); //1111
        //System.out.println(rk.removeKdigits("9", 1)); //0
        //System.out.println(rk.removeKdigits("1432219", 3));// 1219
        System.out.println(rk.removeKdigits("1234567890", 9));// 0
    }

}
