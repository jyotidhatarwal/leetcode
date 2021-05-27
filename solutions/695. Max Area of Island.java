class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m == 0 || n ==0) return 0;
        int[] count = new int[1];
        int max =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    count[0] = 0;
                    dfs(grid,i,j,m,n,count);
                    max = Math.max(count[0],max);
                }
            }
        }
        return max;
    }
    private void dfs(int[][] grid,int x,int y,int m,int n,int[] count){
        if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0){
            return;
        }
        grid[x][y] = 0; 
        count[0]++;
        dfs(grid,x+1,y,m,n,count);
        dfs(grid,x-1,y,m,n,count);
        dfs(grid,x,y+1,m,n,count);
        dfs(grid,x,y-1,m,n,count);
    }
}
