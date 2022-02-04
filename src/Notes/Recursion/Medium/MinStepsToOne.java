package Notes.Recursion.Medium;

/*
    Problem Statement: Given a number 'n', find the least number of operations required to get 1. The operations
    allowed are as follows:
    1) Subtract n by 1.
    2) Divide n by 3.
    3) Divide n by 2.
 */

/*
    This solution cannot be solved by Greedy Approach as it will not result in correct solution. Below is a recursive
    solution to the problem. This problem recursively checks all possible operations that can be performed on a number
    and finally return the shortest path to reach one. The operations can be visualized in a tree form but note that
    there is no actual tree structure formed.
 */

// TODO: 10/18/2019 add tree visual diagram.

/*
        This is not an optimal solution. The runtime grows exponentially as the code checks for all possible operations.
    A better solution would be Memoization or Tabulation approach.
     */

import Interfaces.MinStepsToOneInterface;

public class MinStepsToOne implements MinStepsToOneInterface {

    @Override
    public int minStepToOne(int n){
        return traverse(n);
    }

    private int traverse(int number){
        if(number == 1)
            return 0;
        int steps =  minStepToOne(number - 1);

        if(number % 3 == 0) {
            int divideBy3 = minStepToOne(number / 3);
            steps = Math.min(steps, divideBy3);
        }
        if(number % 2 == 0){
            int divideBy2 = minStepToOne(number / 2);
            steps = Math.min(steps, divideBy2);
        }
        return steps + 1;
    }

    /* Run the code in AllMinStepsToOneDemo class */
}
