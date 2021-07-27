class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][]dp = new boolean[m+1][n+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i == 0 && j == 0){
                    // first ceell
                    dp[i][j] = true;
                }else if(i == 0){
                    // first row
                    dp[i][j] = false;
                }else if(j == 0){
                    // first column
                    char patternCharacter = p.charAt(i-1);  
                    // as in dp ith character in pattern is mapped to i-1 position
                    if(patternCharacter == '*'){
                        dp[i][j] = dp[i-2][j];
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    // rest of the array
                    char patternCharacter = p.charAt(i-1);
                    char stringCharacter = s.charAt(j-1);
                    if(patternCharacter == '*'){
                        dp[i][j] = dp[i-2][j];
                        char patternSecondLastchar = p.charAt(i-2);
                        if(patternSecondLastchar == '.' || patternSecondLastchar == stringCharacter){
                            dp[i][j] = dp[i][j] || dp[i][j-1];
                        }
                    }else if(patternCharacter == '.'){
                        dp[i][j] = dp[i-1][j-1];
                    }else if(patternCharacter == stringCharacter){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        dp[i][j] = false;
                    }
                    
                }
            }
        }
        return dp[m][n];
    }
}
