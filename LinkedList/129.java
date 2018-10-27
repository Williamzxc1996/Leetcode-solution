/**
129.Sum root to leaf number
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
*/

/**
So intuitively, I need to use DFS to traverse all the root to leaf paths, and sum them up and get the answer.
The only problem here is how to construct the number while DFS is going further since I don't know the length of this path.
Therefore, I use StringBuilder to record all the number (String), and after I run DFS, I use another for-loop to sum up all
the numbers (Strings).
*/

class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        List<String> res = new LinkedList();
        DFS(root,res,new StringBuilder());
        int sum = 0;
        for(String num : res){
            sum += Integer.parseInt(num);
        }
        return sum;
    }
    
    public void DFS(TreeNode root, List<String> res, StringBuilder temp){
        temp.append(root.val);
        if(root.left == null && root.right == null){
            res.add(temp.toString());
        }
        if(root.left != null) DFS(root.left,res,temp);
        if(root.right != null) DFS(root.right,res,temp);
        temp.deleteCharAt(temp.length()-1);
    } 
}
