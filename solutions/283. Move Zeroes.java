class Solution {
    public void moveZeroes(int[] nums) {
//         int n = nums.length;
//         if(n==0 || n==1){
//             return;
//         }
//         int left=0;
//         int right=0;
//         int temp;
//         while(right<n){
//             if(nums[right]==0){
//                 right++;
//             }else{
//                 temp=nums[left];
//                 nums[left] = nums[right];
//                 nums[right] = temp;
//                 right++;
//                 left++;
//             }
//         }
     
        int[]ans = new int[nums.length];
        int k =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                ans[k] = nums[i];
                k++;
            }
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = ans[i];
        }
    }
}
