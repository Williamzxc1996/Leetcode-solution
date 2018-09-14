/**
* 86. Partition List
* Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
* You should preserve the original relative order of the nodes in each of the two partitions.
* Input: head = 1->4->3->2->5->2, x = 3
* Output: 1->2->2->4->3->5
*/

/**
* keep two linkedlist
* first one is use to maintain the number less than x, second on is use to maintain the rest
* at last concat two linkedlist and set the next of the last element in second linkelist to null
*/

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(0), head2 = new ListNode(0), temp1 = head1, temp2 = head2;
        while(head != null){
            if(head.val < x){
                head1.next = head;
                head1 = head;
            }else{
                head2.next = head;
                head2 = head;
            }
            head = head.next;
        }
        head1.next = temp2.next;
        head2.next = null;
        return temp1.next;
    }
}
