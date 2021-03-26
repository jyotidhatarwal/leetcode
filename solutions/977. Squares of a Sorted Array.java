class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int[]result = new int[nums.length];
        int ptr = result.length-1;
        
        while(left <= right){
            if(Math.abs(nums[left]) < Math.abs(nums[right])){
             result[ptr] = nums[right]*nums[right];   
                right--;
                ptr--;
            }else{
                result[ptr] = nums[left]*nums[left];
                left++;
                ptr--;
            }
        }
        return result;
    }
}
