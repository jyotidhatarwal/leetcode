/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var minRemoval = function(nums, k) {
     nums.sort((a, b) => a - b);

    let n = nums.length;
    let maxLen = 1;
    let l = 0;

    for (let r = 0; r < n; r++) {
        while (nums[r] > nums[l] * k) {
            l++;
        }
        maxLen = Math.max(maxLen, r - l + 1);
    }

    return n - maxLen;
};