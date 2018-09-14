/**
* 72. Edit Distance
* Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
* You have the following 3 operations permitted on a word:
*   1.Insert a character
*   2.Delete a character
*   3.Replace a character
*/

/**
* Let dp[i][j] denotes the minimum number of operations required to convert word1.substring(0,i) to word2.substring(0,j)(inlusive)
* Consider dp[i][j]
* Case 1: word1[i] == word2[j], then dp[i][j] = dp[i-1][j-1] because we don't need operation to convert
* Case 2: word1[i] != word2[j], then three options: insert, delete, replace
* Base case: dp[0][j] = j, dp[i][0] = i
*/

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i <= n; i++)
            dp[i][0] = i;
        for(int j = 1; j <= m; j++)
            dp[0][j] = j;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1])) + 1;
                }
            }
        }
        return dp[n][m];
    }
}
