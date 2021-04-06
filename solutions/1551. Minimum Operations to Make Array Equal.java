class Solution {
   // TC : O(n)
    // SC : O(1)
     public int minOperations(int n) {
         int ans = 0;
         for(int i=1;i<n;i=i+2){
             ans += (n-i);
         }
         return ans;
     }
}
