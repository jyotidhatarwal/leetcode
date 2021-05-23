class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(n== 0 && m == 0) return 0;
        LinkedList<int[]> que = new LinkedList<>();
        int fresh_orange =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    fresh_orange++;
                }else if(grid[i][j] == 2){  // adding position of rotten orange in que
                    que.add(new int[]{i,j});
                }
            }
        }
        if(fresh_orange ==0) return 0;
        int minute=0;
        while(que.size() > 0){
            int size = que.size();
            while(size-- > 0){
                int[] rem = que.removeFirst();
                int x = rem[0];
                int y = rem[1];
                if(x-1>=0 && grid[x-1][y] == 1){
                    grid[x-1][y] = 2;
                    que.add(new int[]{x-1,y});
                    fresh_orange--;
                }
                if(y-1>=0 && grid[x][y-1] == 1){
                    grid[x][y-1] = 2;
                    que.add(new int[]{x,y-1});
                    fresh_orange--;
                }
                if(x+1<grid.length && grid[x+1][y] == 1){
                    grid[x+1][y] = 2;
                    que.add(new int[]{x+1,y});
                    fresh_orange--;
                }
                if(y+1<grid[0].length && grid[x][y+1] == 1){
                    grid[x][y+1] = 2;
                    que.add(new int[]{x,y+1});
                    fresh_orange--;
                }
            }
            minute++;
        }
        return fresh_orange == 0 ? minute-1 : -1;
    }
}
