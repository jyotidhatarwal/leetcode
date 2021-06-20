class Solution {
    private boolean isSubIsland = true;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        int island =0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j] == 1 && visited[i][j] == false){
                    dfs(grid1,grid2,i,j,m,n,visited);
                    if(isSubIsland == true){
                        island++;
                    }
                    isSubIsland = true;
                    
                }
            }
        }
        return island;
    }
    
    private void dfs(int[][] grid1,int[][]grid2,int i,int j,int m,int n,boolean[][] visited){
        if(i<0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0 || visited[i][j] == true){
            return;
        }
        if(grid1[i][j] != grid2[i][j]){
            isSubIsland = false;
        }
        visited[i][j] = true;
        dfs(grid1,grid2,i-1,j,m,n,visited);    // top
        dfs(grid1,grid2,i,j-1,m,n,visited);    // left
        dfs(grid1,grid2,i,j+1,m,n,visited);    // right
        dfs(grid1,grid2,i+1,j,m,n,visited);    // bottom
    }
}
