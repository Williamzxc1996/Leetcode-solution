/**
* 90. Subsets II
* Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
* Note: The solution set must not contain duplicate subsets.
* Input: [1,2,2]
* Output:
* [
*   [2],
*   [1],
*   [1,2,2],
*   [2,2],
*   [1,2],
*   []
* ]
*/

/**
* subsequence you can skip elements but you must keep the original order
* subarray means contiguous subsequence
* subset contains any possible combinations of original set
* In this problem the most difficult part is to avoid duplicate subsets
* You can use list.contains() to check but the time cost is "huge"
* The best way is to let every duplicate number be next to each other, which I use sort
* Then inside the for-loop in function backTracking I check if nums[i] == nums[i-1] every time to avoid the duplicate
* If I don't sort, this solution can't deal with situation like [4,4,4,4,1,4] it'll give two [4], [4,4] and [4,4,4]
*/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> temp = new ArrayList();
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length; i++){
            backTracking(res,temp,nums,0,0,i);
        }
        return res;
    }
    public void backTracking(List<List<Integer>> res, List<Integer> temp, int[] nums, int start, int k, int len){
        if(k == len){
            res.add(new ArrayList(temp));
            return;
        }
        for(int i = start; i < nums.length && nums.length - i >= len - k; i++){
            if(i == start || nums[i] != nums[i-1]){
                temp.add(nums[i]);
                backTracking(res,temp,nums,i+1,k+1,len);
                temp.remove(temp.size()-1);
            }
        }
    }
}
