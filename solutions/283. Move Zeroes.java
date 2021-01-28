class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length==0) return;
        int i=0;
        for(int element:nums){
            if(element !=0){
                nums[i] = element;
                i++;
            }
        }
        while(i<nums.length){
            nums[i]=0;
            i++;
        }
        
    }
}
