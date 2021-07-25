class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][]dp = new boolean[n][n];
        int count =0;
        for(int gap =0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                if(gap == 0){
                    dp[i][j] = true;
                    count++;
                }else if(gap == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                        count++;
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                        dp[i][j] = true;
                        count++;
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        return count;
    }
}
