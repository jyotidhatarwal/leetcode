/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function(nums, k) {
    // create a map of frequency
    let map = {};
    for(let i=0;i<nums.length;i++){
        if(!map[nums[i]]){
            map[nums[i]] = 0;
        }
        map[nums[i]]++;
    }
    
    // add elements to min priority queue and restrict size to k
    let pq = new MinPriorityQueue(x => x.freq); // give priority to highest frequency
    for(key in map){
        pq.push({val : key, freq : map[key]});
        if(pq.size() > k){
            pq.pop();
        }
    }
    // return remaining k elements in pq 
    return pq.toArray().map(x => Number(x.val));


};