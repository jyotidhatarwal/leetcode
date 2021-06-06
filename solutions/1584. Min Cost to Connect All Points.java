class Solution {
    public int minCostConnectPoints(int[][] points) {
//      Prims Algorithm
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int n = points.length;
        boolean visited[] = new boolean[n];
        int costTillPoint = 0;
        int count = 0;
        
        pq.add(new int[]{0, 0});  // [0] -> index of point, 
                                  // [1] -> cost of connecting the point
        
        while(pq.size() > 0){
            int[] rem = pq.remove();
            
            int idx = rem[0];
            int cost = rem[1];
            
            if(visited[idx] == true){
                continue;
            }
            
            visited[idx] = true;
            costTillPoint += cost;
            count++;
            
            if(count == n) return costTillPoint;
            
            for(int i = 0; i<n; i++){
                if(visited[i] == false){
                    int x1 = points[idx][0];
                    int y1 = points[idx][1];
                    int x2 = points[i][0];
                    int y2 = points[i][1];
                    
                    int costBtwPoints = Math.abs(x1-x2) + Math.abs(y1-y2);
                    
                    pq.add(new int[]{i, costBtwPoints});
                }
            }
        }
        
        return costTillPoint;
            
    }
}
​
