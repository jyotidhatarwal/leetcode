class Solution {
    public int findMaxLength(int[] nums) {
        int ans =0;
                // sum, index
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum =0;
        map.put(sum,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                sum += -1;
            }else{
                sum += nums[i];
            }
            if(map.containsKey(sum)){
                int idx = map.get(sum);
                int len = i - idx;
                if(len > ans){
                    ans = len;
                }
            }else{
                map.put(sum,i);
            }
        }
        return ans;
    }
}
