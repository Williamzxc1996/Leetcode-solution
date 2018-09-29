/**
* 100. Same Tree
* Given two binary trees, write a function to check if they are the same or not.
* Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
*/

/**
* I use stack and pre-order traversal
*/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> tr1 = new Stack();
        Stack<TreeNode> tr2 = new Stack();
        while(p != null && q != null){
            while(p != null && q != null && p.val == q.val){
                tr1.push(p);
                tr2.push(q);
                p = p.left;
                q = q.left;
            }
            if(p == null && q == null){               
                while(!tr1.isEmpty() && !tr2.isEmpty() && p == null && q == null){
                    p = tr1.pop().right;
                    q = tr2.pop().right;
                }
                if(p == null && q == null){
                    if(tr1.isEmpty() && tr2.isEmpty()){
                        return true;
                    }else if((tr1.isEmpty() && !tr2.isEmpty()) || (!tr1.isEmpty() && tr2.isEmpty())){
                        return false;
                    }
                }
            }else{
                return false;
            }
        }
        if(q == null && p == null){
            return true;
        }else{
            return false;
        }
    }
}

/**
* Using recursion is neat!
*/

public boolean isSameTree(TreeNode p, TreeNode q) {
    if(p == null && q == null) return true;
    if(p == null || q == null) return false;
    if(p.val == q.val)
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    return false;
}
