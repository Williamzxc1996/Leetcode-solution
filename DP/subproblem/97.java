/**
97.Interleaving String
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
*/

/**
Use dynamic programming. dp[i][j] denotes if s1.substring(1,i) and s2.substring(1,j) can build up s3.substring(1,i+j), the reason
I use this recurrence relationship is because of the rule of interleaving string.
There are two circumstances: First, s1.charAt(i) == s3.charAt(i+j) && dp[i-1][j] == true, then dp[i][j] = true;
                             Second, s2.charAt(j) == s3.charAt(i+j) && dp[i][j-1] == true, then dp[i][j] = true;
*/

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true; //base case
        for(int i = 1; i <= s2.length(); i++){
            dp[0][i] = dp[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
        }
        for(int i = 1; i <= s1.length(); i++){
            dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
