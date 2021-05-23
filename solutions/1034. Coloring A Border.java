class Solution {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        if(grid[r0][c0] == color){
            return grid;
        }
        
        dfs(grid,r0,c0,grid[r0][c0],visited,color,n,m);
        return grid;
    }
    private void dfs(int[][]grid,int row,int col,int val,boolean[][]visited,int color,int n,int m){
        if(row > n-1 || row <0 ||  col > m-1 || col <0 || grid[row][col] != val || visited[row][col]){
            return;
        }
        visited[row][col] = true;
        boolean border = false;
        if(row==0 || col== 0 ||row == n-1 || col == m-1 || grid[row+1][col] != val || grid[row-1][col] != val || grid[row][col +1 ] != val || grid[row][col-1] != val ){
            border = true;
        }
        
        dfs(grid,row+1,col,val,visited,color,n,m);  // top
        dfs(grid,row-1,col,val,visited,color,n,m);  // bottom
        dfs(grid,row,col+1,val,visited,color,n,m);  // right
        dfs(grid,row,col-1,val,visited,color,n,m);  // left
        
        if(border){
            grid[row][col] = color;
        }
    }
}
