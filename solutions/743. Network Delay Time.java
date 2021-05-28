class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // step-1 --> make a graph from times array
        HashMap<Integer,HashMap<Integer,Integer>> graph = new HashMap<>();
        for(int[] time : times){
            graph.putIfAbsent(time[0],new HashMap<>());
            graph.get(time[0]).put(time[1],time[2]);
        }
        
        // step-2 --> using Dijstra Algorithm
        
        // int this at 0 index we have distance and 1 index we have vertex
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->{
            return a[0] - b[0];
        });
        
        pq.add(new int[]{0,k});
        // since the distance from a given vertex to that vertex is zero
        
        boolean[]visited = new boolean[n+1];
        // because index are starting from 1
        
        int time =0;
        // time taken from a vertex K to travel all nodes
        
        while(pq.size() > 0){
            int size = pq.size();
            while(size-- > 0){
                int[] rem = pq.remove();
                int distance = rem[0];
                int vertex = rem[1];
                if(visited[vertex] == true) continue;
                visited[vertex] = true;
                time = distance;
                n--;
                if(n == 0) return time;
                if(graph.containsKey(vertex)){
                  for(int nbrs : graph.get(vertex).keySet()){
                      pq.add(new int[]{distance+graph.get(vertex).get(nbrs) , nbrs});
                  }  
                }
            }
        }
        return -1;
    }
}
