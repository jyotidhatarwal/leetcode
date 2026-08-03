class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
       int n = nums.length;
       long currSum =0;
       long maxSum = 0;
       HashMap<Integer,Integer> map = new HashMap<>();

       for(int i=0;i<k;i++){
        currSum += nums[i];
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);
       }
       if(map.size() == k){
        maxSum = currSum;
       }
       int i = 1;
       int j = k;
       while(j< n){
        // remove element
        int out = nums[i-1];
        currSum -= out;
        map.put(out,map.get(out)-1);
        if(map.get(out) == 0){
            map.remove(out);
        }

        // incoming element
        int in = nums[j];
        currSum += in;
        map.put(in,map.getOrDefault(in,0)+1);
        if(map.size() == k){
            maxSum = Math.max(currSum,maxSum);
        }
        i++;
        j++;
       }
       return maxSum;
    }
}