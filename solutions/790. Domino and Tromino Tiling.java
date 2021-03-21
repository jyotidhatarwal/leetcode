class Solution {
    public int numTilings(int N) {
        int mod = (int)1e9 + 7;
    int[] dp = new int[1001];
    
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
​
        for(int i=3; i<=N; i++){
            dp[i] = (2*dp[i-1]%mod + dp[i-3]%mod)%mod;
        }
        
        return dp[N]%mod;
    }
}
