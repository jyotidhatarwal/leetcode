//         while(pq.size() > 0){
//             int size = pq.size();
            
//                 int[] rem = pq.remove();
//                 int cost = rem[0];
//                 int vertex = rem[1];
//                 int stops = rem[2];
//                 if(vertex == dst) return cost;
               
//                 if(stops > 0){
//                     if(graph.containsKey(vertex)){
//                         for(int nbrs : graph.get(vertex).keySet()){
//                             visited[nbrs] = true;
//                             pq.add(new int[]{cost + graph.get(vertex).get(nbrs),nbrs,stops-1});
//                         }
//                     }
                
//              }
            
//         }
//         return -1;
//     }
// }
​
class Solution{
public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<HashMap<Integer,Integer>> map=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            map.add(new HashMap<>());
        }
        
        for(int[] arr:flights){   
            map.get(arr[0]).put(arr[1],arr[2]);
        }
        
        Map<Integer, Integer> visited = new HashMap<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        
        pq.offer(new int[]{src,-1,0});
        
        while(!pq.isEmpty()){
            
            int[] rn=pq.poll();
            
           
            int city = rn[0];
            int stops = rn[1];
            int price = rn[2];
           
           
            if(city==dst){
                return price;
            }
            
            visited.put(city, stops); 
            
            if(stops==k)continue;
               
            
                for(int val:map.get(city).keySet()){
                     if (!visited.containsKey(val) || stops < visited.get(val)) {
                    pq.offer(new int[]{val,stops+1,price+map.get(city).get(val)});
                     }
                }   
         
        }
        
        return -1;
   
    }
}
