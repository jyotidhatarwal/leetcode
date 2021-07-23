class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int gap =0;gap<n;gap++){
            for(int i=0,j=gap;j<dp.length;i++,j++){
                if(gap == 0){
                    dp[i][j] = true;
                }else if(gap == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = false;
                    }   
                }
            }
        }
        
       int[]DP = new int[n];
        DP[0] = 0;
        for(int j=1;j<n;j++){
            if(dp[0][j]){
                DP[j] = 0;
            }else{
                 int min = Integer.MAX_VALUE;
              for(int i=j;i>=1;i--){
                  if(dp[i][j]){
                      if(DP[i-1] < min){
                          min = DP[i-1];
                      }
                  }
              }
            DP[j] = min +1;
        }
            }
             
        return DP[n-1];
    }
}
