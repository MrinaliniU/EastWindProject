package Notes.Java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class AboutLists {

    int[] convertListToIntArray(List<Integer> course){
        /* List to course */
        int[] result = course.stream().mapToInt(i -> i).toArray();
        /* Trivial Action */
        for(int i = 0; i < result.length; i++) result[i]++;
        return result;
    }
    int[][] int2DArrayToLinkedListBackToInt2D(int[][] nums){
        /* 2D array to LinkedList */
        LinkedList<int[]> linkedList = new LinkedList<>(Arrays.asList(nums));
        /* Trivial Action */
        for (int[] ints : linkedList) ints[0] = 2;
        /* LinkedList To 2D Array */
        return linkedList.toArray(new int[linkedList.size()][]);
    }

    List<int[]> sortingList(List<int[]> trees){
        trees.sort(Comparator.comparingInt(a -> a[0]));
        return trees;
    }

    public static void main(String[] args){
        /* Quick Initializing */
        List<Integer> nums = Arrays.asList(1, 2, 7, 4, 5, 6, 3, 8);
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        /* List<Integer> nums2 = new ArrayList<>(Arrays.asList(1, 2, 7, 4, 5, 6, 3, 8)); */

    }
}
