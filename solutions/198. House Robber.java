class Solution { 
   public int rob(int[] nums) {
        if(nums.length  == 0) return 0;
       if(nums.length == 1) return nums[0];
       int prev = nums[0];
       int prevRob = Math.max(prev,nums[1]);
       for(int i=2;i<nums.length;i++){
           int currRob = Math.max(prevRob,prev + nums[i]);
           prev = prevRob;
           prevRob = currRob;
       }
       return prevRob > prev ? prevRob : prev;
    }
}
