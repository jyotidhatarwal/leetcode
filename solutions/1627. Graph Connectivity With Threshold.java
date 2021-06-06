    int[] parent;
    int[] rank;
    private int find(int i){
        if(parent[i] == i){
            return i;
        }
        int temp = find(parent[i]);
        parent[i] = temp;
        return temp;
    }
    private void  union(int x,int y){
        int lox = find(x);
        int loy = find(y);
        if(lox == loy) return;
        if(rank[lox] < rank[loy]){
            parent[lox] = loy;
        }else if(rank[loy] < rank[lox]){
            parent[loy] = lox;
        }else{
            parent[loy] = lox;
            rank[lox]++;
        }
    }
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
         parent = new int[n+1];
        rank = new int[n+1];
​
        for(int i=0;i<=n;i++){
            parent[i] = i;
            rank[i] = 0;
        }
        for(int i= threshold+1;i<=n;i++){
            for(int j=i;j<=n;j+=i){
               union(i,j);
            }
        }
        for(int q =0; q<queries.length;q++){
            if(find(queries[q][0]) == find(queries[q][1])){
                ans.add(true);
            }else{
                ans.add(false);
            }
        }
        return ans;
    }
    
}
