/**
* 101. Symmetric Tree
* Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
*/

/**
* Recursively and iteratively
*/

//Recursion
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        else return isSymmetricRecursive(root.left,root.right);
    }
    
    public boolean isSymmetricRecursive(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return left == right;
        }else if(left.val != right.val){
            return false;
        }
        return isSymmetricRecursive(left.left,right.right) && isSymmetricRecursive(left.right,right.left);
    }
}

//Iteration
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> leftTree = new Stack();
        Stack<TreeNode> rightTree = new Stack();
        TreeNode leftChild = root.left;
        TreeNode rightChild = root.right;
        while(leftChild != null && rightChild != null){
            while(leftChild != null && rightChild != null && leftChild.val == rightChild.val){
                leftTree.push(leftChild);
                rightTree.push(rightChild);
                leftChild = leftChild.left;
                rightChild = rightChild.right;
            }
            if(leftChild == null && rightChild == null){
                while(!leftTree.isEmpty() && !rightTree.isEmpty() && leftChild == null && rightChild == null){
                    leftChild = leftTree.pop().right;
                    rightChild = rightTree.pop().left;
                }
                //I don't have to check if leftTree and rightTree are empty at the same time, they surely are, because they push
                //together
            }else{
                return leftChild == rightChild;
            }
        }
        return leftChild == rightChild;
    }
}
