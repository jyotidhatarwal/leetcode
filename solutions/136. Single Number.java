class Solution {
    public int singleNumber(int[] nums) {
        // using XOR operation 
        // 1 xor 1 --> 0
        // 0 xor 0 --> 0
        // 1 xor 0 or vice versa --> 1
        int ans =0;
        for(int val : nums){
            ans = ans ^ val;
        }
        return ans;
    }
}
