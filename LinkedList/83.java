/**
* 83.Remove Duplicates from Sorted List
* Given a sorted linked list, delete all duplicates such that each element appear only once.
*/

/**
* Just be careful with the last one it should point to null
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode prev = head, temp = head;
        while(temp.next != null){
            if(temp.val == temp.next.val){
                temp = temp.next;
            }else{
                temp = temp.next;
                prev.next = temp;
                prev = temp;
            }
        }
        prev.next = null; //deal with the last one no matter what prev.next should point to null
        return head;
    }
}
