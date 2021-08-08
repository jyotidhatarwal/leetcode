class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[]pointers = new int[primes.length];
        int[] dp = new int[n+1];
        Arrays.fill(pointers,1);
        dp[1] =1;
        for(int i=2;i<=n;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<primes.length;j++){
                min = Math.min(min,primes[j]*dp[pointers[j]]);
            }
            dp[i] = min;
            for(int j=0;j<primes.length;j++){
                if(primes[j]*dp[pointers[j]] == min){
                    pointers[j]++;
                }
            }
        }
        return dp[n];
    }
}
