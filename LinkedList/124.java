/**
124.Binary Tree max path sum

Given a non-empty binary tree, find the maximum path sum.
For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:
Input: [1,2,3]
       1
      / \
     2   3
Output: 6

Example 2:
Input: [-10,9,20,null,null,15,7]
   -10
   / \
  9  20
    /  \
   15   7
Output: 42
*/

/**
* The first thing is to understand the question. It's asking us to find a path from start node to end node, from the start node go up and then go down, once it goes down it can't go up again.
* Therefore the path will have a highest node, which is also the lowest common ancestor for all the nodes in this path.
* So I write a recursive function, extendPath, which computes the max sum with current input as the lowest common ancestor.
* Then inside the function, it first recursive call the function to its left and right node, then update the max with,
* "left + current root + right" as a path if necessary. Then return the max extend Path, because we already consider the circumstance
* that current node is a common ancestor, now we should consider the circumstance that it's not a common ancestor.
*/

class Solution {
    int max;
    
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        extendPath(root);
        return max;
    }
    
    public int extendPath(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0,extendPath(root.left));
        int right = Math.max(0,extendPath(root.right));
        max = Math.max(max,left+right+root.val);
        return Math.max(right,left)+root.val;
    }
}
