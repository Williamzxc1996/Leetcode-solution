/**
* 113. Path Sum II
* Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
* Note: A leaf is a node with no children.
*/

/**
* Just change the Path Sum a little bit in order to record the path. I think it's basically backTracking.
*/

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList();
        List<Integer> temp = new LinkedList();
        if(root == null && sum == 0) return res;
        DFS(root,sum,res,temp);
        return res;
    }
    public void DFS(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp){
        if(root == null && sum == 0){
            res.add(new LinkedList(temp));
            return;
        }
        if(root == null && sum != 0){
            return;
        }
        temp.add(root.val);
        if(root.left == null && root.right == null){
            //leaf node
            DFS(root.left,sum-root.val,res,temp);
        }else{
            if(root.left != null) DFS(root.left,sum-root.val,res,temp);
            if(root.right != null) DFS(root.right,sum-root.val,res,temp);
        }
        temp.remove(temp.size()-1);
        return;
    }
}
