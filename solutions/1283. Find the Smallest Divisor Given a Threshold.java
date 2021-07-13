class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int val : nums){
            max = Math.max(max,val);
        }
        if(threshold == nums.length){
            return max;
        }
        int low =1;
        int hi = max;
        int minDivisor = Integer.MAX_VALUE;
        
        // binary search is applied on divisors
        while(low <= hi){
            int potentialDivisor = low + (hi - low)/2;
            
            if(isPossible(nums,potentialDivisor,threshold) == true){
                minDivisor = potentialDivisor;
                hi = potentialDivisor -1;
            }else{
                low = potentialDivisor +1;
            }
        }
        return minDivisor;
    }
    private boolean isPossible(int[]nums,int potentialDivisor,int threshold){
        int result =0;
        for(int i=0;i<nums.length;i++){
            result += (int)Math.ceil(nums[i]*1.0/potentialDivisor);
        }
        if(result <= threshold){
            return true;
        }
        return false;
    }
}
