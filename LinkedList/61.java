/**
* 61. Rotate List
* Given a linked list, rotate the list to the right by k places, where k is non-negative.
*/

/**
* Find the new head for the linkedlist and change the order of the linkedlist
* Be careful that k might be larger than the length of linkedlist
* Be careful with the cases like k == 0, head == null.
*/

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int len = 1;
        ListNode end = head;
        while(end.next != null){
            end = end.next;
            len++;
        }
        k = k % len;
        if(k == 0) return head;
        ListNode temp = head;
        int count = 0;
        while(count != len-k-1){
            temp = temp.next;
            count++;
        }
        ListNode newHead = temp.next;
        temp.next = null;
        end.next = head;
        return newHead;
    }
}
