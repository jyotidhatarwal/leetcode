/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    // let n = nums.length;
    // // create a map of values vs index
    // let map = {};
    // for(let i=0;i<n;i++){
    //     map[nums[i]] = i;
    // }

    // // find if target - current element in array exists in map that is answer
    // for(let i=0;i<n;i++){
    //     let pairToFind = target - nums[i];
    //     if(map[pairToFind] && map[pairToFind] !== i){
    //         return [i, map[pairToFind]];
    //     }
    // }

    // second time
    let n = nums.length;
    let map = {};
    for(let i=0;i<n;i++){
        map[nums[i]] = i;
    }

    for(let i=0;i<n;i++){
        let pairToFind = target - nums[i];
        if(map[pairToFind] && map[pairToFind] !== i){
            return [i,map[pairToFind]];
        }
    }
};