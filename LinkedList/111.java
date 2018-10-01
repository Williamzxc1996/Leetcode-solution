/**
* 111. Minimum Depth of Binary Tree
* Given a binary tree, find its minimum depth.
* The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
* Note: A leaf is a node with no children.
*/

/**
* Using DFS is very easy. But one thing need to be careful about is to decide whether the node is a leaf.
* If it has right child but doesn't have left child, then it still isn't a leaf.
* that is what "return rightD == 0 ? leftD + 1 : rightD + 1;" for.
*/

class Solution {
    public int minDepth(TreeNode root) {
        return DFS(root);
    }
    public int DFS(TreeNode root){
        if(root == null)
            return 0;
        int leftD = DFS(root.left);
        int rightD = DFS(root.right);
        if(rightD == 0 || leftD == 0){
            return rightD == 0 ? leftD + 1 : rightD + 1;
        }else{
            return Math.min(rightD,leftD) + 1;
        }
    }
}
