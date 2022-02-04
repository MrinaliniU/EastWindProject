package MyInterviews.Microsoft.Mock;
/*
Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one
celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does
not know any of them.

Now you want to find out who the celebrity is or verify that there is not one.
The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information
of whether A knows B. You need to find out the celebrity (or verify there is not one)
 by asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A knows B.
Implement a function int findCelebrity(n). There will be exactly one celebrity if he/she is in the party.
Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.

Note:

The directed graph is represented as an adjacency matrix, which is an n x n matrix
where a[i][j] = 1 means person i knows person j while a[i][j] = 0 means the contrary.
Remember that you won't have direct access to the adjacency matrix.

Input: graph = [
  [1,1,0],
  [0,1,0],
  [1,1,1]
]
Output: 1
Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j, otherwise graph[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 because both 0 and 2 know him but 1 does not know anybody.

Input: graph = [
  [1,0,1],
  [1,1,0],
  [0,1,1]
]
Output: -1
Explanation: There is no celebrity.
 */
public class FindCelebrity {
    /*
        [[1,0],[0,1]]
        [[1,0,1],[1,1,0],[0,1,1]]
     */
    public int findCelebrity(int n) {
        int celebrityCandidate = 0;
        for(int i = 0; i < n; i++){
            if(knows(celebrityCandidate, i)) celebrityCandidate = i;
        }
        if(isCelebrity(celebrityCandidate, n)) return celebrityCandidate;
        return -1;
    }
    public boolean isCelebrity(int celebrityCandidate, int n){
        for(int i = 0; i < n; i++){
            if(i == celebrityCandidate) continue;
            if(knows(celebrityCandidate, i) || !knows(i, celebrityCandidate)) return false;
        }
        return true;
    }
    public boolean knows(int a, int b){
        int[][] relation1 = {{1,0,1},{1,1,0},{0,1,1}}; // n = 3; celeb = -1
        int[][] relation2 = {{1,0},{0,1}};// n = 2; celeb = -1
        int[][] relation3 = {{1,1,0},{0,1,0},{1,1,1}}; // n = 3; celeb = 1
        return knows(relation3, a, b);
    }
    public boolean knows(int[][] relation, int a, int b){
        return (relation[a][b] == 1);
    }
    public static void main(String[] args){
        FindCelebrity p = new FindCelebrity();
        int n = 3;
        int celeb = p.findCelebrity(n);
        System.out.println("Celeb in Party " + celeb);
    }
}
