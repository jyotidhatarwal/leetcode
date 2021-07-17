class Solution {
    public int maxProfit(int[] prices, int fee) {
        int oldBoughtStateProfit = -prices[0];
        int oldSoldStateProfit = 0;
        for(int i=1;i<prices.length;i++){
            int newBoughtStateProfit =0;
            int newSoldStateProfit =0;
            // if bought today will it be profitable
            if(oldSoldStateProfit - prices[i] > oldBoughtStateProfit){
                newBoughtStateProfit = oldSoldStateProfit - prices[i];
            }else{
                newBoughtStateProfit = oldBoughtStateProfit;
            }
            // if sold today will it be profitable
            if(oldBoughtStateProfit + prices[i] - fee > oldSoldStateProfit){
                newSoldStateProfit = oldBoughtStateProfit + prices[i] - fee;
            } else{
                newSoldStateProfit = oldSoldStateProfit;
            }
            oldBoughtStateProfit = newBoughtStateProfit;
            oldSoldStateProfit = newSoldStateProfit;
        }
        return oldSoldStateProfit;
    
    }
}
