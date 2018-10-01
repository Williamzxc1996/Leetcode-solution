/**
* Balanced Binary Tree
* Given a binary tree, determine if it is height-balanced.
* For this problem, a height-balanced binary tree is defined as:
* a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/

/**
* I used a recursion with memo (top-down) to calculate the height of a node.
* And than I used BFS to traverse all the node in the tree, and check if the node satisfied height-balanced.
* It's easy to understand but the time complexity is O(N^2).
*/

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        else{
            Queue<TreeNode> queue = new LinkedList();
            queue.add(root);
            Map<TreeNode,Integer> map = new HashMap();
            while(!queue.isEmpty()){
                TreeNode temp = queue.poll();
                if(Math.abs(height(temp.left,map)-height(temp.right,map)) <= 1){
                    if(temp.left != null) queue.add(temp.left);
                    if(temp.right != null) queue.add(temp.right);
                }else{
                    return false;
                }
            }
            return true;
        }
    }
    public int height(TreeNode node, Map<TreeNode,Integer> map){
        if(node == null)
            return 0;
        if(map.containsKey(node))
            return map.get(node);
        else{
            int temp = 1 + Math.max(height(node.left,map),height(node.right,map));
            map.put(node,temp);
            return temp;
        }
    }
}

/**
* Using DFS reduce the time complexity to O(n)
*/

class Solution {
    public boolean isBalanced(TreeNode root) {
        return DFS(root) != -1;
    }
    public int DFS(TreeNode root){
        if(root == null)
            return 0;
        int leftHeight = DFS(root.left);
        int rightHeight = DFS(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1 || leftHeight == -1 || rightHeight == -1)
            return -1;
        else return Math.max(leftHeight,rightHeight) + 1;
    }
}
