class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j = height.length-1;
        int maxArea = Integer.MIN_VALUE;
        while(i < j){
            int width = j-i;
            int h = Math.min(height[j],height[i]);
            int area = width*h;
            maxArea = Math.max(area,maxArea);
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxArea;
    }
}
