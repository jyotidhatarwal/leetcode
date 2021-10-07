class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][]visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == word.charAt(0) && dfs(board,i,j,visited,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][]board,int i,int j,boolean[][]visited,String word,int idx){
        if(idx == word.length() -1){
            return true;
        }
        visited[i][j] = true;
        // top
        if(i > 0 && visited[i-1][j] == false && board[i-1][j] == word.charAt(idx+1) && dfs(board,i-1,j,visited,word,idx+1)){
            return true;
        }
        // left
        if(j > 0 && visited[i][j-1] == false && board[i][j-1] == word.charAt(idx+1) && dfs(board,i,j-1,visited,word,idx+1)){
            return true;
        }
        
        // right
        if(j < board[0].length-1 && visited[i][j+1] == false && board[i][j+1] == word.charAt(idx+1) && dfs(board,i,j+1,visited,word,idx+1)){
            return true;
        }
        // bottom
        if(i < board.length-1 && visited[i+1][j] == false && board[i+1][j] == word.charAt(idx+1) && dfs(board,i+1,j,visited,word,idx+1)){
            return true;
        }
        visited[i][j] = false;
        return false;
        
    }
}
