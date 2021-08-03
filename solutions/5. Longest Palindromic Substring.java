class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][]dp = new boolean[n][n];
        String ans = "";
        for(int gap =0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
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
                if(dp[i][j] == true){
                    ans = s.substring(i,j+1);
                }
                
            }
        }
        return ans;
    }
}
