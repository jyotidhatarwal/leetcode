class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea =0;
        for(int i=0;i<=n;i++){
            int height = (i == n ? 0 : heights[i]);
            while(st.size() > 0 && heights[st.peek()] > height){
                int top = st.pop();
                maxArea = Math.max(maxArea,heights[top]* (st.size() == 0 ? i : i-st.peek()-1));
            }
            st.push(i);
        }
        return maxArea;
    }
}
