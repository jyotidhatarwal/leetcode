class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int sum =0;
        int max = Integer.MIN_VALUE;
        for(int val : weights){
            max = Math.max(max,val);
            sum += val;
        }
        int low = max;
        int hi = sum;
        int ans =0;
        while(low <= hi){
            int  mid = low + (hi -low)/2;
            if(isPossible(weights,mid,days)== true){
                ans = mid;
                hi = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    private boolean isPossible(int[]weights,int mid,int days){
        int sum=0;
        int capacity =1;
        for(int i=0;i <weights.length;i++){
            sum += weights[i];
            if(sum > mid){
                capacity++;
                sum = weights[i];
            }
        }
        if(capacity <= days){
            return true;
        }
        return false;
    }
}
