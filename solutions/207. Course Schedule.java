class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         // step-1 --> make a graph from prerequiste
         ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            graph.get(v).add(u);    // because b is necessary for a 
        }
        // step-2 --> kahn's Algorithm
         int[] indegree = new int[numCourses];
                int[] ans = new int[numCourses];
                for(int i=0;i<numCourses;i++){
                    for(int nbrs:graph.get(i)){
                        indegree[nbrs]++;
                    }
                }
                LinkedList<Integer> que = new LinkedList<>();
                for(int i=0;i<numCourses;i++){
                    if(indegree[i] == 0){
                        que.addLast(i);
                    }
                    
                }
                int count =0;
                while(que.size() > 0){
                    int rem = que.removeFirst();
                    ans[count] = rem;
                    count++;
                    for(int nbr : graph.get(rem)){
                        indegree[nbr]--;
                        if(indegree[nbr] == 0){
                            que.addLast(nbr);
                        }
                    }
                }
                if(count == numCourses){
                    return true;
                }else{
                    return false;
                }
    }
}
