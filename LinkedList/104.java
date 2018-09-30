/**
* 104. Maximum Depth of Binary Tree
* Given a binary tree, find its maximum depth.
* The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/


//Recursion
class Solution {
    public int maxDepth(TreeNode root) {
        return maxSubDepth(root);
    }
    
    public int maxSubDepth(TreeNode node){
        if(node == null)
            return 0;
        else
            return Math.max(maxSubDepth(node.left),maxSubDepth(node.right)) + 1;
    }
}

//BFS same as 102, traverse the whole tree, use levelSize to distingush different level, return level
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            level++;
            for(int i = 0; i < levelSize; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
        }
        return level;
    }
}
