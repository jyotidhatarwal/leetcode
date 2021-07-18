class Solution {
    public int maxProfit(int[] prices) {
        
        int profitIfSoldToday = 0;
        int leastSoFar = prices[0];
        int[] maxProfitIfSoldUptoToday = new int[prices.length];
        
        // calculating maximum profit if sold utp today
        for(int i=1;i<prices.length;i++){
            if(prices[i] < leastSoFar){
                leastSoFar = prices[i];
            }
            profitIfSoldToday = prices[i] - leastSoFar;
            if( profitIfSoldToday  > maxProfitIfSoldUptoToday[i-1]){
                maxProfitIfSoldUptoToday[i] = profitIfSoldToday;
            }else{
                maxProfitIfSoldUptoToday[i] = maxProfitIfSoldUptoToday[i-1];
            }
        }
        
        int profitIfBoughtToday = 0;
        int maxSoFar = prices[prices.length-1];
        
        int[]maxProfitIfBoughtTodayOrAfterToday = new int[prices.length];
        for(int i=prices.length-2;i>=0;i--){
            if(prices[i] > maxSoFar){
                maxSoFar = prices[i];
            }
            profitIfBoughtToday = maxSoFar - prices[i];
            if(profitIfBoughtToday > maxProfitIfBoughtTodayOrAfterToday[i+1]){
                maxProfitIfBoughtTodayOrAfterToday[i] =  profitIfBoughtToday;
            }else{
                 maxProfitIfBoughtTodayOrAfterToday[i] =  maxProfitIfBoughtTodayOrAfterToday[i+1];
            }
        }
        int overallProfit =0;
        for(int i=0;i<prices.length;i++){
            if(maxProfitIfSoldUptoToday[i] + maxProfitIfBoughtTodayOrAfterToday[i] > overallProfit){
                overallProfit = maxProfitIfSoldUptoToday[i] + maxProfitIfBoughtTodayOrAfterToday[i];
            }
        }
        return overallProfit;
    }
}
