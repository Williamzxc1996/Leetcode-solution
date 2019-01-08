/**
221.Maximal Square
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
*/

/**
Using DP. dp[i][j] denotes the width of the maximal square ending with matrix[i][j].
Be careful about the case:
[["0","0","0","1"],
["1","1","0","1"],
["1","1","1","1"],
["0","1","1","1"],
["0","1","1","1"]]
dp[2][1] = 2, but when calculating dp[3][2], I should take this into consideration.
*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0 ; j < matrix[0].length; j++){
                if(matrix[i][j] == '1') dp[i][j] = 1;
                if(dp[i][j] == 1 && i >= 1 && j >= 1 && dp[i-1][j-1] != 0){
                    int last = dp[i-1][j-1];
                    int width = 1;
                    for(int k = 1; k <= last; k++){
                        if(matrix[i][j-k] != '1' || matrix[i-k][j] != '1'){
                            width = k;
                            break;
                        }
                        if(k == last) width = k+1;
                    }
                    dp[i][j] = width;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}
