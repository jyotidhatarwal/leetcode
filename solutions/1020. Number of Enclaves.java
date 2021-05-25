class Solution {
    public int numEnclaves(int[][] grid) {
        int ans =0;
        int m = grid.length;
        int n = grid[0].length;
        
        // travel on boundary and change 1 to 0
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 || j== 0 || i== m-1 || j == n-1){
                    change1to0(grid,i,j,m,n);
                }
            }
        }
        
        // calculate the 1's which are not connected to boundary
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    ans++;
                }
            }
        }
        return ans;
    }
    private void change1to0(int[][]grid,int i,int j,int m,int n){
        if(i <0 || j <0 || i>= m || j >=n || grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
        change1to0(grid,i+1,j,m,n);
        change1to0(grid,i-1,j,m,n);
        change1to0(grid,i,j+1,m,n);
        change1to0(grid,i,j-1,m,n);
    }
}
