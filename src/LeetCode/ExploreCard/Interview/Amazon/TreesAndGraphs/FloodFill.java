package LeetCode.ExploreCard.Interview.Amazon.TreesAndGraphs;

import java.util.Arrays;

public class FloodFill {
    /*
        Runtime: 0 ms
        Memory Usage: 40.3 MB
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color != newColor) dfs(color, sr, sc, image, newColor);
        return image;
    }
    public void dfs(int color, int row, int col, int[][] image, int newColor){
        if(isValid(color, row, col, image)){
            // do dfs in four direction
            image[row][col] = newColor;
            dfs(color, row + 1, col, image, newColor);
            dfs(color, row - 1, col, image, newColor);
            dfs(color, row, col + 1, image, newColor);
            dfs(color, row, col - 1, image, newColor);
        }
    }

    boolean isValid(int color, int row, int col, int[][] image){
        return (row >= 0 && row < image.length && col >= 0 && col < image[0].length && image[row][col] == color);
    }

    public static void main(String[] args){
        FloodFill ff = new FloodFill();
        int[][] image = {{1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}};
        int[][] filled = ff.floodFill(image, 1, 1, 2);
        for(int[] i : filled) System.out.println(Arrays.toString(i));
    }
}
