class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int ans =0;
        int i=0;
        int j=0;
        int prevValidCount =0;
        for(j=0;j<A.length;j++){
            if(A[j] >= L && A[j] <= R ){
                ans += (j-i+1);
                prevValidCount = (j-i+1);
            }else if(A[j] > R){
                i = j+1;
                prevValidCount =0;
            }else{
                ans += prevValidCount;
            }
        }
        return ans;
    }
}
