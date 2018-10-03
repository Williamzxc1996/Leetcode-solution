/**
* 109. Convert Sorted List to Binary Search Tree
* Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
* For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/

/**
* Also use recursion. Use fast and slow to make sure slow stop at the right place.
*/

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        else return toBST(head,null);
    }
    
    public TreeNode toBST(ListNode head, ListNode tail){
        ListNode fast = head; //move two steps every time
        ListNode slow = head; //move one step every time by the time when fast reaches tail, slow will be in the middle
        if(head == tail)
            return null;
        while(fast != tail && fast.next != tail){
            //if has odd node, fast will end up at tail, else fast will end up at last node before tail
            fast = fast.next.next; //we want fast to stop at tail
            slow = slow.next;
        }
        TreeNode node = new TreeNode(slow.val);
        node.left = toBST(head,slow);
        node.right = toBST(slow.next,tail);
        return node;
    }
}
