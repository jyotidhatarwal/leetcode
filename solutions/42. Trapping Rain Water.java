class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0){
            return 0;
        }
        int leftMax = 0;
        int rightMax = 0;
        
        int i=0;
        int j = n-1;
        int ans =0;
        while(i < j){
            leftMax = Math.max(leftMax,height[i]);
            rightMax = Math.max(rightMax,height[j]);
            
            if(leftMax <= rightMax){
                ans += leftMax - height[i];
                i++;
            }else{
                ans += rightMax - height[j];
                j--;
            }
        }
        return ans;
    }
    
}
