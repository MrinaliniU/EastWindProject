package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.May2020;

public class CheckStraightLine {
    /*
        Runtime: 0 ms
        Memory Usage: 39.2 MB
     */
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length <= 2) return true;
        double slope_m = getSlope(coordinates[0], coordinates[1]);
        if(slope_m == Double.MAX_VALUE) return checkAllXCoordinatesToBeZero(coordinates);
        double intercept = getIntercept(slope_m, coordinates[1]);
        for(int i = 2; i < coordinates.length; i++)
            if(!isOnLine(coordinates[i], slope_m, intercept)) return false;
        return true;
    }
    boolean checkAllXCoordinatesToBeZero(int[][] coordinates){
        for(int i = 2; i < coordinates.length; i++) if(coordinates[i][0] != 0) return false;
        return true;
    }
    boolean isOnLine(int[] coordinate, double slope, double intercept){
        double d = getIntercept(slope, coordinate);
        return intercept == d;
    }

    double getIntercept(double slope, int[] coordinate){
        return (coordinate[1] - (slope * coordinate[0]));
    }
    double getSlope(int[] a, int[] b){
        double run = a[0] - b[0];
        double rise = a[1] - b[1];
        if(run == 0) return Double.MAX_VALUE;
        return  rise / run;
    }

    public static void main(String[] args){
        CheckStraightLine cs = new CheckStraightLine();
        //int[][] coordinates = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}}; // false
        // int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        int[][] coordinates = {{0,2},{0,3},{0,4},{0,5},{0,6},{0,7}};
        System.out.print("Is straight line " + cs.checkStraightLine(coordinates));
    }
}
