class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int val : piles){
            max = Math.max(val,max);
        }
        if(h == piles.length){
            return max;
        }
        
        // in this we are applying binary search on the speed of eating banans
        int low =0;
        int hi = max;
        int speed = Integer.MIN_VALUE;
        while(low <= hi){
            int potentialSpeed = low + (hi - low)/2;
            
            if(isPossible(piles,potentialSpeed,h) == true){
                speed = potentialSpeed;
                hi = potentialSpeed-1;
            }else{
                low = potentialSpeed+1;
            }
        }
        return speed;
    }
    private boolean isPossible(int[]piles,int potentialSpeed,int h){
        int time =0;
        for(int i=0;i<piles.length;i++){
            time += (int)Math.ceil(piles[i]*1.0/potentialSpeed);
        }
        if(time <= h){
            return true;
        }
        return false;
    }
}
