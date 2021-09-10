class Solution {
    public int[] asteroidCollision(int[] asteriods) {
        int n = asteriods.length;
       Stack<Integer> st = new Stack<>();
        int j =0;
        while(j < n){
            if(st.size() == 0 || asteriods[j] > 0 || st.peek() < 0){
                st.push(asteriods[j]);
                j++;
            }else if(-asteriods[j] < st.peek()){
                j++;
            }else if(-asteriods[j] >= st.peek()){
                if(st.peek() < -asteriods[j]){
                    st.pop();
                }else{
                    st.pop();
                    j++;
                }
            }
        }
       int[] ans = new int[st.size()];
        for(int i= ans.length-1;i>=0;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}
