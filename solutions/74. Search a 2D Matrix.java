class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       
        int row = binarySearchRowSelect(matrix,target);
       if(row == -1) return false;
       boolean isFound = binarySearch(matrix,row,target);
       
       return isFound;
    }
    public  int binarySearchRowSelect(int[][]matrix,int target){
        int low = 0;
        int hi = matrix.length-1;
        int lastColumn = matrix[0].length-1;
        while(low <= hi){
            int mid = (low + hi) /2;
            
            if(matrix[mid][0] <= target && target <= matrix[mid][lastColumn]){
                return mid;
            }else if(matrix[mid][0] < target){
                low = mid +1;
            }else{
                hi = mid -1;
            }
        }
        return -1;
    }
    
     public  boolean binarySearch(int[][]matrix,int row,int target){
         int low = 0;
         int hi = matrix[0].length-1;
         while(low <= hi){
             int mid = (low + hi) /2;
             if(matrix[row][mid] == target){
                 return true;
             }else if(matrix[row][mid] < target){
                 low = mid +1;
             }else{
                 hi = mid-1;
             }
         }
         return false;
     }
}
