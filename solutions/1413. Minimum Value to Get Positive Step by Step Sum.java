class Solution {
    public int minStartValue(int[] nums) {
         int n = nums[0]<0 ? (-1*nums[0])+1 : 1;
            
        int num=n;
        for(int i:nums){
            n+=i;
            if(n<1){
                num += (-1*n)+1;                  
                n = 1;
                //basically, if it goes below 1, then the number should have been that much bigger
                // therefore we are adding the remaining to it.
            }
        }        
        return num;
    }
}
