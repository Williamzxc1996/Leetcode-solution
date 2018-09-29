/**
* 104. Maximum Depth of Binary Tree
* Given a binary tree, find its maximum depth.
* The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/


//Recursion
class Solution {
    public int maxDepth(TreeNode root) {
        return maxSubDepth(root);
    }
    
    public int maxSubDepth(TreeNode node){
        if(node == null)
            return 0;
        else
            return Math.max(maxSubDepth(node.left),maxSubDepth(node.right)) + 1;
    }
}
