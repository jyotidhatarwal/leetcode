class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        // min priority Queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{
           return a[1]-b[1]; 
        }) ;
        
        for(int ele : map.keySet()){
            pq.add(new int[]{ele,map.get(ele)});
            if(pq.size() > k) pq.remove();
        }
        int[] ans = new int[k];
        int i =0;
        while(pq.size() > 0){
            int[] rem = pq.remove();
          //  int data = rem[0];
            ans[i++] = rem[0];
        }
        return ans;
    }
}
