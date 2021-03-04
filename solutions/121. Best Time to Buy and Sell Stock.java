class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit =0;
        int minPriceToBuy = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            minPriceToBuy = Math.min(minPriceToBuy,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i] - minPriceToBuy);
        }
        return maxProfit;
    }
}
