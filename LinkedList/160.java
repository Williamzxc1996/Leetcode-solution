/**
160.Intersection of two linked list
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

/**
My naive solution is to traverse one linkedList first, and record the node in a hashset.
Then traverse the second linkedList, if they intersect, then some of the node in linkedList two must already 
exist in the hashset, I return the first one, since I am traversing in order, the first one is the intersection node.
*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> check = new HashSet();
        while(headA != null){
            check.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if(check.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}

/**
The second method which do need extra space. For the two linkedList, it has two possibilities, first is that they don't intersect,
second is they intersect. And for both case, the length of the two linkedList might be different or the same.
The method use two iteration, if the two linkedList has the same length, the iteration will return the result at first iteration.
Otherwise it means the two linkedList will have length difference (the length difference is because the sub-linkedlist berfore intersection node), 
and at the first iteration, they will reach the end at different time, as soon as one reach the end(shorter one),
the method reset the node to the start of the longer linkedlist, then when the other reach the end(longer one),
reset the node to the start of the shorter linkedlist, and at this specific time the remain length of the two linkedlist
after two pointer will be the same.
*/

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode itrA = headA, itrB = headB;
        while(itrA != itrB){
            itrA = (itrA == null) ? headB : itrA.next;
            itrB = (itrB == null) ? headA : itrB.next;
        }
        return itrA;
    }
}
