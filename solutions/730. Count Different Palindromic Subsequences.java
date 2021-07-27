            }else{
                next[i] = map.get(ch);
            }
            map.put(ch,i);
        }
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                if(gap == 0){
                    dp[i][j] = 1;
                }else if(gap == 1){
                    dp[i][j] = 2;
                }else{
                    char start = s.charAt(i);
                    char end = s.charAt(j);
                    if(start != end){
                        int a = dp[i][j-1]  + dp[i+1][j];
                        int b = dp[i+1][j-1];
                        dp[i][j]  = (int)((a-b)% 1000000007 + 1000000007) % 1000000007;
                    }else{
                         int Next = next[i];
                        int Prev = prev[j];
                        if(Next > Prev){
                            dp[i][j] = 2*dp[i+1][j-1];
                            dp[i][j] %= 1000000007;
                            dp[i][j] += 2;
                            
                        }else if(Next == Prev){
                            dp[i][j] = 2*dp[i+1][j-1];
                            dp[i][j] %= 1000000007;
                            dp[i][j] += 1;
                        }else if(Next < Prev){
                            long a = 2*dp[i+1][j-1];
                            long b = dp[Next+1][Prev-1];
                            dp[i][j] =  (int)(((a-b)% 1000000007 + 1000000007)  % 1000000007);
                        }
                    }
                   
                }
            }
        }
        return dp[0][n-1] % 1000000007;
    }
}
