/**
* 206.Reverse Linked List
* Reverse a singly linked list.
* Input: 1->2->3->4->5->NULL
* Output: 5->4->3->2->1->NULL
*/

/**
* Recursively and Iteratively
*/

//Iteratively
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode newHead = head, temp = head.next;
        while(temp != null){
            ListNode next = temp.next;
            temp.next = newHead;
            newHead = temp;
            temp = next;
        }
        head.next = null;
        return newHead;
    }
}

//Recursively
class Solution {
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}

/**
* 92. Reverse Linked List II
* Reverse a linked list from position m to n. Do it in one-pass.
* Note: 1 ≤ m ≤ n ≤ length of list.
* Input: 1->2->3->4->5->NULL, m = 2, n = 4
* Output: 1->4->3->2->5->NULL
*/

/**
* Just be careful when m == 1, then there's no frontMark
*/

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) return head;
        ListNode temp = head;
        int count = 1;
        while(count < m-1 && temp != null){
            temp = temp.next;
            count++;
        }
        ListNode frontMark = temp, newHead = m == 1 ? temp : temp.next;
        temp = newHead.next;
        count = m == 1 ? count+1 : count+2;
        while(count <= n && temp != null){
            ListNode next = temp.next;
            temp.next = newHead;
            newHead = temp;
            temp = next;
            count++;
        }
        if(m != 1){
            frontMark.next.next = temp;
            frontMark.next = newHead;
            return head;
        }else{
            head.next = temp;
            return newHead;
        }
    }
}
