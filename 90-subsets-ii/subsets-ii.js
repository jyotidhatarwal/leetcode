/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
    nums.sort();
    let result = [];

    let backtrack = (path,start) => {
        result.push([...path]);
        for(let i=start;i<nums.length;i++){
            // the the adjacent elements are same skip that iteration
            if(i > start && (nums[i-1] === nums[i])){
                continue;
            }
            path.push(nums[i]);
            backtrack(path,i+1);
            path.pop();
            
        }
    }
    backtrack([],0);
    return result;
};