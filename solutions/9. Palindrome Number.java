class Solution {
    public boolean isPalindrome(int x) {
      if(x ==0){
            return true;
        }
        
        if(x<0 || x%10 ==0){
           return false;
       }
        int on =x;
        int val=0;
        while(x != 0){
            int r = x%10;
            if(val > Integer.MAX_VALUE || val < Integer.MIN_VALUE){
                return false;
            }
            val = val*10 +r;
            x = x/10;
        }
        
        if(val == on){
            return true;
        }
       return false;
        
    }
}
