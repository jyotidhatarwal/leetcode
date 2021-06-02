class Solution {
    int[][] dirs = {{-1,0},{0,-1},{0,1},{1,0}};
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        
        // 0 --> x coordinate
        // 1 --> y coordinate
        // 2 --> height or time
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
          return  a[2] - b[2];
        });
       pq.add(new int[]{0,0,grid[0][0]});
       visited[0][0] = true;
        int ans =0;
        while(pq.size() > 0){
            int size = pq.size();
            while(size-- > 0){
                int[] rem = pq.remove();
                int i = rem[0];
                int j = rem[1];
                ans = Math.max(ans,rem[2]);
                if(i == n-1 && j == n-1){
                    return ans;
                }
                for(int[] dir : dirs){
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(x >=0 && y >= 0 && x < n && y < n && visited[x][y] == false){
                        visited[x][y] = true;
                        pq.add(new int[]{x,y,Math.max(ans,grid[x][y])});
                    }
                    
                }
            }
        }
        return 0;
    }
}
