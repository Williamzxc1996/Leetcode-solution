/**
* 96. Unique Binary Search Trees
* Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
* Input: 3
* Output: 5
* Explanation:
* Given n = 3, there are a total of 5 unique BST's:
* 
*    1         3     3      2      1
*     \       /     /      / \      \
*      3     2     1      1   3      2
*     /     /       \                 \
*    2     1         2                 3
*/

/**
* Let dp[i] denotes the total number of BSTs whose root is i. Therefore the answer should be dp[n].
* Let f(i,n) denotes the total number of BSTs whose root is i, where n is the total number of vertices.
* Therefore f(i,n) = dp[i-1] * dp[n-i], because all the number less than i can only be i's left children, all the number
* greater than i can only be i's right children. Although dp[n-i] doesn't really mean the number greater than i, but the
* thing that will affect the number of BST is how many numbers are there, the value doesn't affect the result.
* Therefore dp[n] = f(1,n) + f(2,n) + ... + f(n,n) = dp[0]*dp[n-1] + dp[1]*dp[n-2] + ... dp[n-1]*dp[0].
*/

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;dp[0] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
