package HackerRank.Medium;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/*
    SOLVED.
    MISTAKES MADE: 1. Not Using Binary Search.
                   2. Using LinkedHashSet.contains() in getMyRank() to eliminate when gameScore is present in scoreBoard
                      . This added unnecessary overhead. The logic can be easily handled in line 40.
*/
public class ClimbingTheLeaderBoard {

    // Complete the climbingLeaderboard function below.

    private static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] aliceScoreBoard = new int[alice.length];
        ArrayList<Integer> redesignScoreBoard = redesignScoreBoard(scores);
        for(int i = 0; i < aliceScoreBoard.length; i++){
            aliceScoreBoard[i] = getMyRank(redesignScoreBoard, alice[i]) + 1;
        }
        return aliceScoreBoard;
    }

    /* This method is required to eliminate duplicate scores in scoreboard */
   private static ArrayList<Integer> redesignScoreBoard(int[] scores) {
        LinkedHashSet<Integer> scoreBoard = new LinkedHashSet<>();
        for (int score : scores) {
            scoreBoard.add(score);
        }
        return new ArrayList<Integer>(scoreBoard);
    }

   private static int getMyRank(ArrayList<Integer> scoreBoard, int gameScore){

       return binarySearchForRightIndex(0, scoreBoard.size() - 1, scoreBoard, gameScore);
    }

    private static int binarySearchForRightIndex(int left, int right, ArrayList<Integer> scoreBoard, int gameScore){
        if(right >= left){
            int mid = left + (right - left) / 2;
            if(gameScore == scoreBoard.get(mid))
                return mid;
            if(gameScore > scoreBoard.get(mid)){
                return binarySearchForRightIndex(left,mid - 1, scoreBoard, gameScore);
            }
            return binarySearchForRightIndex(mid + 1, right, scoreBoard, gameScore);
        }
        return left;
    }


    public static void main(String[] args) throws IOException {
        int[] scores = {100, 100, 50, 40, 40, 20, 10};
        int[] alice = {5, 25, 50, 120};
        int[] result = climbingLeaderboard(scores, alice);
        for (int value : result) {
            System.out.println(value);
        }
    }

}
