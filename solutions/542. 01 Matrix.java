class Solution {
    int[][] dirs = {{-1,0},{0,-1},{0,1},{1,0}};
    
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
       LinkedList<int[]> que = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    que.add(new int[]{i,j});
                }else{
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        while(que.size() > 0){
            int size = que.size();
            
                int[] rem = que.removeFirst();
                int i = rem[0];
                int j = rem[1];
                for(int[] dir : dirs){
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(x < 0 || y < 0 || x >= mat.length || y >= mat[0].length || mat[x][y] <= mat[i][j]+1) continue;
                    que.add(new int[]{x,y});
                    mat[x][y] = mat[i][j] +1;
                    
                }
            
        }
        return mat;
    }
}
