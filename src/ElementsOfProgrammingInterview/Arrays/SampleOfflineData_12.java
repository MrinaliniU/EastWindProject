package ElementsOfProgrammingInterview.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SampleOfflineData_12 {

    public enum Color {
        RED, WHITE, BLUE, ORANGE, PINK, YELLOW, BLACK, CYAN, BROWN
    }

    public static void sampleData(List<Color> array, int k) {
        int len = array.size();
        if (k > len) return;
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            int pick = random.nextInt(len - i) + i;
            Collections.swap(array, i, pick);
        }
    }

    public static void sampleData2(List<Color> array, int k) {
        int len = array.size();
        if (k > len) return;
        Random random = new Random();
        for (int i = 0; i < k; i++) {
            int pick = random.nextInt(len) + i;
            Collections.swap(array, i, pick);
        }
    }

    public static void main(String[] args) {
        List<Color> array = Arrays.asList(Color.values());
        List<Color> array2 = Arrays.asList(Color.values());
        sampleData(array, 2);
        sampleData2(array2, 2);
        System.out.println(array.subList(0, 2));
        System.out.println(array2.subList(0, 2));
    }
}
