class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[]nge = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i= nums.length-2;i>=0;i--){
            // pop push
            while(st.size() > 0 && nums[i] >= st.peek()){
                st.pop();
            }
            st.push(nums[i]);
        }
        for(int i=nums.length-1;i>=0;i--){
            while(st.size() > 0 && nums[i] >= st.peek()){
                st.pop();
            }
            if(st.size() == 0){
                nge[i] = -1;
            }else{
                nge[i] = st.peek();
            }
            st.push(nums[i]);
        }
        return nge;
    }
}
