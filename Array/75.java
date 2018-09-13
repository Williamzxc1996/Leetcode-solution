/**
* 75. Sort Colors
* Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
* Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
* Note: You are not suppose to use the library's sort function for this problem.
*/

/**
* keep three part [0,zero)/[zero,second)/[second,nums.length) to store 0, 1 and 2 respectively.
*/

class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, second = nums.length - 1;
        for(int i = 0; i <= second; i++){
            while(nums[i] == 2 && i < second){
                int temp = nums[second];
                nums[second--] = 2;
                nums[i] = temp;
            }
            while(nums[i] == 0 && i > zero){
                int temp = nums[zero];
                nums[zero++] = 0;
                nums[i] = temp;
            }
        }
    }
}
