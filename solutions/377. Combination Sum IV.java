class Solution {
    private int[]dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp,-1);
        dp[0] =1;
        return help(nums,target);
        
    }
    private int help(int[]nums,int target){
        if(dp[target] != -1){
            return dp[target];
        }
        int ans =0;
        for(int i=0;i<nums.length;i++){
            if(target >= nums[i]){
                ans += help(nums,target-nums[i]);
            }
        }
        dp[target] = ans;
        return ans;
    }
}
