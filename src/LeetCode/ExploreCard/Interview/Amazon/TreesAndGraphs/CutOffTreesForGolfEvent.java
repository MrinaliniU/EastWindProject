package LeetCode.ExploreCard.Interview.Amazon.TreesAndGraphs;
import java.util.*;
/*
You are asked to cut off trees in a forest for a golf event.
The forest is represented as a non-negative 2D map, in this map:
    - 0 represents the obstacle can't be reached.
    - 1 represents the ground can be walked through.
    - The place with number bigger than 1 represents a tree can be walked through,
        and this positive number represents the tree's height.
You are asked to start from (0, 0) and cut off all the trees in the matrix starting from smallest
tree and ending in the tallest. You are to do this by taking the smallest number of steps possible.

So, you start at (0, 0) go to the location of the smallest tree via a shortest path cut it and move to
the next shortest tree via shortest path from your current location.

So, essentially you are calculating shortest distance from your location to another location every time
you need to cut a tree. You end this when there are no more trees left or when you cant reach a tree due to obstacles.

What you need:
    - dist function - calculate shortest distance from point A to B (BFS will do as there is no cost to move from
        one location to other)
    - list of trees - gives list of all trees in sorted fashion.
 */

public class CutOffTreesForGolfEvent {
    /*
        This is my code, same BFS code in leetcode has 263 ms.
        Runtime: 451 ms
        Memory Usage: 40.1 MB
     */
    public int cutOffTree(List<List<Integer>> forest) {
        int steps = 0; // total steps to cut all trees
        // Your initial location
        int r = 0, c = 0;
        // get list of trees and it's location sorted with respect to height.
        List<int[]> trees = treesInHeightOrder(forest);
        for(int[] tree : trees){
            int dist = shortestDistance_bfs(r, c, tree, forest);
            if(dist == -1) return -1; // means can't reach a tree.
            steps += dist; // means you cut the tree
            r = tree[1]; c = tree[2]; // change your location to where you cut the tree.
        }
        return steps;
    }

