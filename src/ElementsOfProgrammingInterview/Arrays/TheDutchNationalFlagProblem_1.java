package ElementsOfProgrammingInterview.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TheDutchNationalFlagProblem_1 {

    public static void dutchFlag(List<Integer> array, int index) {
        int pivot = array.get(index);
        int small = 0;
        int equal = 0;
        int large = array.size() - 1;
        while (equal <= large) {
            if (array.get(equal) < pivot) {
                Collections.swap(array, equal++, small++);
            } else if (array.get(equal) == pivot) {
                equal++;
            } else {
                Collections.swap(array, equal, large--);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(3, 9, 5, 2, 5, -1, 2, -1, 9, 0, 7);
        int k = 0;

        dutchFlag(array, k);
        System.out.println(array);
    }
}
