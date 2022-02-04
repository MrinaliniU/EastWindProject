package GooglePrep.KickStart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BikeTour {
    public static int getPeaks(List<Integer> array){
        int numberOfPeaks = 0;
        if(array.size() < 3) return numberOfPeaks;
        int i = 1;
        while (i + 1 < array.size()){
            if(array.get(i) > array.get(i - 1) && array.get(i) > array.get(i + 1)){
                i += 2;
                numberOfPeaks++;
            }else {
                i++;
            }
        }
        return numberOfPeaks;
    }

    public static void main(String[] args){
        /*List<Integer> a = new ArrayList<>(Arrays.asList(10, 9, 10));
        System.out.println(getPeaks(a));*/
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();  // number of test cases
        for (int i = 1; i <= tests; i++) {
            int n = in.nextInt(); // size of the array list;
            List<Integer> array = new ArrayList<>();
            for(int j = 0; j < n; j++){
                array.add(in.nextInt());
            }
            int peaks = getPeaks(array);
            System.out.println("Case #" + i + ": " + peaks);
        }
    }
}
