class Solution {
    
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    
    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        LinkedList<int[]> que = new LinkedList<>();
        boolean found = false;  // found 1
        // step-1 marking visited for all 1's
        for(int i=0;i<m;i++){
            if(found == true){
                break;
            }
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    dfs(grid,visited,i,j,que,dirs);
                    found = true;
                    break;
                }
            }
        }
        // step-2 calculating flips
        int step =0;
        while(que.size() > 0){
            int size = que.size();
            while(size-- > 0){
                int[] curr = que.remove();
               
                for(int[] dir : dirs){
                     int x = curr[0] + dir[0];
                     int y = curr[1] + dir[1];
                    if(x >=0 && y>=0 && x < grid.length && y < grid[0].length && visited[x][y] == false){
                     if(grid[x][y] == 1){
                         return step;
                     }
                        que.add(new int[]{x,y});
                        visited[x][y] = true;
                    }
                   
                }
            }
            step++;
        }
        return -1;
        
    }
    private void dfs(int[][] grid,boolean[][] visited,int i, int j, LinkedList<int[]> que,int[][] dirs){
        if(i < 0 || j <0 || i >= grid.length || j >= grid[0].length || visited[i][j] == true || grid[i][j] == 0){
            return;
        }
        visited[i][j] = true;
        que.add(new int[]{i,j});
        
        for(int[] dir : dirs){
            dfs(grid,visited,i+dir[0],j+dir[1],que,dirs);
        }
    }
