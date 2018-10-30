/**
128.Longest consecutive sequence
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*/

/**
Using Union-find. I use a map to record index->value in the input. So when creating uf, I use index as id, but when I am doing
operations like union or find, I actually look at the value through the map.
When ecounter a value in the input, I will look for value-1 and value+1, if either of them is in the map, then connect current
index(id) to their(id), update the max using sz[find(id)], since sz[root] is the size of the set that root is the parent node.
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer,Integer> map = new HashMap();       //record value->index
        UF uf = new UF(nums.length);
        int max = 1;
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                continue;
            }
            map.put(nums[i],i);
            if(map.containsKey(nums[i]-1)){
                int id = map.get(nums[i]-1);
                uf.union(i,id);
            }
            if(map.containsKey(nums[i]+1)){
                int id = map.get(nums[i]+1);
                uf.union(i,id);
            }
            max = Math.max(max,uf.getSizeOfSet(uf.find(i)));
        }
        return max;
    }
}

public class UF {
    private int[] id;           //parents array
    private int[] sz;           //record the size of the set which each vertex belongs to
    

    public UF(int n){
        id = new int[n];
        sz = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }


    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int find(int p){
        //find the root of the set which p belongs to
        while(p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }
    
    public int getSizeOfSet(int id){
        return sz[id];
    }

    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if(i == j) return;
        //link the root with smaller size to the root with greater size
        if(sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }else{
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
