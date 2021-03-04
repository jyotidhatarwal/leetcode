class Solution {
    public void rotate(int[][] matrix) {
        
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                swap(matrix,i,j);
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length/2;j++){
            reverse(matrix,i,j);
        }
        }
        
    }
    private void swap(int[][]matrix,int i,int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
    private void reverse(int[][] matrix,int i,int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][matrix.length - j-1];
        matrix[i][matrix.length-j-1] = temp;
    }
}
