class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int[][]dp = new int[d+1][target+1];
        for(int j=1;j<=f && j<=target;j++){
            dp[1][j] = 1;
        }
        for(int i=2;i<=d;i++){
            for(int j=1;j<=target;j++){
                for(int k=1;k<j && k<=f;k++){
                    dp[i][j] = dp[i][j] % 1000000007  + (dp[i-1][j-k]) % 1000000007;
                }
            }
        }
        return dp[d][target] % 1000000007;
    }
}
