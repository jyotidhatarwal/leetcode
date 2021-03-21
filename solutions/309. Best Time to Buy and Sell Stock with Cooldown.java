class Solution {
    public int maxProfit(int[] prices) {
        int oldBuy =-prices[0];
        int oldSell=0;
        int oldCool =0;
        for(int i=1;i<prices.length;i++){
            int newBuy =0;
            int newSell=0;
            int newCool=0;
            if(oldCool -prices[i] >oldBuy){
                newBuy = oldCool -prices[i];
            }else{
                newBuy = oldBuy;
            }
            if(oldBuy + prices[i] > oldSell){
                newSell = oldBuy + prices[i];
            }else{
                newSell = oldSell;
            }
            if(oldSell > oldCool){
                newCool = oldSell;
            }else{
                newCool = oldCool;
            }
            oldBuy = newBuy;
            oldSell = newSell;
            oldCool = newCool;
        }
        return oldSell;
        
    }
}
