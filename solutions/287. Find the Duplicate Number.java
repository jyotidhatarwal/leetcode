class Solution {
    public int findDuplicate(int[] nums) {
        int dup = -1;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                dup = nums[i];
            }
        }
        return dup;
    }
}
