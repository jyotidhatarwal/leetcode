        
        for(int i=0;i<m;i++){
            visited[i][0] = true;
            visited[i][n-1] = true;
            pq.add(new Pair(i,0,heightMap[i][0]));
            pq.add(new Pair(i,n-1,heightMap[i][n-1]));
        }
        for(int i=0;i<n;i++){
            visited[0][i] = true;
            visited[m-1][i] = true;
            pq.add(new Pair(0,i,heightMap[0][i]));
            pq.add(new Pair(m-1,i,heightMap[m-1][i]));
        }
        
        int ans =0;
        
        while(pq.size() > 0){
            Pair rem = pq.remove();
            int row = rem.row;
            int col = rem.col;
            int height = rem.height;
            
            for(int[] dir : dirs){
                int r = row + dir[0];
                int c = col + dir[1];
                
                if(r > 0 && r < m-1 && c > 0 && c < n-1 && visited[r][c] == false){
                    visited[r][c] = true;
                    ans += Math.max(0,height-heightMap[r][c]);
                    pq.add(new Pair(r,c,Math.max(height,heightMap[r][c])));
                }
            }
        }
        return ans;
    }
}
