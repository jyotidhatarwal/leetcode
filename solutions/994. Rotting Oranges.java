class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh_orange =0;
        LinkedList<int[]> que = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    fresh_orange++;
                }else if(grid[i][j] == 2){
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
                if(x-1 >=0 && grid[x-1][y] == 1){
                    grid[x-1][y] =2;
