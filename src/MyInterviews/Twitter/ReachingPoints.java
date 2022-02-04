package MyInterviews.Twitter;

public class ReachingPoints {

    public static String canReach(int x1, int y1, int x2, int y2){
        if(navigate(x1, y1, x2, y2)) return "Yes";
        return "No";
    }

    public static boolean navigate(int x1, int y1, int x2, int y2){
        if(x1 == x2 && y1 == y2) return true;
        if(x1 > x2 || y1 > y2) return false;
        boolean right = navigate(x1 + y1, y1, x2, y2);
        boolean up = navigate(x1, x1 + y1, x2, y2);
        return right || up;
    }

    public static void main(String[] args){
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        System.out.println(canReach(1, 4, 5, 9));
        System.out.println(canReach(1, 2, 2, 1));
    }
}
