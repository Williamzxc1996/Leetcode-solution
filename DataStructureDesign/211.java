/*
211. Add and Search Word - Data structure design
Design a data structure that supports the following two operations:
void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
*/

/*
Use a Trie data structure to keep the words. When searching, because of the '.', use backtracking.
*/
class WordDictionary {
    TrieNode tTree;
    /** Initialize your data structure here. */
    public WordDictionary() {
        tTree = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        tTree.add(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null || word.length() == 0) return false;
        return helpSearch(word,tTree);
    }
    
    public boolean helpSearch(String word, TrieNode t){
        char ch = word.charAt(0);
        if(ch == '.'){
            for(int i = 0; i < 26; i++){
                if(t.dic[i] == null){
                    continue;
                }else{
                    if(word.length() == 1){
                        if(t.dic[i].isWord == true) return true;
                        else continue;
                    }else{
                        if(helpSearch(word.substring(1),t.dic[i])) return true;
                    }
                }
            }
        }else{
            int index = ch - 'a';
            if(t.dic[index] == null) return false;
            else {
                if(word.length() == 1){
                    if(t.dic[index].isWord == true) return true;
                }else{
                    if(helpSearch(word.substring(1),t.dic[index])) return true;
                }
            }
        }
        return false;
    }
}

class TrieNode{
    TrieNode[] dic = new TrieNode[26];
    boolean isWord;
    
    public TrieNode(){
        isWord = false;
    }
    
    public void add(String word){
        if(word.length() == 0) isWord = true;
        else{
            int index = word.charAt(0) - 'a';
            if(dic[index] == null) dic[index] = new TrieNode();
            dic[index].add(word.substring(1));
        }
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
