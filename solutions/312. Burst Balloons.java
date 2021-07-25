//  DP APPROACH
​
class Solution {
    public int maxCoins(int[] nums) {
        int[]arr = new int[nums.length+2];
        arr[0] =1;
        arr[arr.length-1] = 1;
        for(int i=0;i<nums.length;i++){
            arr[i+1] = nums[i];
        }
        return burst(arr,0,arr.length-1,new int[arr.length][arr.length]); 
        // arr, start point , end point (both points are exclusive)
    }
    private int burst(int[]arr,int left,int right,int[][]dp){
        if(left+1 == right){
            return 0;
        }
        if(dp[left][right] != 0){
            return dp[left][right];
        }
        int ans =0;
        for(int i=left+1;i<right;i++){
            int tempLeft = burst(arr,left,i,dp);
            int tempRight = burst(arr,i,right,dp);
            int currAns = tempLeft + tempRight + arr[left]*arr[i]*arr[right];
            ans = Math.max(ans,currAns);
            dp[left][right] = ans;
        }
        return ans;
    }
}
