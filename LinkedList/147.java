/**
147.Insertion Sort List
Sort a linked list using insertion sort.
*/

/**
If we are sorting nums[i] the insertion sort will go from index i-1 to 0 to find the right place. 
However, we can using index to access linkedlist randomly, so I choose to go from head to the node before current node.
That's why I use a p point to head, and each time I start at p.
*/

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode h = new ListNode(0);
        h.next = head;
        while(head.next != null){
            ListNode temp = h;
            boolean swap = false;
            while(temp.next != head.next){
                //head is fiexed, move temp
                if(head.next.val <= temp.next.val){
                    //swap
                    ListNode mark = head.next;
                    head.next = head.next.next;
                    mark.next = temp.next;
                    temp.next = mark;
                    swap = true;
                    break;
                }
                temp = temp.next;
            }
            if(!swap) head = head.next;
        }
        return h.next;
    }
}
