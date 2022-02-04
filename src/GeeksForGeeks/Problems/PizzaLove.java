package GeeksForGeeks.Problems;

public class PizzaLove {
    int maxPizza(int n, int[] arr)
    {
        // code here.
        if(arr.length == 1) return arr[0];
        if(arr.length == 0) return 0;
        int sol = 0;
        int p = 0;
        int q = arr[0];
        for(int i = 1; i < arr.length; i++){
            sol = Math.max(arr[i] + p, q);
            p = q;
            q = sol;
        }
        return sol;
    }
}
