/**
220. Contains Duplicate III
Given an array of integers, find out whether there are two distinct indices i and j in the array 
such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
*/

/**
Use the original solution that maintain a map which has a size of k, and add the buckets.
*/
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //using the thought of buckets, num within a certain range will end up in the same bucket
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //remap, because if num is -1 it will also end up in bucket 0 which is wrong
            //therefore, remapping just let num starts at 0
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            //let the bucket size be t+1
            long bucket = remappedNum / ((long) t + 1);
            //the bucket of current num might already be in the map, or it is qualified, just the other num it maps to is in
            //adjacent bucket
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            //maintain the map size
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}
