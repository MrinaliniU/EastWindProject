package GooglePrep.KickStart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Wrong Answer */
public class BusRoutes {

    public static int furthestDay(int Days, List<Integer> X){
        int lastDay = Days;
        for(int i = X.size() - 1; i >= 0; i--){
            lastDay = getLastDay(Days, X.get(i), lastDay);
        }
        return lastDay;
    }
    static int getLastDay(int Days, int X, int lastDay){
        int T =  Days - (Days % X);
        int I = 2;
        while (T > lastDay){
            T = Days - (Days % (X * I));
            I++;
        }
        return T;
    }
    public static void main(String[] args){
        int Bus = 3, Days = 10;
        List<Integer> X = new ArrayList<>(Arrays.asList(3, 2, 4));
        System.out.println(furthestDay(Days, X));
        /*Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();  // number of test cases
        for (int i = 1; i <= tests; i++) {
            int Bus = in.nextInt(); // number of bus
            int Days = in.nextInt(); // number of days
            List<Integer> X = new ArrayList<>();
            for(int j = 0; j < Bus; j++){
                X.add(in.nextInt());
            }
            int lastDay = furthestDay(Days, X);
            System.out.println("Case #" + i + ": " + lastDay);
        }*/
    }
}
