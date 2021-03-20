class Solution {
    public int fib(int n) {
       int ans = help(n,new int[n+1]);
        return ans;
    }
    public int help(int n,int[]qb){
        if(n==0 || n==1){
            return n;
        }
        if( qb[n] != 0){
            return qb[n];
        }
        int fibnm1 = help(n-1,qb);
        int fibnm2 = help(n-2,qb);
        int fibn = fibnm1 + fibnm2;
        qb[n] = fibn;
        return fibn;
    }
}