    public List<int[]> treesInHeightOrder(List<List<Integer>> forest){
        List<int[]> trees = new ArrayList<>();
        for(int i = 0; i < forest.size(); i++){
            for(int j = 0; j < forest.get(i).size(); j++){
                int height = forest.get(i).get(j);
                if(height > 1) trees.add(new int[]{height, i, j});
            }
        }
        trees.sort(Comparator.comparingInt(a -> a[0]));
        return trees;
    }
    /* Now we look at different algorithm to find the shortest distance from
    * one location to the next tree */
    /*
        In bfs approach what you do is from source node you look at all the 4 neighbors
        and see if you found your tree, if yes return the step if not move to next level.
        No since edge weight for all edges is 1 your steps is technically equal to
        the depth of the tree.
     */
    public int shortestDistance_bfs(int r, int c, int[] tree, List<List<Integer>> forest){
        // tree location is row = tree[1] and column = tree[2].
        int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c, 0}); // your current location, 0 is your depth
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        visited[r][c] = true;
        while (!queue.isEmpty()){
            int[] current_location = queue.poll();
            int curr_r = current_location[0];
            int curr_c = current_location[1];
            int curr_level = current_location[2];
            // mark as visited
            // it is important to check if you current location is the location where your tree is. You could be standing on the smallest tree
            // already
            if(curr_r == tree[1] && curr_c == tree[2]) return curr_level;
            // for all neighbors of your current location search for the tree you are looking for
            for(int[] direction : directions){
                int n_row = curr_r + direction[0];
                int n_col = curr_c + direction[1];
                if(!isValidDirection(n_row, n_col, forest, visited)) continue;
                visited[n_row][n_col] = true; // mark visited here not beginning of the while loop fails for big graph.
                // think about it, you don't have to mark a node visited after it has been completely explored.
                queue.add(new int[]{n_row, n_col, curr_level + 1}); // you simply add valid neighbors to queue, nothing else
            }
        }
        return -1; // could not reach the tree
    }
    public boolean isValidDirection(int r, int c, List<List<Integer>> forest, boolean[][] visited){
        return (r >= 0 && r < forest.size() && c >= 0 && c < forest.get(0).size() &&
                forest.get(r).get(c) != 0 && !visited[r][c]);
    }
    public static void main(String[] args){
        CutOffTreesForGolfEvent co = new CutOffTreesForGolfEvent();
        List<List<Integer>> forest = new ArrayList<>();
        forest.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        forest.add(new ArrayList<>(Arrays.asList(0, 0, 4)));
        forest.add(new ArrayList<>(Arrays.asList(7, 6, 5)));
        List<List<Integer>> forest2 = new ArrayList<>();
        forest2.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        forest2.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        forest2.add(new ArrayList<>(Arrays.asList(7, 6, 5)));
        List<List<Integer>> forest3 = new ArrayList<>();
        forest3.add(new ArrayList<>(Arrays.asList(2, 3, 4)));
        forest3.add(new ArrayList<>(Arrays.asList(0, 0, 5)));
        forest3.add(new ArrayList<>(Arrays.asList(8, 7, 6)));
        List<List<Integer>> forest4 = new ArrayList<>();
        forest4.add(new ArrayList<>(Arrays.asList(69438,55243,0,43779,5241,93591,73380)));
        forest4.add(new ArrayList<>(Arrays.asList(847,49990,53242,21837,89404,63929,48214)));
        forest4.add(new ArrayList<>(Arrays.asList(90332,49751,0,3088,16374,70121,25385)));
        forest4.add(new ArrayList<>(Arrays.asList(14694,4338,87873,86281,5204,84169,5024)));
        forest4.add(new ArrayList<>(Arrays.asList(31711,47313,1885,28332,11646,42583,31460)));
        forest4.add(new ArrayList<>(Arrays.asList(59845,94855,29286,53221,9803,41305,60749)));
        forest4.add(new ArrayList<>(Arrays.asList(95077,50343,27947,92852,0,0,19731)));
        forest4.add(new ArrayList<>(Arrays.asList(86158,63553,56822,90251,0,23826,17478)));
        forest4.add(new ArrayList<>(Arrays.asList(60387,23279,78048,78835,5310,99720,0)));
        forest4.add(new ArrayList<>(Arrays.asList(74799,48845,60658,29773,96129,90443,14391)));
        forest4.add(new ArrayList<>(Arrays.asList(65448,63358,78089,93914,7931,68804,72633)));
        forest4.add(new ArrayList<>(Arrays.asList(93431,90868,55280,30860,59354,62083,47669)));
        forest4.add(new ArrayList<>(Arrays.asList(81064,93220,22386,22341,95485,20696,13436)));
        forest4.add(new ArrayList<>(Arrays.asList(50083,0,89399,43882,0,13593,27847)));
        forest4.add(new ArrayList<>(Arrays.asList(0,12256,33652,69301,73395,93440,0)));
        forest4.add(new ArrayList<>(Arrays.asList(42818,87197,81249,33936,7027,5744,64710)));
        forest4.add(new ArrayList<>(Arrays.asList(35843,0,99746,52442,17494,49407,63016)));
        forest4.add(new ArrayList<>(Arrays.asList(86042,44524,0,0,26787,97651,28572)));
        forest4.add(new ArrayList<>(Arrays.asList(54183,83466,96754,89861,84143,13413,72921)));
        forest4.add(new ArrayList<>(Arrays.asList(89405,52305,39907,27366,14603,0,14104)));
        forest4.add(new ArrayList<>(Arrays.asList(70909,61104,70236,30365,0,30944,98378)));
        forest4.add(new ArrayList<>(Arrays.asList(20124,87188,6515,98319,78146,99325,88919)));
        forest4.add(new ArrayList<>(Arrays.asList(89669,0,64218,85795,2449,48939,12869)));
        forest4.add(new ArrayList<>(Arrays.asList(93539,28909,90973,77642,0,72170,98359)));
        forest4.add(new ArrayList<>(Arrays.asList(88628,16422,80512,0,38651,50854,55768)));
        forest4.add(new ArrayList<>(Arrays.asList(13639,2889,74835,80416,26051,78859,25721)));
        forest4.add(new ArrayList<>(Arrays.asList(90182,23154,16586,0,27459,3272,84893)));
        forest4.add(new ArrayList<>(Arrays.asList(2480,33654,87321,93272,93079,0,38394)));
        forest4.add(new ArrayList<>(Arrays.asList(34676,72427,95024,12240,72012,0,57763)));
        forest4.add(new ArrayList<>(Arrays.asList(97957,56,83817,45472,0,24087,90245)));
        forest4.add(new ArrayList<>(Arrays.asList(32056,0,92049,21380,4980,38458,3490)));
        forest4.add(new ArrayList<>(Arrays.asList(21509,76628,0,90430,10113,76264,45840)));
        forest4.add(new ArrayList<>(Arrays.asList(97192,58807,74165,65921,45726,47265,56084)));
        forest4.add(new ArrayList<>(Arrays.asList(16276,27751,37985,47944,54895,80706,2372)));
        forest4.add(new ArrayList<>(Arrays.asList(28438,53073,0,67255,38416,63354,69262)));
        forest4.add(new ArrayList<>(Arrays.asList(23926,75497,91347,58436,73946,39565,10841)));
        forest4.add(new ArrayList<>(Arrays.asList(34372,69647,44093,62680,32424,69858,68719)));
        forest4.add(new ArrayList<>(Arrays.asList(24425,4014,94871,1031,99852,88692,31503)));
        forest4.add(new ArrayList<>(Arrays.asList(24475,12295,33326,37771,37883,74568,25163)));
        forest4.add(new ArrayList<>(Arrays.asList(0,18411,88185,60924,29028,69789,0)));
        forest4.add(new ArrayList<>(Arrays.asList(34697,75631,7636,16190,60178,39082,7052)));
        forest4.add(new ArrayList<>(Arrays.asList(24876,9570,53630,98605,22331,79320,88317)));
        forest4.add(new ArrayList<>(Arrays.asList(27204,89103,15221,91346,35428,94251,62745)));
        forest4.add(new ArrayList<>(Arrays.asList(26636,28759,12998,58412,38113,14678,0)));
        forest4.add(new ArrayList<>(Arrays.asList(80871,79706,45325,3861,12504,0,4872)));
        forest4.add(new ArrayList<>(Arrays.asList(79662,15626,995,80546,64775,0,68820)));
        forest4.add(new ArrayList<>(Arrays.asList(25160,82123,81706,21494,92958,33594,5243)));
        System.out.println("Steps to cut all trees " + co.cutOffTree(forest));
    }
}
