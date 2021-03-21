class Solution {
    public int maxProfit(int[] prices, int fee) {
    int oldBuy = -prices[0];
        int oldSell =0;
        for(int i=1;i<prices.length;i++){
            int newBuy = 0;
            int newSell=0;
            if(oldSell - prices[i] > oldBuy){
                newBuy = oldSell -prices[i];
            }else{
                newBuy = oldBuy;
            }
            if(oldBuy + prices[i] -fee > oldSell){
                newSell = oldBuy +prices[i] -fee;
            }else{
                newSell = oldSell;
            }
            oldBuy = newBuy;
            oldSell = newSell;
        }
        return oldSell;
    }
}
