class Solution {
    public void rotate(int[][] matrix) {
        // step-1 transpose
        transpose(matrix);
        // step-2 reverse every row
        reverseRow(matrix);
    }
    private void transpose(int[][] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                swap(arr,i,j);
            }
        }
    }
    private void swap(int[][] arr,int i,int j){
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }
    private void reverseRow(int[][] arr){
        int n = arr.length;
        for(int row =0;row<n;row++){
            int left =0;
            int right = n-1;
            while(left < right){
                int temp = arr[row][left];
                arr[row][left] = arr[row][right];
                arr[row][right] = temp;
                left++;
                right--;
            }
        }
    }
}
