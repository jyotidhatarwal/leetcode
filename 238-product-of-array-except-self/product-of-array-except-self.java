class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        // calculating the left product and storing in ans
        for(int i=1;i<n;i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        int rightProduct= 1;
        //calculating the right product and storing in ans
        for(int r = n-1;r>=0;r--){
            ans[r] = ans[r] * rightProduct;
            rightProduct *= nums[r];
        }
        return ans;
    }
}