class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length ==0 || matrix[0].length ==0){
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[m*n];
        int i=0;
        int row=0;
        int col=0;
        boolean up = true;
        
        
        
        // if we are going from top to down
        while(row<m && col <n){
        if(up){
        while(row >0 && col < n-1){
            arr[i++] = matrix[row][col];
            row--;
            col++;
            
        }
        arr[i++] = matrix[row][col];
            if(col==n-1){
                row++;
            }else{
                col++;
            }
            
            
        }else{// from bottom to up
            while(col >0 && row<m-1){
                arr[i++] = matrix[row][col];
                row++;
                col--;
            }
            arr[i++] = matrix[row][col];
            if(row==m-1){
                col++;
            }else{
                row++;
            }
            
        }
        up =! up;
         
        
        }
        return arr;
    }
}
