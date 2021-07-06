class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseEveryRow(matrix);
    }
    private void transpose(int[][]matrix){
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                swap(matrix,i,j);
            }
        }
    }
    private void swap(int[][]matrix,int i,int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
    private void reverseEveryRow(int[][]matrix){
        int n = matrix.length;
      
        for(int row=0;row<n;row++){
             int left =0;
             int right = n-1; 
            while(left < right){
                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;
                left++;
                right--;
            }
        }
    }
}
