/**
* 117. Populating Next Right Pointers in Each Node II
* The same as 117 but the tree is not perfect
*/

/**
* Keep three pointer, head is use to find the first node in next level, prev is use to record the curr node need to find its next in next level
* cur is the node in current level, I use it to traverse the current level
*/

public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = null; //the first node in next level;
        TreeLinkNode prev = null; //the node need to find its next in next level;
        TreeLinkNode cur = root; //cur level;
        while(cur != null){
            //traverse this level
            while(cur != null){
                //left child
                if(cur.left != null){
                    if(prev != null){
                        prev.next = cur.left;
                    }else{
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                //right child
                if(cur.right != null){
                    if(prev != null){
                        prev.next = cur.right;
                    }else{
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next; //move to next node in current level
            }
            //move to next level
            cur = head;
            prev = null;
            head = null;
        }
    }
}
