/**
226. Invert Binary Tree
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
*/

/**
This can be solved using DFS & Recursion. This also can be solved using Level Order Traversal which is the simplest way.
*/

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        //level order traversal
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
        return root;
    }
}
