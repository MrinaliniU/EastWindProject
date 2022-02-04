package ElementsOfProgrammingInterview.Arrays.variants;

public class CreateSpiralMatrix {

    int[][] ans;
    int[][] directions;
    public int[][] createSpiralMatrix(int d) {
        ans = new int[d][d];
        directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int numElements = d * d;
        int i = 1;
        int x = 0; int y = 0;
        int dir = 0;
        while (i <= numElements) {
            ans[x][y] = i;
            int nextX = x + directions[dir][0];
            int nextY = y + directions[dir][1];
            if (!valid(nextX, nextY, d)) {
                dir = (dir + 1) % 4;
                nextX = x + directions[dir][0];
                nextY = y + directions[dir][1];
            }
            x = nextX;
            y = nextY;
            i++;
        }
        return ans;
    }

    public boolean valid(int x, int y, int d) {
        return x >= 0 && y >= 0 && x < d && y < d && ans[x][y] == 0;
    }

    public static void main(String[] args) {
        CreateSpiralMatrix s = new CreateSpiralMatrix();
        int[][] ans = s.createSpiralMatrix(4);
        for (int[] an : ans) {
            for (int a : an) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
