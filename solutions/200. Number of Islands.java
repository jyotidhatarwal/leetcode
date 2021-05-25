class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
              dfs(grid,visited,i,j,m,n);
                ans++;
             }
                }
            }
         return ans;
        }
       
    
    private int dfs(char[][]grid,boolean[][] visited,int i,int j,int m,int n){
        
        if(i < 0 || i >= m || j <0 || j>= n || grid[i][j] == '0' || visited[i][j] == true){
            return 0;
        }
        visited[i][j] = true;
        
        dfs(grid,visited,i+1,j,m,n);
        dfs(grid,visited,i-1,j,m,n);
        dfs(grid,visited,i,j+1,m,n);
        dfs(grid,visited,i,j-1,m,n);
        
        return 1;
    }
}
