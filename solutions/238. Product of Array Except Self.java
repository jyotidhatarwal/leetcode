class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] rightProduct = new int[nums.length];
        int product = 1;
        for(int i=nums.length-1;i>=0;i--){
            product *= nums[i];
            rightProduct[i] = product;
        }
        int leftProduct =1;
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length-1;i++){
            res[i] = rightProduct[i+1]*leftProduct;
            leftProduct *= nums[i];
        }
        res[nums.length-1] = leftProduct;
        return res;
    }
}
