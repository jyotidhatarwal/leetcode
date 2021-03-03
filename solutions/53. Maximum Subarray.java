class Solution {
    public int maxSubArray(int[] nums) {
       int sum =0;
        int maximum = nums[0];
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum > maximum){
                maximum = sum;
            }
            if(sum <0){
                sum =0;
            }
        }
        return maximum;
    }
}
/*  This is done by using kadane's Algorithm which states that if the current sum is positive then add itself to the current sum and if it is negative then start fresh make current sum equal to itself and at last return the overall best sum    */
​
/*   the time complexity of this code is O(n) and the space complexit of this is O(1)       */
