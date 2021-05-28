class Solution {
    ArrayList<Integer>[] graph;
    
    int time = 0;
    int[] low;
    int[] disc;
    boolean vis[];
    
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph= new ArrayList[n];
        low = new int[n];
        disc = new int[n];
        vis = new boolean[n];
        
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        } 
        for(List<Integer> a: connections){
            graph[a.get(0)].add(a.get(1));
            graph[a.get(1)].add(a.get(0));
        }
        
        for(int i = 0;i < n; i++){
            if(vis[i] == false){
                dfs(i,-1);
            }
        }
        
        return ans;
    }
    
    public void dfs(int src,int par){
        low[src] = disc[src] = time++;
        vis[src] = true;
        for(int nbrs : graph[src]){
          if(vis[nbrs] == false){
              dfs(nbrs,src);
              if(disc[src] < low[nbrs]){
                  
                 ArrayList<Integer> smallAns = new ArrayList<>();
                 smallAns.add(src); smallAns.add(nbrs);
                 ans.add(smallAns);
              }
              
              low[src] = Math.min(low[src],low[nbrs]);
          }else if(nbrs != par){
              low[src] = Math.min(low[src],disc[nbrs]);
          }
        }
    }
​
}
