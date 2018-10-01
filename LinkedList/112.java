/**
* 112. Path Sum
* Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
* Note: A leaf is a node with no children.
*/

/**
* Using DFS, still check every node before operation, because if it's a leaf it will have a different operation.
* DFS(root.left, sum-root.val) comes from backTracking.
*/

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null && sum == 0) return false;
        else return DFS(root,sum);
    }
    
    public boolean DFS(TreeNode root, int sum){
        if(root == null && sum == 0)
            return true;
        if(root == null && sum != 0){
            return false;
        }
        if(root.left == null && root.right == null){
            //leaf node
            return DFS(root.left,sum-root.val);
        }else{
            boolean bLeft = false, bRight = false;
            if(root.left != null) bLeft = DFS(root.left,sum-root.val);
            if(root.right != null) bRight = DFS(root.right,sum-root.val);
            return bLeft || bRight;
        }
        
    }
}
