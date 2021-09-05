class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRow(matrix);
    }
    private void transpose(int[][]matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    private void reverseRow(int[][]matrix){
        for(int row =0;row<matrix.length;row++){
            int left = 0;
            int right = matrix.length-1;
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
