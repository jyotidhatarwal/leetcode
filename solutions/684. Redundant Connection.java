class Solution {
    // using union find
    int[] par;
   private int findPar(int u){
       if (u == par[u])
          return u;
       return par[u] = findPar(par[u]);
    }
    public int[] findRedundantConnection(int[][] edges) {
         int n = edges.length;
         par = new int[n+1];
         for (int i = 0; i <= n; i++){
             par[i] = i;
         }
​
            for (int[] a : edges){
             int p1 = findPar(a[0]);
            int p2 = findPar(a[1]);
​
                if (p1 != p2){
                    par[p1] = p2;
                 }else{
                    return a;
             }
            }
​
        return new int[0];
    }
}
