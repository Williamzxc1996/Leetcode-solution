/**
* 106. Construct Binary Tree from Inorder and Postorder Traversal
* Given inorder and postorder traversal of a tree, construct the binary tree.
*/

/**
* The same as 105. Just need to find which part in postorder is for leftsubtree and which part is for rightsubtree
*/

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildHelper(postorder.length-1,0,inorder.length-1,inorder,postorder);
    }
    
    public TreeNode buildHelper(int postIndex, int inStart, int inEnd, int[] inorder, int[] postorder){
        if(postIndex < 0 || inStart > inEnd){
            return null;
        }
        TreeNode node = new TreeNode(postorder[postIndex]);
        int inIndex = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(node.val == inorder[i]){
                inIndex = i;
                break;
            }
        }
        node.left = buildHelper(postIndex-(inEnd-inIndex+1),inStart,inIndex-1,inorder,postorder);
        node.right = buildHelper(postIndex-1,inIndex+1,inEnd,inorder,postorder);
        return node;
    }
}
