/**
* 94.Binary Tree Inorder Traversal
* Given a binary tree, return the inorder traversal of its nodes' values.
* Input: [1,null,2,3]
*   1
*    \
*     2
*    /
*   3
*
* Output: [1,3,2]
*/

/**
* Using Stack to record the prev node.
*/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
