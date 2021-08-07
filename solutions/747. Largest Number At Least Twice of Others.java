class Solution {
    public int dominantIndex(int[] nums) {
        int n = nums.length;
        int maxIndex =0;
        
        for(int i=0;i<n;i++){
            if(nums[i] > nums[maxIndex]){
                maxIndex =i;
            }
        }
        for(int i=0;i<n;i++){
            if(maxIndex != i && 2*nums[i] > nums[maxIndex]){
                return -1;
            }
        }
        return maxIndex;
    }
}
