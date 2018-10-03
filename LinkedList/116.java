/**
* 116. Populating Next Right Pointers in Each Node
Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
Example:

Given the following perfect binary tree,

     1
   /  \
  2    3
 / \  / \
4  5  6  7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL
*/

/**
* I thinking too hard to come up with a recursive solution, but I overlook the iterative solution, which is much more easier to come up with.
* I used two pointer prev and level, because the tree is perfect, so I used prev to check if next level exists, if exists I used level to denotes current level
* and move level from prev to null at current level to connect the node in next level
*/

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode prev = root, level;
        while(prev.left != null){
            //next level exists
            level = prev;
            while(level != null){
                level.left.next = level.right;
                if(level.next != null) level.right.next = level.next.left;
                level = level.next;
            }
            prev = prev.left;
        }
    }
}
