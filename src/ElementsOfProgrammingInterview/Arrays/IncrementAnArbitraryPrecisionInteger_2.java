package ElementsOfProgrammingInterview.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IncrementAnArbitraryPrecisionInteger_2 {

    public static List<Integer> increment(List<Integer> array) {
        int i = array.size() - 1;
        array.set(i, array.get(i) + 1);
        while (i > 0 && array.get(i) == 10) {
            array.set(i, 0);
            array.set(i - 1, array.get(i - 1) + 1);
            i--;
        }
        if (array.get(0) == 10) {
            array.set(0, 1);
            array.add(0);
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(9, 9, 9));
        System.out.println(increment(array));
    }
}
