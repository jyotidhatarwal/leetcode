class Solution {
    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE;
        int sum =0;
        for(int val : nums){
            max = Math.max(max,val);
            sum += val;
        }
        int low = max;
        int hi = sum;
        int ans =0;
        while(low <= hi){
            int mid = low + (hi - low)/2;
            if(isPossible(nums,mid,m)== true){
                ans = mid;
                hi = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    private boolean isPossible(int[]nums,int mid,int m){
        int sum =0;
        int subArray =1;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum > mid){
                subArray++;
                sum = nums[i];
            }
        }
        if(subArray <= m){
            return true;
        }
        return false;
    }
}
