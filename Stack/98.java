/**
* 98. Validate Binary Search Tree
* Given a binary tree, determine if it is a valid binary search tree (BST).
* Assume a BST is defined as follows:
* The left subtree of a node contains only nodes with keys less than the node's key.
* The right subtree of a node contains only nodes with keys greater than the node's key.
* Both the left and right subtrees must also be binary search trees.
*/

/**
* Using prev and root to do the comparison.
* Be careful that root can be the right child of prev, also prev can be the left child of root.
* In the second case means that the leftSubTree of root(current) is a valid BST, and at this moment prev
* is the largest node in its leftSubTree.
*/

class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev != null && root.val <= prev.val)
                return false;
            prev = root;
            root = root.right;
        }
        return true;
  
