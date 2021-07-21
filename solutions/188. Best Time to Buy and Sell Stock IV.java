class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n == 0){
            return 0;
        }
        int[][] dp = new int[k+1][n];
        // t  --> transaction
        // d --> days
        // pd --> previous days
        for(int t = 1;t<= k ;t++){
            for(int d =1;d<n;d++){
                int max = dp[t][d-1];
                for(int pd =0;pd<d;pd++){
                    int profitTillTransactionMinusOneDay = dp[t-1][pd];
                    int profitOnTransactionDay = prices[d] - prices[pd];
                    
                    if(profitTillTransactionMinusOneDay + profitOnTransactionDay > max){
                        max = profitTillTransactionMinusOneDay + profitOnTransactionDay;
                    }
                }
                dp[t][d] = max;
            }
        }
        return dp[k][n-1];
    }
}
