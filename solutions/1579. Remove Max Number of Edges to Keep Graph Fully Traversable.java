                else {
                    if(Alice) cycleAlice++;
                    else AliceComponent--;
                    if(Bob) cycleBob++;
                    else BobComponent--;
                } 
            } else if(edge[0]==2){
                if(union(edge[1],edge[2],componentsBob,sizeBob))
                    cycleBob++;
                else BobComponent--;
            } else {
                if(union(edge[1],edge[2],componentsAlice,sizeAlice))
                    cycleAlice++;
                else AliceComponent--;
            }
        }
        if(AliceComponent >1||BobComponent>1) return -1;
        return cycleAlice+cycleBob+commonCycle;
    }
    
    private int find(int i,int[] parent){
        while(parent[i]!=i){
            // compress path
            i=parent[parent[i]];
        }
        return i;
    }
    
    boolean union(int a,int b,int[] parent,int[] size){
        int parentA=find(a,parent);
        int parentB=find(b,parent);
        // node a is already connected with node b. so this edge is redundant. 
        if(parentA==parentB) return true;
        // use size to determine which node can be parent 
        if(size[parentA]>size[parentB]){
            parent[parentB]=parentA;
            size[parentA]+=size[parentB];
