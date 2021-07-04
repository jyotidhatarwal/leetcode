class Solution {
    public int maxProduct(int[] nums) {
        int prefixMax = prefixProduct(nums);
        int suffixMax = suffixProduct(nums);
        int ans = Math.max(prefixMax,suffixMax);
        
        return ans;
    }
    
    private int prefixProduct(int[] nums){
        int currentMax =1;
        int overallMax = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            currentMax = currentMax*nums[i];
            overallMax = Math.max(currentMax,overallMax);
            if(currentMax == 0){
                currentMax =1;
            }
        }
        return overallMax;
    }
    private int suffixProduct(int[]nums){
        int currentMax =1;
        int overallMax = Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            currentMax = currentMax * nums[i];
            overallMax = Math.max(overallMax,currentMax);
            if(currentMax == 0){
                currentMax =1;
            }
        }
        return overallMax;
    }
}
