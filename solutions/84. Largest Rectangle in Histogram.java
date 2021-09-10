class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        if(n == 0){
            return 0;
        }
        int overallMax =0;
        for(int i=0;i<=n;i++){
            int height = (i == n ? 0 : heights[i]);
            while(st.size() > 0 && heights[st.peek()] > height){
                int top = st.pop();
                int nsr = i;
                int nsl = (st.size() == 0 ? -1 : st.peek());
                int width = nsr - nsl -1;
                overallMax = Math.max(overallMax,width*heights[top]);
            }
            st.push(i);
        }
        return overallMax;
    }
}
