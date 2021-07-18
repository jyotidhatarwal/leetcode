class Solution {
    public int maxProfit(int[] prices) {
        int oldBoughtStateProfit = -prices[0];
        int oldSoldStateProfit =0;
        int oldCooledStateProfit =0;
        for(int i=0;i<prices.length;i++){
            int newBoughtStateProfit =0;
            int newSoldStateProfit =0;
            int newCooledStateProfit =0;
            
            // if bought today will the profit is maximized
            
            // buying is taking place after a cooldown
            if(oldCooledStateProfit - prices[i] > oldBoughtStateProfit){
                newBoughtStateProfit = oldCooledStateProfit - prices[i];
            }else{
                newBoughtStateProfit = oldBoughtStateProfit;
            }
            
            
            // if sold today will the profit is maximized
            
            // selling can take place ater a buy
            
            if(oldBoughtStateProfit + prices[i] > oldSoldStateProfit){
                newSoldStateProfit = oldBoughtStateProfit + prices[i];
            }else{
                newSoldStateProfit = oldSoldStateProfit;
            }
            
            // if cooled today will the profit is maximized
            
            // cool down can take place after a  sell
            
            if(oldSoldStateProfit > oldCooledStateProfit){
                newCooledStateProfit = oldSoldStateProfit;
            }else{
                newCooledStateProfit = oldCooledStateProfit;
            }
            
         oldBoughtStateProfit =  newBoughtStateProfit;
         oldSoldStateProfit =    newSoldStateProfit;
         oldCooledStateProfit =  newCooledStateProfit;
        }
        return oldSoldStateProfit;
    }
}
