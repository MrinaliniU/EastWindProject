package LeetCode.ExploreCard.Interview.Amazon.ArraysAndStrings;

import java.util.Arrays;
/*
    A simple way to remember matrix rotation is for a given matrix A of size N * N.
    Remember the loop limits:
        - outer loop i : 0 -> N / 2;
        - Inner loop j : i -> N - 1 - i;
    The following convention
        - TOP : A[i][j];
        - LEFT: A[N - 1 - j][i];
        - RIGHT: A[j][N - 1- i];
        - BOTTOM: A[N - 1 - i][N - 1 - j];
    Now for a 90 degree rotation
        - CLOCKWISE :  TOP -> temp, LEFT -> TOP, BOTTOM -> LEFT, RIGHT -> BOTTOM, temp -> RIGHT
        - ~CLOCKWISE : TOP -> temp, RIGHT -> TOP, BOTTOM -> RIGHT, LEFT -> BOTTOM, temp -> LEFT

 */
public class RotateImage {
    /*
    Runtime: 0 ms
    Memory Usage: 39.6 MB
    This can be used to rotate image 270 degree anti clockwise
 */
    public void rotateImage90ClockWise(int[][] image){
        int N = image.length;
        for(int i = 0; i < N / 2; i++){
            for(int j = i; j < N - 1 - i; j++){
                // save top
                int temp = image[i][j];
                // left goes to top
                image[i][j] = image[N - 1 - j][i];
                //bottom goes to left
                image[N - 1 - j][i] = image[N - 1- i][N - 1 - j];
                // right goes to bottom
                image[N - 1- i][N - 1 - j] = image[j][N - 1 - i];
                // temp goes to right
                image[j][N - 1 - i] = temp;
            }
        }
    }
    public void rotateImage90AWise(int[][] image){
        int N = image.length;
        for(int i = 0; i < N / 2; i++){
            for(int j = i; j < N - 1 - i; j++){
                // save top
                int temp = image[i][j];
                // right goes to top
                image[i][j] = image[j][N - 1 - i];
                //bottom goes to right
                image[j][N - 1- i] = image[N - 1- i][N - 1 - j];
                // left goes to bottom
                image[N - 1- i][N - 1 - j] = image[N - 1- j][i];
                // temp goes to left
                image[N - 1 - j][i] = temp;
            }
        }
    }
    public static void main(String[] args){
        RotateImage ri = new RotateImage();
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println("Original Matrix");
        for(int[] i : matrix) System.out.println(Arrays.toString(i));
        ri.rotateImage90ClockWise(matrix);
        System.out.println("Rotate ClockWise");
        for(int[] i : matrix) System.out.println(Arrays.toString(i));
        ri.rotateImage90AWise(matrix);
        System.out.println("Anti ClockWise");
        for(int[] i : matrix) System.out.println(Arrays.toString(i));
    }
}
