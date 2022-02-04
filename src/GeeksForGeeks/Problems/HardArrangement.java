package GeeksForGeeks.Problems;

import java.util.Arrays;

/*
     int[] a = {9, 1, 2, 3, 3, 6, 5};
     int[] b = {0, 0, 0, 0, 1, 2, 3};
     index =    0  1  2  3  4  5  6
     Any element from index 0 to 3 must have "0" elements larger than them.
     Any element at index 4 must have just "1" element larger than them.
     Any element at index 5 must have just "2" element larger than them.
     Any element at index 6 must have exactly "3" element larger than them.
 */
public class HardArrangement {
    public void arrange(int[] a, int[] b, int[] c, int n) {
        // code here
        Arrays.sort(a);
        int lastZero = 0;
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j < n; j++) if(b[j] == 0) lastZero = j;
            c[lastZero] = a[i];
            for(int j = lastZero; j < n; j++) b[j]--;
        }
        System.out.print(Arrays.toString(c));
    }
    public static void main(String[] args){
        HardArrangement ha = new HardArrangement();
        int[] a = {9, 1, 2, 3, 3, 6, 5};
        int[] b = {0, 0, 0, 0, 1, 2, 3};
        ha.arrange(a, b, new int[7], a.length);
    }
}
