/**
* 107. Binary Tree Level Order Traversal II
* Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
*/

/**
* Just use the addFirst method with the same BFS strategy.
*/

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList();
        Queue<TreeNode> queue = new LinkedList();
        if(root == null) return res;
        queue.add(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> level = new LinkedList();
            for(int i = 0; i < levelSize; i++){
                TreeNode temp = queue.poll();
                level.add(temp.val);
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            res.addFirst(level);
        }
        return res;
    }
}
