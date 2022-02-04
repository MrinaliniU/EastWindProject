package MyInterviews.Amazon.YR2022;

/*
    Given an array of binary digits, 0, 1, sort theh array so that all zeros are at one end and all ones are at the other.
    Which end does not matter. To sort the array swap any two adjacent elements. Determine the minimum number of swaps to sort the array.
    Example arr [0, 1, 0, 1] minMove = 1;
 */
public class OnlineProblem2 {

    public static int minswaps(int[] arr, int a)
    {
        int n = arr.length;
        int count = 0;
        int num_unplaced_zeros = 0;

        for (int index = n - 1; index >= 0; index--)
        {
            if (arr[index] == a)
                num_unplaced_zeros += 1;
            else
                count += num_unplaced_zeros;
        }
        return count;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 1, 1, 0, 1};
        System.out.println(minswaps(arr, 0));
        System.out.println(minswaps(arr, 1));
    }
}
