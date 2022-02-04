package LeetCode.Algorithms.Medium;

import java.util.*;

/*
    Problem 39.
    When asked for a permutation or combination problem one could try solving it with some combination of dfs with
    recursion.
 */
public class CombinationSum {
/*
    Runtime: 2 ms, faster than 99.62%
    Memory Usage: 41.4 MB, less than 5.19%
 */

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    public void combinationSumHelper(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> current){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(target < 0) return;
        for(int i = index; i < candidates.length; i++){
            if(candidates[i] > target) break; // we have sorted the candidates before-hand hence the check here. This is so that we don't have to check combinations for elements that are greater than target.
            current.add(candidates[i]);
            combinationSumHelper(candidates, target - candidates[i], i, result, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args){
        CombinationSum cs = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = cs.combinationSum(candidates, target);
        for(List<Integer> i : result){
            System.out.println(i);
        }
    }
}
