class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[]result = new int[A.length];
        int i=0;
        for(int j=0;j<A.length;j++){
            if(A[j]%2==0){
                result[i] = A[j];
                i++;
            }
        }
        for(int j=0;j<A.length;j++){
            if(A[j] %2==1){
                result[i] = A[j];
                i++;
            }
        }
        return result;
    }
}
