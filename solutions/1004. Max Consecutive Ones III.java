class Solution {
    public int longestOnes(int[] A, int K) {
        int ans =0;
        int zerosCount =0;
        int j = -1;
        for(int i=0;i<A.length;i++){
            if(A[i] ==0){
                zerosCount++;
            }
            while(zerosCount >K){
                j++;
                if(A[j] == 0){
                    zerosCount--;
                }
            }
            int length = i-j;
            if(length > ans){
                ans = length;
            }
        }
        return ans;
    }
}
