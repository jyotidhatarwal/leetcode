class Solution {
    public int majorityElement(int[] nums) {
       HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        double majority = Math.floor(nums.length/2);
        for(int val:nums){
            if(map.get(val) > majority){
                return val;
            }
        }
        return 1;
    }
}
