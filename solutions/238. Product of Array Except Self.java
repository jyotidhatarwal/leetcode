class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        int[] output = new int[nums.length];
        Arrays.fill(leftProduct,1);
        Arrays.fill(rightProduct,1);
        for(int i=0;i<nums.length-1;i++){
            leftProduct[i+1] = nums[i] * leftProduct[i];
        }
        for(int i= nums.length-1;i>0;i--){
            rightProduct [i-1] = nums[i] * rightProduct[i];
        }
        for(int i=0;i<nums.length;i++){
            output[i] = leftProduct[i] * rightProduct[i];
        }
        return output;
        
    }
}
