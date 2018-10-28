/**
140.Word Break II
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
*/

/**
First I used pure backTracking and got TLE. So I add memorizaiton.
In the for-loop, I am very careful because I want to cover all the possibilities and also I don't want substring() method
to throw exceptions. So I put i from 1 to s.length()-1, which will satisfy substring() method. However, by doing this,
I overlook one possibilities, that the string s itself is in the wordDict, so I put another if outside the loop.
And the memorizaiton also record the location of the string (not very obviously) since when I call backTracking recursively, I 
use s.substring(i), that from index i to the end. So it will only use memorization if the s at same position is in the map.
*/





class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String,List<String>> map = new HashMap();
        return backTracking(s,wordDict,map);
    }
    
    public List<String> backTracking(String s, List<String> wordDict, Map<String,List<String>> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        
        List<String> res = new ArrayList();
        if(wordDict.contains(s)){
            res.add(s);
        }
        
        for(int i = 1; i < s.length(); i++){
            String key = s.substring(0,i);
            if(wordDict.contains(key)){
                List<String> temp = backTracking(s.substring(i),wordDict,map);
                for(String candidate : temp){
                    String s_new = key + " " + candidate;
                    res.add(s_new);
                }
            }
        }
        map.put(s,res);
        return res;
    }
}
