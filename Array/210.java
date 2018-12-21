/*
210.Course Schedule
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
*/

/*
Method 1 BFS.
*/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //build adjacent list
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] result = new int[numCourses];
        int count = 0;
        Queue<Integer> queue = new LinkedList();
        //find courses without prerequisites
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0) {
                queue.add(i);
                result[count++] = i;
            }
        }
        while(!queue.isEmpty()){
            int pre = queue.poll();
            for(int next : adj.get(pre)){
                indegree[next]--;
                if(indegree[next] == 0) {
                    queue.add(next);
                    result[count++] = next;
                }
            }
        }
        return count == numCourses ? result : new int[0];
    }
}


/*
Method 2 DFS.
*/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //build adjacent list
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        List<Integer> result = new ArrayList();
        dfs(result,indegree,adj);
        //System.out.println(result.size());
        if(result.size() != numCourses){
            return new int[0];
        }else{
            int[] res = new int[numCourses];
            int count = 0;
            for(int num : result){
                res[count++] = num;
            }
            return res;
        }
    }
    
    public void dfs(List<Integer> result, int[] indegree, List<List<Integer>> adj){
        //check indegree, find 0 in-degree courses
        int index = -1;
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0) {
                index = i;
                indegree[i] = -1;
                break;
            }
        }
        if(index == -1){
            return;
        }
        result.add(index);
        for(int next : adj.get(index)){
            indegree[next]--;
        }
        dfs(result,indegree,adj);
        return;
    }
}
