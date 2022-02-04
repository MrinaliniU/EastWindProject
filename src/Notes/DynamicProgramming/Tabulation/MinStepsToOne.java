package Notes.DynamicProgramming.Tabulation;

import Interfaces.MinStepsToOneInterface;

public class MinStepsToOne implements MinStepsToOneInterface {
    public int minStepToOne(int n) {
        int[] result = new int[n + 1];
        for(int i = 2; i < result.length; i++){
            int option = result[i - 1];
            if(i % 3 == 0){
                int divideBy3 = result[i / 3];
                option = Math.min(option, divideBy3);
            }
            if(i % 2 == 0){
                int divideBy2 = result[i / 2];
                option = Math.min(option, divideBy2);
            }

            result[i] = option + 1;
        }
        return result[n];
    }
}
/* Run the code in AllMinStepsToOneDemo class */