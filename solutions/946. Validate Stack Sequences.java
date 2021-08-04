class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int j =0;
        for(int val : pushed){
            st.push(val);
            while(st.size() > 0 && st.peek() == popped[j]){
                st.pop();
                j++;
            }
        }
        if(j == popped.length){
            return true;
        }
        return false;
    }
}
