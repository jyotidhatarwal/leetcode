class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        Arrays.fill(visited,-1);
         List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(dfs(graph,visited,i)){
                ans.add(i);
            }
        }
        return ans;
    }
    private boolean dfs(int[][]graph,int[] visited,int src){
        if(visited[src] != -1){
            if(visited[src] == 0) return true;
            else return false;
        }
        visited[src] = 1;
        for(int nbrs : graph[src]){
            boolean temp = dfs(graph,visited,nbrs);
            if(temp == false) return false;
        }
        visited[src] = 0;
        return true;
    }
}
