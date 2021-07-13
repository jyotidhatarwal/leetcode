class Solution {
    public int findMin(int[] nums) {
        int low =0;
        int hi = nums.length-1;
        if(nums[low] <= nums[hi]){
            return nums[0];
        }
        while(low <= hi){
            int mid = low + (hi - low)/2;
            if(nums[mid] > nums[mid+1]){
                return nums[mid+1];
            }else if(nums[mid] < nums[mid-1]){
                return nums[mid];
            }else if(nums[low] <= nums[mid]){
                // low to mid is sorted so discard this part
                low = mid+1;
            }else if(nums[mid] <= nums[hi]){
                // mid to high is sorted so discard this part
                hi = mid-1;
            }
        }
        return -1;
    }
}
