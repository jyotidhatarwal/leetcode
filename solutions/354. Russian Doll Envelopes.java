class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
            return a[0]-b[0];
        });
        int[]dp = new int[envelopes.length];
        int ans =0;
        for(int i=0;i<envelopes.length;i++){
            int max =0;
            for(int j=0;j<i;j++){
                if(envelopes[i][1] > envelopes[j][1] && envelopes[i][0] > envelopes[j][0]){
                    if(dp[j] > max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max +1;
            if(dp[i] > ans){
                ans = dp[i];
            }
        }
        return ans;
    }
}
