class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        
        return dp(strs,m,n,0,new HashMap<>());
    }
    
    private int dp(String[] strs, int m, int n,int i,Map<String,Integer> map){
        
        if(m==0 && n ==0 || i >= strs.length) // base condition
            return 0;
        
        StringBuilder sb = new StringBuilder();
        String key = sb.append(m).append(',').append(n).append(',').append(i).toString(); // key generation for memoization, store in a map
        // System.out.println(key);
        
        if(map.containsKey(key))
            return map.get(key);
        
        int z = 0,o=0,res;
        for(char a : strs[i].toCharArray()) // counting 0's and 1's in the str at index i
            if(a == '0') z++;
            else o++;
        
        
        
        if(z>m || o>n)
            res =  dp(strs,m,n,i+1,map); // skip the current string at index i, if it crosses the limit of m or n
        else 
            res =  Math.max(dp(strs,m,n,i+1,map),1 + dp(strs,m-z,n-o,i+1,map)); // typical knapsack condition Max(without,with)
        map.put(key,res); // memoization
        
        return res;
    }
}
