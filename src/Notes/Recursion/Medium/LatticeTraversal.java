package Notes.Recursion.Medium;

/* Given a m * n matrix find all possible paths that you can take to traverse from top left (0,0) to bottom
    right (m, n) spot. Assume you can only move right and down and not diagonally.
 */

public class LatticeTraversal {

    private static int allPossiblePath(int m, int n){
        if(m == 0 && n == 0){
            return 0;
        }

        if(m == -1 || n == -1){
            return 1;
        }
        return allPossiblePath(m - 1, n) + allPossiblePath(m, n - 1);
    }

    public static void main(String[] args){
        int m = 2;
        int n = 2;
        System.out.println("Number of possible paths to reach (" + m + ", " + n + ") is " + allPossiblePath(m,n));
    }
}