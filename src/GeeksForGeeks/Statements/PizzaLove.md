There are N number of Pizza bowls and in each bowl there are ai pizzas . You can eat pizzas from any bowl but you cannot eat pizzas from two consecutive bowls . Find the maximum number of pizzas you can eat.

Input:
First line of input contains a positive integer T denoting number of test cases. For each test case, first line contains N denoting number of pizza bowls . Second line contains N space seperated integers where each of them denotes number of pizzas in ith bowl.

Output:
For each test case print the maximum number of pizzas you can eat.

Your Task:
This is a functional problem you don't need to take input just complete the function maxPizza() which accepts two parameters an integer N (number of bowls) and an array arr (contains number of pizzas in ith bowl) and returns the maximum number pizzas you can eat.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= ai <= 109

Example:
Input:
2
5
1 2 3 4 5
5
5 3 4 11 2
Output:
9
16

Explanation:
Testcase1: you can eat pizzas from bowl number 1, 3 and 5.
Testcase2: you can eat pizzas from bowl number 1 and 4.