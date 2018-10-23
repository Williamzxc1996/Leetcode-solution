/**
115.Distinct Subsequences

Given a string S and a string T, count the number of distinct subsequences of S which equals T.
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
*/

/**
dp[i][j] denotes how many distinct subsequences the substring(0,j) of S equal the substring(0,i) of T.
So when S.charAt(j) != T.charAt(i), we only have to consider dp[i][j-1], the dinstinct subsequence we've already got.
However, when S.charAt(j) == T.charAt(i), not only we have to consider dp[i][j-1], but also we should consider dp[i-1][j-1],
since all the subsequences of S.substring(0,j-1) equal the T.substring(0,i-1) plus S.charAt(j) could be T.substring(0,i).
*/

class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()+1][s.length()+1];
        for(int i = 0; i <= s.length(); i++){
            dp[0][i] = 1; //base case
        }
        //the other base case is dp[i][0] = 0
        for(int i = 1; i <= t.length(); i++){
            for(int j = 1; j <= s.length(); j++){
                if(s.charAt(j-1) == t.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
