class Solution {
    public int lengthOfLIS(int[] nums) {
        int[]dp = new int[nums.length];
        int ans =0;
        for(int val : nums){
            int i =0;
            int j = ans;
            while(i < j){
                int mid = i + (j-i)/2;
                if(dp[mid] < val){
                    i = mid+1;
                }else{
                    j = mid;
                }
            }
            dp[i] = val;
            if(i == ans){
                ans++;
            }
        }
        return ans;
    }
}
