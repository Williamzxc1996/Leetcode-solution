/**
137.Single Number II
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
*/

/**
The idea is to keep two int "one" and "two" to track the number appear once and twice.

So if a number is currently not in one, it has two possibilities:
First, it is not in "two" either, so it's the first time. I add it to "one";
Second, it is in "two", I don't add it to "one" (because I want to delete it from "two, since it's the third time it appears).
If a number is currently in one, it's absolutely not in two according to my logic. I use xor to delete it from one.
Therefore, one = (nums[i] ^ one) & ~two, means I only add a number to one when it's the first time it appears. And delete it if
it's already in one.

Same thing for two.

At last, the two will be zero, since every number appear twice will appear the third time. one will be the number, because only
that number actually appear once.
*/

class Solution {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for(int i = 0; i < nums.length; i++){
            one = (nums[i] ^ one) & ~two;
            two = (nums[i] ^ two) & ~one;
        }
        return one;
    }
}
