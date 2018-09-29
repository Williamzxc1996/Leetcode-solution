/**
* 102.Binary Tree Level Order Traversal
* Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
*/

/**
* Use the BFS framework, but using a levelSize to keep track which TreeNodes are belong to current level.
*/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> res = new LinkedList();
        if(root == null) return res;
        queue.add(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> level = new LinkedList();
            for(int i = 0; i < levelSize; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
                level.add(temp.val);
            }
            res.add(level);
        }
        return res;
    }
}
