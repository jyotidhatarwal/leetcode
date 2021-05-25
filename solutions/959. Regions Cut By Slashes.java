        for(int i=0;i<n+1;i++){
            union(index(i,0,m+1),0,parent,rank);
            union(index(i,m,m+1),0,parent,rank);            
        }
        for(int j=0;j<m+1;j++){
            union(index(0,j,m+1),0,parent,rank);
            union(index(n,j,m+1),0,parent,rank);            
        }
        
        int numRegions = 1;
        
        
        for(int i=0;i<n;i++){
            String str = grid[i];
​
            for(int j=0;j<m;j++){
                
                char ch = str.charAt(j);
                
                if(ch =='/'){
                    int curr = index(i+1,j,m+1);                
                    int nbr = index(i,j+1,m+1);
                    if(findLeader(curr,parent)==findLeader(nbr,parent)){
                        numRegions++;
                    }
                    else{
                        union(curr,nbr,parent,rank);
                    }
                }
                else if(ch=='\\'){
                    int curr = index(i,j,m+1);
                    int nbr = index(i+1,j+1,m+1);
                    if(findLeader(curr,parent)==findLeader(nbr,parent)){
                        numRegions++;
                    }
                    else{
                        union(curr,nbr,parent,rank);
                    }
                }
                
            }
        }
        
        return numRegions;        
        
        
    }
}
