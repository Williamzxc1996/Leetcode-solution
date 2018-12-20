/*
209.Minimum Size Subarray Sum
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. 
If there isn't one, return 0 instead.
*/

/*
First, brutal force
*/

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int j = i, sum = 0;
            while(sum < s && j < nums.length){
                sum += nums[j];
                j++;
            }
            if(sum >= s){
                res = Math.min(res,j-i);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

/*
Second, Binary Search. Noticed that all the element in the array is positive, therefore the sum is strictly increasing.
*/
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int[] sum = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                sum[i] = nums[i];
            }else{
                sum[i] = sum[i-1] + nums[i];
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < sum.length; i++){
            int start = i;
            //find s+sum[i-1] in subarray(i,sum.length)
            int end;
            
            if(i > 0) end = binarySearch(sum,start,s+sum[i-1]);
            else end = binarySearch(sum,start,s);
            
            if(end < sum.length) res = Math.min(res,end-start+1);
        }
        return res == Integer.MAX_VALUE ? 0 : res; 
    }
    
    public int binarySearch(int[] sum, int i, int target){
        int start = i, end = sum.length-1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(sum[mid] == target) return mid;
            else if(sum[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }
}

/*
Third, Linear. Use O(2n) method. Take advantange of only positive elements, so the sum will always increase.
*/
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = 0, sum = 0, res = Integer.MAX_VALUE;
        while(end < nums.length){
            while(sum < s && end < nums.length){
                sum += nums[end++];
            }
            if(sum < s) break;
            else{
                while(sum >= s){
                    sum -= nums[start++];
                }
                res = Math.min(res, end-start+1);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
