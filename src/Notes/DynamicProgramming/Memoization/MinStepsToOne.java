package Notes.DynamicProgramming.Memoization;

import Interfaces.MinStepsToOneInterface;

import java.util.Arrays;

/*
    There are three steps to convert a recursive logic to memoization.
    1) Create cache
    2) Check cache
    3) Write to cache
 */

public class MinStepsToOne implements MinStepsToOneInterface {
    @Override
    public int minStepToOne(int number) {
        int[] cache = new int[number + 1];
        Arrays.fill(cache, -1);

        return traverse(number, cache);
    }

    private int traverse(int number, int[] cache){
        if(number == 1)
            return 0;
        if(cache[number] != -1)
            return cache[number];
        int steps = traverse(number - 1, cache);
        if(number % 3 == 0) {
            int divideBy3 = traverse(number / 3, cache);
            steps = Math.min(steps, divideBy3);
        }
        if(number % 2 == 0){
            int divideBy2 = traverse(number / 2, cache);
            steps = Math.min(steps, divideBy2);
        }
        cache[number] = 1 + steps;
        return cache[number];
    }
    /* Run the code in AllMinStepsToOneDemo class */
}
