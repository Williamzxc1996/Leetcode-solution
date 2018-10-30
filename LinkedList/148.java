/**
148.Sort List
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
*/

/**
Using divide and conquer.
First, using fast and slow pointer find middle node.
Then recursively sort the left part(before middle node, include middle) and right part(after middle node).
Then merge the two halves together.
Be carefore about the base case, when there's no node or there's only one node.
And the time complexity is O(nlogn)
*/

class Solution {
    public ListNode sortList(ListNode head) {
        //split the current list to two halves
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        ListNode itr = new ListNode(0);
        head = itr;
        while(right != null && left != null){
            if(right.val < left.val){
                itr.next = right;
                ListNode temp = right.next;
                right.next = null;
                right = temp;
            }else{
                itr.next = left;
                ListNode temp = left.next;
                left.next = null;
                left = temp;
            }
            itr = itr.next;
        }
        if(right != null){
            itr.next = right;
        }
        if(left != null){
            itr.next = left;
        }
        return head.next;
    }
}
