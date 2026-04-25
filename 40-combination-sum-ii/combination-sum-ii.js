/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(candidates, target) {
    let result = [];
    candidates.sort();

    let backtrack = (remainingSum,path,start) => {
        if(remainingSum === 0){
            result.push([...path]);
        }
        if(remainingSum < 0) return;
        for(let i=start;i<candidates.length;i++){
            if(i > start && candidates[i] === candidates[i-1]) continue;
            path.push(candidates[i]);
            backtrack(remainingSum-candidates[i],path,i+1);
            path.pop();
        }
    }
    backtrack(target,[],0);
    return result;
};