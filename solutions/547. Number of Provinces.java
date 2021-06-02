class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count =0;
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                dfs(isConnected,visited,i);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] isConnected,boolean[]visited,int curr){
        
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[curr][i] == 1 && visited[i] == false){
                visited[i] = true;
                dfs(isConnected,visited,i);
            }
        }
    }
}
