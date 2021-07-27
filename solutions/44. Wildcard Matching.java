class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][]dp = new boolean[m+1][n+1];
        for(int i=dp.length-1;i>=0;i--){
            for(int j = dp[0].length-1;j>=0;j--){
                if(i== dp.length-1 && j == dp[0].length-1){
                    // last cell
                    dp[i][j] = true;
                }else if(i == dp.length-1){
                    // last row
                    dp[i][j] = false;
                }else if(j == dp[0].length-1){
                    // last column
                    if(p.charAt(i) == '*'){
                        dp[i][j] = dp[i+1][j];
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    // rest of the array
                    if(p.charAt(i) == '?'){
                        dp[i][j] = dp[i+1][j+1];
                    }else if(p.charAt(i) == '*'){
                        dp[i][j] = dp[i][j+1] || dp[i+1][j];
                    }else if(p.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i+1][j+1];
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[0][0];
    }
}
