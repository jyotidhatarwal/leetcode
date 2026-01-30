/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
    let h = haystack.length;
    let n = needle.length;

    for(let i=0;i<=h-n;i++){ // sliding window till haystack-needle length

    // check if needle === window
    let j;
    for(j=0;j<n;j++){
        if(haystack[i+j] !== needle[j]){
            break;
        }
    }
    if(j === n){
        return i;
    }

    }
     return -1;
};