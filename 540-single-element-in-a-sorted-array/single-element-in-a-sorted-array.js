/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNonDuplicate = function(nums) {
    let l = 0;
    let r = nums.length-1;
    while(l < r){
        // find the middle
        let m = l + Math.floor((r-l)/2);
        // find where is the pair left or right
        // left
        if(nums[m] === nums[m-1]){
            // find the odd elements as single element will be there
            // left
            let leftCount = m-2 - l +1
            if( leftCount % 2 === 1){
                r = m-2;
            }else{
                // odd element on right side
                l = m+1;
            }
        }else if(nums[m] === nums[m+1]){// pair on right
            // odd elements
            let leftCount = m -1 - l +1;
            if((leftCount % 2  === 1)){
                r = m-1;
            }else{
                l = m+2;
            }
        }else{
            return nums[m];
        }
    }
    return nums[l];
};