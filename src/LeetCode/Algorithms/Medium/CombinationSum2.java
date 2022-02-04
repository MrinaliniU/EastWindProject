package LeetCode.Algorithms.Medium;

/*
    Problem No. 40.
    Given a list of numbers find all unique combinations of sub-sets whose sum equals a given target. This problem is
    also knows as sum of sub-sets. Here each number can be used only once. We can think of this in terms of whether we
    include a number or not include a number in our sub-set solution.
    This is a combination problem and hence we use the strategy of DFS + recursion. This is a backtracking problem
    and backtracking problems are usually recursive. Backtracking problems usually have bounding functions.
    These bounding functions stops the growth of the tree when an invalid scenario is encountered. Here at each node
    we find sum of sub-sets by checking the combination of including or not including each number in the array.
    The bounding function would be to terminate the growth of tree when the sum of substring is larger than the
    target sum. We also terminate the growth when there are no more numbers in the array to include/not-include in
    our sub set.
    The State Space Tree shown in the image CombinationSum2 shows all possible combination of the given array
    {1, 2, 3, 1} and target 4.
    One problem with this approach is that since 1 occurs twice a valid combination would be to pick [1, 3] at 0 and
    2 index and [3, 1] at 2 and 3 index.
    sumOfSubSet re-produces the State Space Tree and every time a target sum is found it means a subset is found and
    it increments subsets by 1.
    The problem however asks for unique combination of sub-arrays. To avoid this result we could sort the array and
    check if the number in front/behind is the same in which case we just pick it once.

 */
import java.util.*;

public class CombinationSum2 {
    int subsets = 0;
    int r1 = 0;
    int r2 = 0;
    /* Runtime O(2^n)
    * Runtime: 4 ms, faster than 70.50%
    * Memory Usage: 39.2 MB, less than 65.26%
    * */
   public List<List<Integer>> combinationSum2(int[] candidates, int target){
       List<List<Integer>> result = new ArrayList<>();
       Arrays.sort(candidates);
       combinationSum2Helper(candidates, 0, target, result, new ArrayList<>());
       return result;
    }

    public void combinationSum2Helper(int[] candidates, int index, int currentTarget, List<List<Integer>> result,
                                      List<Integer> current){
        r1++;
        if(currentTarget == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        if (currentTarget < 0) return;
        for(int i = index; i < candidates.length; i++){
            if(i == index || candidates[i] != candidates[i - 1]) { //This is purely to avoid same looking array in final list of arrays. This works only for a sorted candidate list
                current.add(candidates[i]);
                combinationSum2Helper(candidates, i + 1, currentTarget - candidates[i], result, current);
                current.remove(current.size() - 1);
            }
        }
    }

    public void sumOfSubSet(int[] candidates, int target) {
        int total = 0;
        for(int i : candidates){
            total += i;
        }
        sumOfSubSetHelper(candidates, 0, total, 0, target);
        System.out.println(subsets);
    }
    public void sumOfSubSetHelper(int[] candidates, int currentSum, int leftSum, int index, int target) {
            r2++;
            if(currentSum == target) {
                subsets++;
                return;
            }
            if(leftSum == 0 || index == candidates.length || currentSum > target) return;
            sumOfSubSetHelper(candidates, currentSum + candidates[index],
                    leftSum - candidates[index], index + 1, target);
            sumOfSubSetHelper(candidates, currentSum, leftSum - candidates[index], index + 1, target);

    }
    public static void main(String[] args){
        CombinationSum2 cs = new CombinationSum2();
      int[] candidates = {1, 2, 3, 1};
        int target = 4;
        List<List<Integer>> solution = cs.combinationSum2(candidates, target);
        cs.sumOfSubSet(candidates, target);
        for(List<Integer> l1 : solution){
            System.out.println(l1 + " ");
        }
        System.out.println("combinationSum2 " + cs.r1);
        System.out.println("sumOfSubSet " + cs.r2);
    }
}
