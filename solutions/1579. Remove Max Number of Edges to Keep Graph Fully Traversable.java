class Solution {
    private int find(int i,int[] parent){
        if(parent[i] == i){
            return i;
        }
        int temp = find(parent[i],parent);
        parent[i] = temp;
        return temp;
    }
    private boolean union(int x,int y,int[] size,int[] parent){
        int lox = find(x,parent);
        int loy = find(y,parent);
        if(lox == loy) return false;
        if(size[lox] < size[loy]){
            parent[lox] = loy;
            size[loy] += size[lox];
        }else{
            parent[loy] = lox;
            size[lox] += size[loy];
        }
        return true;
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] AParent = new int[n+1];
        int[] BParent = new int[n+1];
        int[] ASize = new int[n+1];
        int[] BSize = new int[n+1];
        
        int count =0;
        
        for(int i=0;i<=n;i++){
            AParent[i] = i;
            BParent[i] = i;
            ASize[i] = 1;
            BSize[i] = 1;
        }
        
        Arrays.sort(edges,(a,b) ->(b[0] - a[0]));
        for(int[] edge : edges){
            if(edge[0] == 3){
                 boolean alice = union(edge[1],edge[2],ASize,AParent);
                boolean bob = union(edge[1],edge[2],BSize,BParent);
                if(alice  && bob) count++;
               
            }else if(edge[0] == 2){
              boolean bob =  union(edge[1],edge[2],BSize,BParent);
               if(bob) count++;
            }else{
              boolean alice = union(edge[1],edge[2],ASize,AParent);
                if(alice) count++;
            }
        }
        
        boolean presentA =false;
       for(int i=0;i<=n;i++){
           if(ASize[i] == n){
               presentA=true;
               break;
           }
       }
        boolean presentB=false;
        for(int i=0;i<=n;i++){
           if(BSize[i] == n){
               presentB=true;
               break;
           }
       }
        
        
        if(presentA && presentB)
        return edges.length-count;
    
       return -1;
    }
}
