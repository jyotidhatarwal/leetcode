class Solution {
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        LinkedList<int[]> que = new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    que.add(new int[]{i,j});
                }else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        while(que.size() > 0){
            int size = que.size();
           
                int[] curr = que.remove();
                
                for(int[] dir : dirs){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(x < 0 || x >= mat.length || y < 0|| y >= mat[0].length || mat[x][y] <= mat[curr[0]][curr[1]] +1) continue;
                    que.add(new int[]{x,y});
                    mat[x][y] = mat[curr[0]][curr[1]] +1;
                }
            
        }
        return mat;
    }
}
