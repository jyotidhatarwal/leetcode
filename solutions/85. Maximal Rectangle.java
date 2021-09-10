class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if(n == 0){
            return 0;
        }
        int m = matrix[0].length;
        int[] arr = new int[m];
        int overallMax = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] == '1'){
                    arr[j] += 1;
                }else{
                    arr[j] = 0;
                }
            }
            int max = largestRectangleArea(arr);
            overallMax = Math.max(max,overallMax);
        }
        return overallMax;
        
    }
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
​
}
