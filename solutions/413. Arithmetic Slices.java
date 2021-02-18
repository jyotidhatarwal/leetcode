class Solution {
    public int numberOfArithmeticSlices(int[] A) {
      
        int dp=0;
        int ans=0;
        for(int i=2;i<A.length;i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                dp = dp+1;
                ans += dp;
            }else{
                dp=0;
            }
        }
        return ans;
    }
}
/*  This is better approach than previous as it's space complexity is O(1)    */
