/**
* 77.Combinations
* Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
* Input: n = 4, k = 2
* Output:
* [
*  [2,4],
*  [3,4],
*  [2,3],
*  [1,2],
*  [1,3],
*  [1,4],
* ]
*/

/**
* Use k == 0 to add the result
* Use backTracking(...,i+1) to avoid result like [4,1]
* Use n-start >= k-1 to terminate the for-loop immediately when it won't produce any valid result
*/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList();
        backTracking(res,new ArrayList(), n, k, 1);
        return res;
    }
    
    public void backTracking(List<List<Integer>> res, List<Integer> temp, int n, int k, int start){
        if(k == 0){
            res.add(new ArrayList(temp));
            return;
        }
        for(int i = start; i <= n && n-start >= k-1; i++){
            temp.add(i);
            backTracking(res,temp,n,k-1,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
