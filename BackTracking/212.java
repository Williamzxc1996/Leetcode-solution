/**
* 212. Word Search II
* Given a 2D board and a list of words from the dictionary, find all words in the board.
* Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
* Example:
* Input: 
* words = ["oath","pea","eat","rain"] and board =
* [
*   ['o','a','a','n'],
*   ['e','t','a','e'],
*   ['i','h','k','r'],
*   ['i','f','l','v']
* ]
* Output: ["eat","oath"]
* Note:
* You may assume that all inputs are consist of lowercase letters a-z.
*/

/**
* BackTracking + Trie
* If for every word in the list, we run one backTracking on the board the time complexity won't suffice
* If using trie, we can just run one backTracking on the board and check all the word in the list
*/

class TrieNode{
    public TrieNode[] next = new TrieNode[26];
    public String word;
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList();
        TrieNode root = new TrieNode();
        buildTrie(root,words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                backTrackingOnBoard(board,i,j,root,res);
            }
        }
        return res;
    }
    public void backTrackingOnBoard(char[][] board, int i, int j, TrieNode root, List<String> res){
        char c = board[i][j];
        if(board[i][j] == '#' || root.next[c-'a'] == null) return;  //this character has no match in word-list or this position
        if(root.next[c-'a'].word != null){
            //found one string
            res.add(root.next[c-'a'].word);
            root.next[c-'a'].word = null;   //avoid duplicate
        }
        board[i][j] = '#'; //avoid visit again
        // four directions
        if(i > 0) backTrackingOnBoard(board,i-1,j,root.next[c-'a'],res);
        if(j > 0) backTrackingOnBoard(board,i,j-1,root.next[c-'a'],res);
        if(i < board.length - 1) backTrackingOnBoard(board,i+1,j,root.next[c-'a'],res);
        if(j < board[0].length - 1) backTrackingOnBoard(board,i,j+1,root.next[c-'a'],res);
        board[i][j] = c;
    }
    public void buildTrie(TrieNode root, String[] words){
        //TrieNode temp = root; not here, every new word should be built from the root!!!
        for(String word : words){
            TrieNode temp = root;
            for(char c : word.toCharArray()){
                if(temp.next[c-'a'] == null) temp.next[c-'a'] = new TrieNode();
                temp = temp.next[c-'a'];
            }
            temp.word = word;
        }
    }
}

