/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    let l = 0;
    let r = nums.length-1;
    if(nums[l] <= nums[r]) return nums[l]; // for sorted array
    // for rotated array
    while(l <= r){
        let m = l + Math.floor((r-l)/2);
        if(nums[m] < nums[m-1]){
            return nums[m];
        }
        // if search space already sorted
        if(nums[l] < nums[r]){
            return nums[l];
        }
        // if left is not sorted inflection pt will be in left part
        if(nums[l] > nums[m]){
            r = m-1;
        }else{
            l = m+1;
        }
    }
};