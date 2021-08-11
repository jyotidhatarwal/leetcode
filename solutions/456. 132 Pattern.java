class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[]min = new int[n];
        min[0] = nums[0];
        boolean result = false;
        for(int i=1;i<n;i++){
            min[i] = Math.min(min[i-1],nums[i]);
        }
        Stack<Integer> st = new Stack<>();
        for(int j = n-1;j>=0;j--){
            while(st.size() > 0 && st.peek() <= min[j]){
                st.pop();
            }
            if(st.size() > 0 && st.peek() < nums[j]){
                result = true;
                break;
            }
            st.push(nums[j]);
        }
        return result;
    }
}
