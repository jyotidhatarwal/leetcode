class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i = nums.length-2;i>=0;i--){
            // pop push
            while(st.size() > 0 && st.peek() <= nums[i]){
                st.pop();
            }
            st.push(nums[i]);
        }
        for(int i=nums.length-1;i>=0;i--){
            // pop ans push
            while(st.size() > 0 && st.peek() <= nums[i]){
                st.pop();
            }
            ans[i] = st.size() > 0 ? st.peek() : -1;
            st.push(nums[i]);
        }
        return ans;
    }
}
