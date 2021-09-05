class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            int a = nums[i];
            int target = -a;
            int start = i+1;
            int end = n-1;
            while(start < end){
                if(nums[start] + nums[end] == target){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[start]);
                    res.add(nums[end]);
                    ans.add(res);
                    while(start < end && nums[start] == nums[start+1]){
                        start++;
                    }
                    while(start < end && nums[end] == nums[end-1]){
                        end--;
                    }
                    start++;
                    end--;
                }else if(nums[start] + nums[end] > target){
                    end--;
                }else{
                    start++;
                }
            }
            while(i+1 < n && nums[i+1] == nums[i]){
                i++;
            }
        }
        return ans;
    }
}
