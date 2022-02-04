package LeetCode.ExploreCard.Challenge.ThirtyDayChallenge.May2020;

public class FindTownJudge {
    /*
        MAIN POINT TO REMEMBER
        indegree of a vertex is the number of directed edges going into it.
        outdegree of a vertex is the number of directed edges going out of it.
        Judge has in degree of N - 1 and out degree of 0
     */
    /*
        Runtime: 3 ms, faster than 80.16%
        Memory Usage: 47 MB, less than 100.00%
     */
    public int findJudge(int N, int[][] trust){
        if(trust.length < N - 1) return -1; // optimization
        int[] out_degree = new int[N + 1];
        int[] in_degree = new int[N + 1];
        for(int[] t : trust){
            out_degree[t[0]]++;
            in_degree[t[1]]++;
        }
        for(int i = 1; i <= N; i++){
            if(out_degree[i] == 0 && in_degree[i] == N - 1) return i;
        }
        return -1;
    }
        /* above code with single array
        * Runtime: 3 ms, faster than 80.16%
        * Memory Usage: 46.9 MB, less than 100.00%
        * */
    public int findJudge2(int N, int[][] trust){
        if(trust.length < N - 1) return -1; // optimization
        int[] degree = new int[N + 1];
        for(int[] t : trust){
            degree[t[0]]--;
            degree[t[1]]++;
        }
        for(int i = 1; i <= N; i++){
            if(degree[i] == N - 1) return i;
        }
        return -1;
    }

    /*
        This is a code written like the problem "find celebrity"
        The below algorithm has a cost of O(N) in "find celebrity"
        problem but here it has O(E). HOW? :(
        Runtime: 5 ms, faster than 36.09%
        Memory Usage: 47.5 MB, less than 100.00%
     */
    public int findJudge3(int N, int[][] trust) {
        int[][] relation = new int[N + 1][N + 1];
        for(int[] t : trust){ // E times for loop
            relation[t[0]][t[1]] = 1;
        }
        int judge = 1;
        for(int i = 1; i <= N; i++){ // N times for loop
            if(trusts(relation, judge, i)) judge = i;
        }
        if(isJudge(relation, judge, N)) return judge;
        return -1;
    }

    public boolean isJudge(int[][] relation, int judge, int N){
        for(int i = 1; i <= N; i++){
            if(judge == i) continue;
            if(trusts(relation, judge, i) || !trusts(relation, i, judge)) return false;
        }
        return true;
    }
    public boolean trusts(int[][] relation, int a, int b){
        return relation[a][b] == 1;
    }

    public static void main(String[] args){
        FindTownJudge fj = new FindTownJudge();
        //int N = 2; int[][] trust = {{1, 2}};
        int N = 3; int[][] trust = {{1,3},{2,3},{3,1}};
        int judge = fj.findJudge(N, trust);
        System.out.print(judge);
    }
}
