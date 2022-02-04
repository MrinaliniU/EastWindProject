package LeetCode.Algorithms.Medium;

public class SearchA2DMatrix2 {
    int[][] matrix;
    int target;
    /*
        Runtime: 0 ms, faster than 100.00%
        Memory Usage: 39 MB, less than 25.76%
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;
        return search(0, matrix[0].length - 1, 0, matrix.length - 1);
    }

    public boolean search(int left, int right, int top, int bottom){
        if(left > right || top > bottom) return false;
        if(target < matrix[top][left] || target > matrix[bottom][right]) return false;
        int mid_col = left + (right - left) / 2;
        if(matrix[top][mid_col] == target) return true;
        // find row till you find an element that is greater than target;
        int row = top;
        while (row <= bottom && matrix[row][mid_col] < target){
            if(matrix[row][mid_col] == target) return true;
            row++;
        }
        return search(mid_col + 1, right, top, row - 1) ||
                search(left, mid_col - 1, row, bottom);
    }
    /*
        Runtime: 5 ms, faster than 71.17%
        Memory Usage: 44.9 MB, less than 94.34%
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;
        int row = matrix.length - 1, col = 0;
        return search(row, col);
    }
    boolean search(int row, int col){
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) return false;
        if(matrix[row][col] == target) return true;
        if(matrix[row][col] < target) return search(row, col + 1);
        else return search(row - 1, col);
    }
    public static void main(String[] args){
        SearchA2DMatrix2 s2 = new SearchA2DMatrix2();
/*        int[][] matrix = {{1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};*/
        int[][] matrix = {{1, 3, 5}};

        System.out.println(s2.searchMatrix(matrix, 1));
    }
}
