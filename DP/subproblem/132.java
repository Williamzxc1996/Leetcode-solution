/**
132.Palindrome Partitioning II
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/

/**
I got two ideas.

First is let dp[i][j] denotes the minimum number of palindrome in s.substring(i,j).
so s.substring(i,j) is a palindrome then dp[i][j] = 1, otherwise  dp[i][j] = Math.min(dp[i][k]+dp[k+1][j]) i<=k<=j-1.
(Just partition once, try to decide which way will yeild minimum number of palindrome out of all the possibilities)

Seconde is let dp[i] denotes the minimum cut of s.substirng(0,i). So dp[i] = Math.min(dp[i], dp[j-1] + 1), if s.substring(j,i) is a palindrome.
The base case is dp[i] = i, since the maximum cut is when you cut every single character.

Apparently the first one is O(n^3) so I got TLE, but I still think it is a good idea.
*/

class Solution {
    public int minCut(String s) {
        if(s == null) return 0;
        int[] dp = new int[s.length()];          //dp[i] denotes the minimum cuts for s.substring(0,i)
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            dp[i] = i;
            for(int j = 0; j <= i; j++){
                if(s.charAt(j) == s.charAt(i) && (j+1 > i-1 || isPalindrome[j+1][i-1])){
                    isPalindrome[j][i] = true;
                    dp[i] = Math.min(dp[i],j-1 >= 0 ? dp[j-1]+1 : 0);
                }
            }
        }
        return dp[s.length()-1];
    }
}
