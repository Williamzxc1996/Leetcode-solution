/**
* 80.Remove Duplicates from Sorted Array I and II and K
* Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
* Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
*/

/**
* General method for k equals to any number, in this case k == 2
* I should remove the duplicates in-place, so I keep two pointers i and j, i denotes the index of the array after removal, j denotes the current array.
* I keep an int count to count how many times does a number appear in the array, once it is greater than k I skip the number, and I only reset it to 1 when find a new number.
* I only put the valid number to index i, so after the traveral, i would be the length of new array.
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int k = 2, i = 1, j = 1, count = 1;
        while(j < nums.length){
            if(nums[j] != nums[j-1]){
                count = 1;
                nums[i++] = nums[j];
            }else{
                if(count < k){
                    nums[i++] = nums[j];
                    count++;
                }
            }
            ++j;
        }
        return i;
    }
}
