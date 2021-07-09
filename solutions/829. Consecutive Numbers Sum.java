class Solution {
    public int consecutiveNumbersSum(int N) {
        int x;
        int k = 1;
        int count =0;
        while(k*k<(2*N)){
            x = (N-((k-1)*k)/2); 
            if(x % k == 0){
                count++;
            }
            k++;
        }
        return count;
    }
}
