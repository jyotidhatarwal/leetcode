class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
     int kans = atmost(nums,k);
     int kMinus1Ans = atmost(nums,k-1);
     return kans - kMinus1Ans;
    }
    private int atmost(int[] nums,int k){
           int count = 0;
        int left = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int right = 0;right< nums.length;right++){
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            while(map.size() > k){
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}