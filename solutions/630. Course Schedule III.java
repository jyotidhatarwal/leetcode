class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b) ->{
           return a[1] - b[1]; 
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int duration =0;
        for(int[] course : courses){
            if(duration + course[0] <= course[1]){
                // start duration is smaller than the end duration
                pq.add(course[0]);
                duration += course[0];
            }else if(pq.size() > 0 && pq.peek() > course[0]){
                duration += course[0] - pq.remove();
                pq.add(course[0]);
            }
        }
        return pq.size();
    }
}
