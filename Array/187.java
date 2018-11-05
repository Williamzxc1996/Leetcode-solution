/**
187. Repeated DNA Sequences
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]
*/

/**
Because its substrings, so just traverse s once find all the substrings with length 10, and use hashmap to record historical
information and comapre.
*/

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> map = new HashMap();
        List<String> res = new LinkedList();
        for(int i = 0; i <= s.length()-10; i++){
            String key = s.substring(i,i+10);
            if(!map.containsKey(key)){
                map.put(key,1);
            }else{
                if(map.get(key) == 1){
                    res.add(key);
                    map.put(key,-1);
                }
            }
        }
        return res;
    }
}
