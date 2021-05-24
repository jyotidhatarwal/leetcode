class Solution {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        if(n == 0 && m== 0) return grid;
        if(grid[r0][c0] == color) return grid;
        dfs(grid,r0,c0,grid[r0][c0],visited,color,n,m);
        return grid;
    }
    private void dfs(int[][] grid,int row,int col,int val,boolean[][]visited,int color,int n,int m){
        if(row <0 || row > n-1 || col <0 || col > m-1 || grid[row][col] != val || visited[row][col]){
            return;
        }
        visited[row][col] = true;
        boolean border = false;
        if(row == 0 || row == n-1 || col == 0 || col == m-1 || grid[row+1][col] != val || grid[row-1][col] != val || grid[row][col+1] != val || grid[row][col-1] != val){
            border = true;
        }
        
        dfs(grid,row+1,col,val,visited,color,n,m);
         dfs(grid,row-1,col,val,visited,color,n,m);
         dfs(grid,row,col+1,val,visited,color,n,m);
         dfs(grid,row,col-1,val,visited,color,n,m);
        if(border){
            grid[row][col] = color;
        }
    }
}
