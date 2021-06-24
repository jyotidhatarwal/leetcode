class Solution {
    
    int[][] dirs = {{0,0},{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,1},{1,-1}};
    
    HashMap<Integer,Integer> row = new HashMap<>();  
    HashMap<Integer,Integer> col = new HashMap<>();
    HashMap<Integer,Integer> diagonal1 = new HashMap<>(); // row - col 
    HashMap<Integer,Integer> diagonal2 = new HashMap<>(); // row + col 
    HashSet<Long> cells = new HashSet<>();
    
    public void turnOn(int r, int c, int n){
        row.put(r,row.getOrDefault(r,0) + 1);
        col.put(c,col.getOrDefault(c,0) + 1);
        diagonal1.put(r - c,diagonal1.getOrDefault(r - c,0) + 1);
        diagonal2.put(r + c,diagonal2.getOrDefault(r + c,0) + 1);
        // cells.put(r * n + c, cells.getOrDefault(r * n + c, 0) + 1);
        cells.add((long)(r * n + c));
    }
    
    public boolean isIlluminated(int r, int c, int n){
        if(row.containsKey(r) || col.containsKey(c)
           || diagonal1.containsKey(r - c) || diagonal2.containsKey(r + c)){
            return true;
        }
        
        return false;
    }
    
    public void turnOff(int r, int c, int n){
        for(int[] dir: dirs){
            int x = r + dir[0];
            int y = c + dir[1];
            
            if(x >= 0 && x < n && y >= 0 && y < n && cells.contains((long)(x * n + y))){
                cells.remove((long)(x * n + y));
                
                if(row.containsKey(x)){
                    row.put(x, row.get(x) - 1);
                    if(row.get(x) == 0) row.remove(x);
                }
                    
                if(col.containsKey(y)){
                    col.put(y, col.get(y) - 1);
                    if(col.get(y) == 0) col.remove(y);
                }
                    
                if(diagonal1.containsKey(x - y)){
