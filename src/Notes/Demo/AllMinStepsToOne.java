package Notes.Demo;
import Notes.DynamicProgramming.Memoization.MinStepsToOne;

public class AllMinStepsToOne {

    public static void main(String[] args){
        Notes.DynamicProgramming.Tabulation.MinStepsToOne tab = new Notes.DynamicProgramming.Tabulation.MinStepsToOne();
        MinStepsToOne memo = new MinStepsToOne();
        Notes.Recursion.Medium.MinStepsToOne recur = new Notes.Recursion.Medium.MinStepsToOne();

        long beforeTime = System.nanoTime();
        System.out.println(tab.minStepToOne(500));
        long afterTime = System.nanoTime();
        System.out.println("The time it took for tabulation method "  + (afterTime - beforeTime));

        beforeTime = System.nanoTime();
        System.out.println(memo.minStepToOne(500));
        afterTime = System.nanoTime();
        System.out.println("The time it took for memoization method "  + (afterTime - beforeTime));


        beforeTime = System.nanoTime();
        System.out.println(recur.minStepToOne(500));
        afterTime = System.nanoTime();
        System.out.println("The time it took for recursion method "  + (afterTime - beforeTime));
    }
}
