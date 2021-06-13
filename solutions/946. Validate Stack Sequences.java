class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int j=0;
        for(int ele : pushed){
            st.push(ele);
            while(st.size() > 0 && st.peek() == popped[j]){
                st.pop();
                j++;
            }
        }
        boolean result = false;
        if(j == popped.length){
            result = true;
        }
        return result;
    }
}
