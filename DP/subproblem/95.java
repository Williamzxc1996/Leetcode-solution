/**
* 95. Unique Binary Search Trees II
* Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
* Input: 3
* Output:
* [
*   [1,null,3,2],
*   [3,2,null,1],
*   [3,1,null,null,2],
*   [2,1,3],
*   [1,null,2,null,3]
* ]
*/

/**
* I use divide-conquer to solve this problem. Although I can use DP solution in accordance with 94, but it still has to involve with Recursion
* because dp[n-i] is not the real value of the number, in 96 I only care about the number of BST, but in here the real value matters.
* The gist is the same as 96.
*/

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return (new ArrayList());
        return generateSubTrees(1,n);
    }
    public List<TreeNode> generateSubTrees(int start, int end){
        List<TreeNode> res = new ArrayList();
        if(end < start){
            res.add(null);
            return res;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> leftSubTrees = generateSubTrees(start,i-1);
            List<TreeNode> rightSubTrees = generateSubTrees(i+1,end);
            for(TreeNode left : leftSubTrees){
                for(TreeNode right : rightSubTrees){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
