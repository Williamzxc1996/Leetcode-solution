/**
199.Binary Tree Right Side View
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
*/

/**
Basically a binary tree level order traversal which is BFS, only add to result list when is the last node of current level
*/

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<Integer> res = new ArrayList();
        if(root == null) return res;
        queue.add(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            for(int i = 0; i < level; i++){
                TreeNode current = queue.poll();
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
                if(i == level-1) res.add(current.val);
            }
        }
        return res;
    }
}
