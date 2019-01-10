/**
260. Single Number III
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
Find the two elements that appear only once.
*/

/**
According to the previous question, we can use XOR to filter out all the elements which appear twice.
Once we get the result diff, we know it at least has one set bit, since there are two distinct number in the array.
We use this set bit to split the array into two sets, because those two distinct number will end up in the different set,
because at that bit they won't have the same value (XOR's definition). And all the rest number doesn't matter, because there
are two of each number, and they will end up in the same set, and the xor result will be 0.
*/

class Solution {
    public int[] singleNumber(int[] nums) {
        //use XOR to filter out the elements which appear twice
        int diff = 0;
        for(int num : nums){
            diff ^= num;
        }
        diff &= -diff;      //because of two's complement form of negative number, get the last set bit
        int[] res = new int[2];
        for(int num : nums){
            //because diff is the xor result of two different numbers
            //it at least has one set bit
            //for these two number, the value of that one set bit must be different according to xor's definition
            //so that we can distinguish them
            if((num & diff) == 0){
                res[0] ^= num;
            }else{
                res[1] ^= num;
            }
        }
        return res;
    }
}
