package LeetCode.Algorithms.Medium;

import java.util.*;

public class PrisonCellsAfterNDays {
    /*
        Below formula:
        if (N>14) N = N % 14 + 14;
            else N = N % 14;
        Works because :

        for any 8 bit length representation after at (8 * 2) iteration it the pattern starts repeating.
        Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
        Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
        Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
        Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
        Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
        Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
        Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
        Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
        Day 14 : [0, 0, 1, 1, 0, 1, 0, 0]
        Day 16 : [0, 1, 1, 0, 0, 0, 0, 0] ----- Same as Day 1.
     */
    public int[] prisonAfterNDays(int[] cells, int N) {
        N = N > 14 ? N % 14 + 14 : N % 14;
        int state = 0;
        /*
            What you are doing here essentially is to represent the cells 0/1 digit in a reverse order.
            So if cells are say just 4 in length
            cells : [0 0 1 1] State : int value of 1100
            cells : [0 1 0 1] State : int value of 1010
         */
        for (int i = 0; i < cells.length; ++i) if (cells[i] > 0) state ^= 1 << i;
        while(N > 0){
            state = nextDay(state, cells.length - 2);
            N--;
        }
        // Convert the state back to the required answer.
        int[] ans = new int[cells.length];
        for (int i = 0; i < cells.length; ++i) if (((state >> i) & 1) > 0) ans[i] = 1;
        return ans;
    }

    public int nextDay(int state, int len) {
        int ans = 0;
        for (int i = 1; i <= len; ++i) {
            if (((state >> (i - 1)) & 1) == ((state >> (i + 1)) & 1)) ans ^= 1 << i;
        }
        return ans;
    }
    /* This is what amazon asks in AMCAT */
    public List<Integer> prisonAfterNDays2(int[] cells, int N) {
        int[] _cells = new int[cells.length + 2];
        for(int i = 0; i < cells.length; i++){
            _cells[i + 1] = cells[i];
        }
        N = N > 14 ? N % 14 + 14 : N % 14;
        int state = 0;
        /*
            What you are doing here essentially is to represent the cells 0/1 digit in a reverse order.
            So if cells are say just 4 in length
            cells : [0 0 1 1] State : int value of 1100
            cells : [0 1 0 1] State : int value of 1010
         */
        for (int i = 0; i < _cells.length; ++i) {
            if (_cells[i] > 0) state ^= 1 << i;
        }
        while(N > 0){
            state = nextDay2(state, _cells.length - 2);
            N--;
        }
        // Convert the state back to the required answer.
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < _cells.length - 1; ++i) {
            if (((state >> i) & 1) > 0) ans.add(1);
            else ans.add(0);
        }
        return ans;
    }

    public int nextDay2(int state, int len) {
        int ans = 0;
        for (int i = 1; i <= len; ++i) {
            if (((state >> (i - 1)) & 1) != ((state >> (i + 1)) & 1)) ans ^= 1 << i;
        }
        return ans;
    }

    public static void main(String[] args){
        PrisonCellsAfterNDays pc = new PrisonCellsAfterNDays();
        /* Same neighbors un-set the bit, different neighbors set bit*/
        int[] cells1 = {1, 1, 1, 0, 1, 1, 1, 1};
        int N1 = 2;
        List<Integer> result = pc.prisonAfterNDays2(cells1, N1);
        System.out.println(result);
        int[] cells2 = {1, 0, 0, 0, 0, 1, 0, 0};
        int N2 = 1;
        List<Integer> result2 = pc.prisonAfterNDays2(cells2, N2);
        System.out.println(result2);
        /* Same neighbors set the bit, different neighbors un-set bit*/
        int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};
        int N = 7;
        int[] a = pc.prisonAfterNDays(cells, N);
        System.out.print("[");
        for(int i : a) System.out.print(i + ", ");
        System.out.println("]");
        /* For 4 Bit */
        int[] cells3 = {0, 1, 1, 0};
        int N3 = 2;
        System.out.print("[");
        int[] b = pc.prisonAfterNDays(cells3, N3);
        for(int i : b) System.out.print(i + ", ");
        System.out.print("]");

    }
}
