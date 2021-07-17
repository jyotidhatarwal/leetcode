class Solution {
    public int maxProfit(int[] prices) {
        int buyDate =0;
        int sellDate =0;
        int profit =0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] >= prices[i-1]){
                sellDate++;
            }else{
                profit += prices[sellDate] - prices[buyDate];
                buyDate = sellDate = i;
            }
        }
        profit += prices[sellDate] - prices[buyDate];
        return profit;
    }
}
