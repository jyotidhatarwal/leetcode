class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int majority = (int)Math.floor(nums.length/3);
        for(int val:map.keySet()){
            if(map.get(val) > majority){
                res.add(val);
            }
        }
        return res;
    }
}
