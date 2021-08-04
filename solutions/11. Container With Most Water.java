class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j = height.length-1;
        int water = 0;
        while(i < j){
            int width = j-i;
            int Height = Math.min(height[i],height[j]);
            water = Math.max(water,width*Height);
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return water;
    }
}
