class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] ans = new int[nums1.length];
        int[] nge = nextGreaterElementRight(nums2);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],nge[i]);
        }
        for(int i=0;i<nums1.length;i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
    
     private int[] nextGreaterElementRight(int[] nums2) {
        Stack<Integer> st = new Stack<>();
         int[] ans = new int[nums2.length];
         for(int i=nums2.length-1;i>=0;i--){
             while(st.size() > 0 && st.peek() < nums2[i]) st.pop();
             ans[i] = st.size() > 0 ? st.peek() : -1;
             st.push(nums2[i]);
         }
         return ans;
    }
}
