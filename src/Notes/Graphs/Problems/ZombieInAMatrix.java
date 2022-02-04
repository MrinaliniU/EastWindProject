package Notes.Graphs.Problems;

import java.util.ArrayList;
import java.util.List;

public class ZombieInAMatrix {
    List<int[]> zombies;
    int numberOfHumans;
    int hours;
    public int hoursToApocalypse(int[][] grid){
        zombies = new ArrayList<>();
        numberOfHumans = 0;
        hours = 0;
        updateZombiesAndHumanLocation(grid);
        while (numberOfHumans > 0){
            hours++;
            zombies = zombify(grid, zombies);
        }
        return hours;
    }

    public List<int[]> zombify(int[][] grid, List<int[]> zombies){
        // for each zombie infect it's neighbor and add to list
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        List<int[]> newZombies = new ArrayList<>();
        for(int[] zombie : zombies){
            for(int[] direction : directions){
                int r = zombie[0] + direction[0];
                int c = zombie[1] + direction[1];
                if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 0){
                    // infect the human
                    grid[r][c] = 1;
                    // add them to new zombie list
                    newZombies.add(new int[]{r, c});
                    // reduce number of humans
                    numberOfHumans--;
                }
            }
        }
        return newZombies;
    }

    public void updateZombiesAndHumanLocation(int[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1) zombies.add(new int[]{i, j});
                else numberOfHumans++;
            }
        }
    }

    public static void main(String[] args){
        ZombieInAMatrix zm = new ZombieInAMatrix();
        int[][] grid = {{0, 1, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0}};
        System.out.println("Number of hours : " + zm.hoursToApocalypse(grid));
    }
}
