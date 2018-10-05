/**
* 105. Construct Binary Tree from Preorder and Inorder Traversal
* Given preorder and inorder traversal of a tree, construct the binary tree.
* Note:
* You may assume that duplicates do not exist in the tree.
* For example, given
* preorder = [3,9,20,15,7]
* inorder = [9,3,15,20,7]
* Return the following binary tree:
*    3
*   / \
*  9  20
*    /  \
*   15   7
*/

/**
* The basic idea is here:
*Say we have 2 arrays, PRE and IN.
* Preorder traversing implies that PRE[0] is the root node.
* Then we can find this PRE[0] in IN, say it's IN[5].
* Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
* Recursively doing this on subarrays, we can build a tree out of it
*
* The most important thing is to understand the in-order and pre-order's definitions
*/

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildHelper(0,0,inorder.length-1,preorder,inorder);
    }
    
    public TreeNode buildHelper(int preIndex, int inStart, int inEnd, int[] preorder, int[] inorder){
        if(preIndex > preorder.length - 1 || inStart > inEnd){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preIndex]);
        int inIndex = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(node.val == inorder[i]){
                inIndex = i;
                break;
            }
        }
        node.left = buildHelper(preIndex+1,inStart,inIndex-1,preorder,inorder);
        node.right = buildHelper(preIndex+inIndex-inStart+1,inIndex+1,inEnd,preorder,inorder);
        return node;
    }
}
