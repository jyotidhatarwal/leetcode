/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    let maxArea = 0;
    let i = 0;
    let j = height.length-1;
    while(i < j){
        let area = Math.min(height[i], height[j]) * (j-i);
        maxArea = Math.max(area,maxArea);
        if(height[i] > height[j]){
            j--;
        }else{
            i++;
        }
    }
    return maxArea;
};