class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k =0;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i=0;i<nums.length;i++){
            if(pq.size() < k){
                pq.add(nums[i]);
            }else if(pq.peek() < nums[i]){
                pq.remove();
                pq.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
      if(pq.size() > this.k){
          pq.remove();
      }
        return pq.peek();
    }
}
​
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
