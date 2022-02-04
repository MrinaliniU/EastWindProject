package LeetCode.Algorithms.Easy;

/*
    1030. Matrix Cells in Distance Order
    SOLVED.
*/

import java.util.*;

public class MatrixCellsInDistanceOrder {

    /* Not my code. This logic works only because it is the manhattan distance that we need to order by */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        boolean[][] visited = new boolean[R][C];
        int[][] result = new int[R * C][2];
        int i = 0;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{r0, c0});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            if (r < 0 || r >= R || c < 0 || c >= C) {
                continue;
            }
            if (visited[r][c]) {
                continue;
            }

            result[i] = cell;
            i++;
            visited[r][c] = true;

            queue.offer(new int[]{r, c - 1});
            queue.offer(new int[]{r, c + 1});
            queue.offer(new int[]{r - 1, c});
            queue.offer(new int[]{r + 1, c});
        }
        return result;
    }
    /* My Code */
    public int[][] allCellDistOrder(int R, int C, int r0, int c0){
        int[][] result = new int[R * C][2];
        int[] distance = new int[R * C];
        int k = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
               result[k][0] = i;
                result[k][1] = j;
                distance[k] = findDistance(i, j, r0, c0);
                k++;
            }
        }
        quickSort(result, distance);
        return result;
    }
    private int findDistance(int i, int j, int r0, int c0){
        return Math.abs(i - r0) + Math.abs(j - c0);
    }
    private void quickSort(int[][] result, int[] distance){
        quickSort(distance, result, 0, distance.length - 1);
    }

    private void quickSort(int[] distance, int[][] result, int left, int right){
        if(left < right) {
            int partition = partition(distance, result, left, right);
            quickSort(distance, result, left, partition - 1);
            quickSort(distance,result,  partition + 1, right);
        }
    }
    private int partition(int[] distance, int[][] result, int left, int right){
        int pivot = distance[right];
        int[] p = result[right];
        int i = left - 1;
        for(int j = left; j < right; j++){
            if(distance[j] < pivot){
                i++;
                int temp = distance[i];
                int[] temp2 = result[i];
                distance[i] = distance[j];
                result[i] = result[j];
                distance[j] = temp;
                result[j] = temp2;
            }
        }
        distance[right] = distance[i + 1];
        result[right] = result[i + 1];
        distance[i + 1] = pivot;
        result[i + 1] = p;
        return i + 1;
    }

    public static void main(String[] args){
        int R = 5;
        int C = 4;
        int r0 = 2;
        int c0 = 1;
        MatrixCellsInDistanceOrder mcd = new MatrixCellsInDistanceOrder();
        //int[][] dist = mcd.allCellDistOrder(R, C, r0, c0);
        int[][] dist = mcd.allCellsDistOrder(R, C, r0, c0);
        System.out.print("[");
        for(int[] i : dist){
            System.out.print("[" + i[0] + "," + i[1] + "],");
        }
        System.out.print("]");
    }
}
