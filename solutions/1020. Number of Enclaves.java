class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // travel on boundary and change 1 to 0
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j== 0 || i == n-1 || j== m-1){
                    dfs(grid,i,j,n,m);
                }
            }
        }
        int ans =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    ans++;
                }
            }
        }
        return ans;
        
    }
    private void dfs(int[][] grid,int i,int j,int n,int m){
        if(i < 0 || j <0 || i>= n || j >= m || grid[i][j] == 0){
            return;
        }
        grid[i][j] =0;
        dfs(grid,i-1,j,n,m);
        dfs(grid,i,j-1,n,m);
        dfs(grid,i,j+1,n,m);
        dfs(grid,i+1,j,n,m);
    }
}
