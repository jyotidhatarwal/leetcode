class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0){
            return result;
        }
        int topBoundary =0;
        int bottomBoundary = matrix.length-1;
        int leftBoundary = 0;
        int rightBoundary = matrix[0].length-1;
        
        while(true){
            for(int i=leftBoundary;i<=rightBoundary;i++){
                result.add(matrix[topBoundary][i]);
            }
            topBoundary++;
            if(leftBoundary > rightBoundary || topBoundary > bottomBoundary){
                break;
            }
            for(int i = topBoundary;i<=bottomBoundary;i++){
                result.add(matrix[i][rightBoundary]);
            }
            rightBoundary--;
            if(leftBoundary > rightBoundary || topBoundary > bottomBoundary){
                break;
            }
            for(int i=rightBoundary;i>=leftBoundary;i--){
                result.add(matrix[bottomBoundary][i]);
            }
            bottomBoundary--;
            if(leftBoundary > rightBoundary || topBoundary > bottomBoundary){
                break;
            }
            for(int i=bottomBoundary;i>=topBoundary;i--){
                result.add(matrix[i][leftBoundary]);
            }
            leftBoundary++;
            if(leftBoundary > rightBoundary || topBoundary > bottomBoundary){
                break;
            }
        }
        return result;
    }
   
}
