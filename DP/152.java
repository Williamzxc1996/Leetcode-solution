/**
152. Maximum Product Subarray
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

/**
Let imax denotes the max product end with nums[i], imin denotes the min product end with nums[i].
When encounter a negative number, swap imax and imin, cuz imin * negative number could become imax and imax * negative number
could become imin.
*/
class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int imax = res, imin = res;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = imin;
                imin = imax;
                imax = temp;
            }
            
            imax = Math.max(nums[i],nums[i]*imax);
            imin = Math.min(nums[i],nums[i]*imin);
            
            res = Math.max(res,imax);
        }
        return res;
    }
}
