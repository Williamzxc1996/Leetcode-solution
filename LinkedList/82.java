/**
* 82.Remove Duplicates from Sorted List II
* Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
* Input: 1->2->3->3->4->4->5
* Output: 1->2->5
*/

/**
* Be careful with what to return, maybe the original head is deleted because of duplicate
* Be careful with where to put the prev, it should point to the last valid node
* Be careful with how to deal with "head.val != head.next.val", it may have consecutive duplicate numbers
* Be careful with the last number
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode prev = new ListNode(0), newHead = prev;
        boolean duplicate = false;
        while(head.next != null){
            if(head.val == head.next.val){
                head = head.next;
                duplicate = true;
            }else{
                if(duplicate == false){
                    prev.next = head;
                    prev = head;
                }
                head = head.next;
                duplicate = false;
            }
        }
        if(duplicate == false){
            prev.next = head;
        }else{
            prev.next = null;
        }
        return newHead.next;
    }
}
