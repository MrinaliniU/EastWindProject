package LeetCode.Algorithms.Medium;

public class FindCelebrity {

    /*
        Runtime: 19 ms, faster than 73.99%
        Memory Usage: 39.4 MB, less than 100.00%
     */
    public int findCelebrity(int n) {
        int celebCandidate = 0;
        for(int i = 0; i < n; i++){
            if(knows(celebCandidate, i)) celebCandidate = i;
        }
        if(isCeleb(celebCandidate, n)) return celebCandidate;
        return -1;
    }

    public boolean isCeleb(int candidate, int n){
        for(int i = 0; i < n; i++){
            if((candidate != i && knows(candidate, i)) || !knows(i, candidate)) return false;
        }
        return true;
    }
    public boolean knows(int i, int j){
        return true;
    }
}
