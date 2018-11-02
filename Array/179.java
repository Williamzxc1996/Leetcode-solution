/**
179.Largest Number
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.
*/

/**
Notice that if s1+s2 > s2+s1, then s1 need to be in the larger digits.
Basically, just need to overload the comparator
*/

class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "0";
        String[] temp = new String[nums.length];
        for(int i = 0; i < temp.length; i++){
            temp[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(temp, new Comparator<String>(){
            public int compare(String a, String b){
                String t1 = a + b;
                String t2 = b + a;
                return t2.compareTo(t1);
            }
        });
        if(temp[0].equals("0")) return "0";
        StringBuilder res = new StringBuilder();
        for(String s : temp){
            res.append(s);
        }
        return res.toString();
    }
}
