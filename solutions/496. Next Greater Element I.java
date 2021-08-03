class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[]ans = new int[nums1.length];
        int[]nge2 = nextGreater(nums2);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],nge2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
        
    }
    private int[] nextGreater(int[]nums){
        int[]nge = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        st.push(nums[nums.length-1]);
        nge[nums.length-1] = -1;
        for(int i= nums.length-2;i>=0;i--){
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
