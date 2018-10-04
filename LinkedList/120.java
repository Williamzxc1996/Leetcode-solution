/**
* 120. Triangle
* Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
* For example, given the following triangle
* [
*      [2],
*     [3,4],
*    [6,5,7],
*   [4,1,8,3]
* ]
* The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*/

/**
* Use DP, dp[i][j] denotes if I chose triangle.get(i).get(j), what would be the min path sum.
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size(), res = Integer.MAX_VALUE;
        if(m == 0) return 0;
        int[][] dp = new int[m][m];
        dp[0][0] = triangle.get(0).get(0); 
        for(int i = 1; i < m; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0) dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                else if(j == i) dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                else dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + triangle.get(i).get(j);
            }
        }
        for(int j = 0; j < m; j++){
            res = Math.min(res,dp[m-1][j]);
        }
        return res;
    }
}

/**
* we can do reversely, and reduce the space complexity to O(N)
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for(int i = triangle.size()-1; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                if(i == triangle.size() - 1) dp[j] = triangle.get(i).get(j);
                else{
                    dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
                }
            }
        }
        return dp[0];
    }
}
