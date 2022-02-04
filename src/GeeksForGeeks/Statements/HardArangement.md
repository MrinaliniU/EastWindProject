You are given two array A[] and B[]. Your task is to arrange elements of first array according to the order defined by second array. The first array contains integers which represent heights of persons and second array defines how many persons in front of him should stand with height greater than that person.
Example:-
A: 3 2 1
B: 0 1 1
It means in front of a person of height 3 there should be no person standing, for the person of height 2 there will be one person in front of him who has greater height than him, similar to the last person of height 1, there will be only one person in front of him with height greater than him. Your task to arrange them in the order defined.
The output will be:
C: 3 1 2

Input:
First line of each testcase contains an integer number T, denoting the number of testcases. First line of each testcase contains an integer number N, denoting the size of the array, next line contains N space separated integers the array A[] denoting the height of the persons and last line of the test case contains the arrangement array B[].

Output:
Print the array C showing the arrangement in a new line. Array C is initially empty.

Your Task:
You don't need to read input or print output. Your task is to complete the function arrange() and use the inputs as passed in the arguments and fill the array C[] with the new output.

Constraints:
1<=T<=30
2<=N<=103
1<=A[i]<=106
1<=B[i]<=N

Example:
Input:
2
3 
3 2 1
0 1 1
7
9 1 2 3 3 6 5
0 0 0 0 1 2 3

Output:
3 1 2
1 2 3 9 6 5 3