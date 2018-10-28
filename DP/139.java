/**
139.Word Break
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
*/

/**
I use dynamic programming strategy. Let dp[i] denotes if s.substring(0,i)(inclusive) can be divide then dp[i] is true,
otherwise dp[i] is false.
The base case is that if s.substring(0,i) is in the wordDict, then dp[i] is true, otherwise its base case is false.
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){
                String key = s.substring(j,i+1);
                if(wordDict.contains(key)){
                    dp[i] = dp[i] || (j == 0 ? true : dp[j-1]);
                    if(dp[i]) break;
                }
            }
        }
        return dp[s.length()-1];
    }
}
