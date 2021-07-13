class Solution {
    public boolean search(int[] nums, int target) {
        
        int low = 0;
        int hi = nums.length-1;
        
        while(low <= hi){
            
            while(low < hi && nums[low] == nums[low+1]){
                low++;
            }
            while(low < hi && nums[hi] == nums[hi-1]){
                hi--;
            }
            int mid = low + (hi - low)/2;
            
            if(nums[mid] == target){
                return true;
            }else if(nums[low] <= nums[mid]){
                if(target >= nums[low] && nums[mid] > target){
                    hi = mid-1;
                }else{
                    low = mid+1;
                }
            }else if(nums[mid] <= nums[hi]){
                if(target > nums[mid] && nums[hi] >= target){
                    low = mid+1;
                }else{
                    hi = mid-1;
                }
            }
        }
        return false;
    }
}
