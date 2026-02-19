/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
     k = k % nums.length;
    let ans = [];
    for(let i=nums.length-1;i>=0;i--){
        ans[(i+k)% nums.length] = nums[i];
    }
    for(let i=0;i<nums.length;i++){
        nums[i] = ans[i];
    }
};