class MedianFinder {
​
    /** initialize your data structure here. */
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue<>();
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
       
            min.add(num);
            max.add(min.remove());
         if(max.size() > min.size()){
            max.add(num);
            min.add(max.remove());
        }
    }
    
    public double findMedian() {
        if(max.size() == min.size()){
            return (max.peek() + min.peek())/2.0;
        }else{
            return (double)min.peek();
        }
    }
}
​
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
