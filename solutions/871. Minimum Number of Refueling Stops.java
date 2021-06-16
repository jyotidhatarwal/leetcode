class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(target == startFuel){
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans =0;
        int currentMaxCoordinate = startFuel;
        int idx = 0;
        while(true){
            while( idx < stations.length && stations[idx][0] <= currentMaxCoordinate){
                pq.add(stations[idx][1]);
                idx++;
            }
            if(currentMaxCoordinate >= target) return ans;
            if(pq.size() == 0) return -1;
            currentMaxCoordinate += pq.remove();
            ans++;
        }
      
    }
}
