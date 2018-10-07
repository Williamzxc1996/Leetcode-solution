/**
* 208. Implement Trie (Prefix Tree)
* Implement a trie with insert, search, and startsWith methods.
* You may assume that all inputs are consist of lowercase letters a-z.
* All inputs are guaranteed to be non-empty strings.
*/

class TrieNode{
    public boolean isWord;
    public char val;
    public TrieNode[] children = new TrieNode[26]; //a-z
    
    public TrieNode(){};
    public TrieNode(char a){
        val = a;
    }  
}
class Trie {
    public TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++){
            char a = word.charAt(i);
            if(temp.children[a - 'a'] == null) temp.children[a -'a'] = new TrieNode(a);
            temp = temp.children[a - 'a'];
        }
        temp.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++){
            char a = word.charAt(i);
            if(temp.children[a - 'a'] == null) return false;
            temp = temp.children[a - 'a'];
        }
        return temp.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(int i = 0; i < prefix.length(); i++){
            char a = prefix.charAt(i);
            if(temp.children[a - 'a'] == null) return false;
            temp = temp.children[a - 'a'];
        }
        return true;
    }
}
