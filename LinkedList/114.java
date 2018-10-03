/**
* 114. Flatten Binary Tree to Linked List
* Given a binary tree, flatten it to a linked list in-place.
* For example, given the following tree:
*     1
*    / \
*   2   5
*  / \   \
* 3   4   6
* The flattened tree should look like:
* 1
*  \
*   2
*    \
*     3
*      \
*       4
*        \
*         5
*          \
*           6
*/

/**
* use recursion, I found the best way to deal with tree problem is recursion
* the recursion method return the last node of the flatten Binary tree
* we just need to decide the 4 situations, first when the node is a leaf, second when the node only has left or right child
* the last one is normal situation, the node has both right and left child.
*/

class Solution {
    public void flatten(TreeNode root) {
        if(root != null) help(root);
    }
    public TreeNode help(TreeNode node){
        if((node.left == null && node.right == null)){
            return node;
        }else if(node.left == null){
            TreeNode temp = help(node.right);
            return temp;
        }else if(node.right == null){
            TreeNode temp = help(node.left);
            node.right = node.left;
            node.left = null;
            return temp;
        }else{
            TreeNode temp1 = help(node.left);
            TreeNode temp2 = help(node.right);
            temp1.right = node.right;
            node.right = node.left;
            node.left = null;
            return temp2;
        }
    }
}
