class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // using sliding window
        int sum =0;
        for(int i=0;i<k;i++){
            sum += nums[i];
        }
        int max = sum;
        for(int i=k;i<nums.length;i++){
            sum = sum + nums[i] - nums[i-k];
            max = Math.max(sum,max);
        }
        double ans = (double)max/k;
        return ans;
    }
}
