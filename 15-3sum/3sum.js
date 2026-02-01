/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    nums.sort((a,b) => a-b);
    let ans = [];
    for(let i=0;i<nums.length;i++){
        if(nums[i] != nums[i-1]){
            twoSum(nums,i,ans);
        }
        
    }
    return ans;

};

// array needs to be sorted
var twoSum = function(nums,start, ans){
    let i = start+1;
    let j = nums.length-1;
    while(i<j){
        let sum = nums[i] + nums[j] + nums[start];
        if(sum > 0){
            j--;
        }else if(sum < 0){
            i++;
        }else{
          ans.push([nums[i],nums[j],nums[start]]);
          i++;
          j--;
          while(nums[i] === nums[i-1]) i++;
        }
    }
}