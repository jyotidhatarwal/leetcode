class Solution {
    // using union find
    int[] par;
   private int findPar(int u){
       if (par[u] == u)
          return u;
       int temp = findPar(par[u]);
       par[u] = temp;
       return temp;
    }
    public int[] findRedundantConnection(int[][] edges) {
         int n = edges.length;
         par = new int[n+1];
        // initially everyone is parent of itself only
         for (int i = 0; i <= n; i++){
             par[i] = i;
         }
​
            for (int[] ans : edges){
            int p1 = findPar(ans[0]);
            int p2 = findPar(ans[1]);
​
                if (p1 != p2){
                    par[p1] = p2;
                 }else{
                    return ans;
             }
            }
​
        return new int[0];
    }
}
