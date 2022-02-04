package LeetCode.StudyPlan.Algorithm1;

import java.util.ArrayList;
import java.util.List;

public class Day11_Combinations {
    List<List<Integer>> output = new ArrayList<>();
    int n;
    int k;

    private void backtrack(int f, List<Integer> curr) {
        if (curr.size() == k) {
            output.add(new ArrayList<>(curr));
        }

        for (int i = f; i < n + 1; i++) {
            curr.add(i);
            backtrack(i + 1, curr);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new ArrayList<>());
        return output;
    }

    public static void main(String[] args) {
        Day11_Combinations d11 = new Day11_Combinations();
        int n = 4; int k = 2;
        List<List<Integer>> result = d11.combine(n , k);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
