class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int reverseNumber = reverse(x);
        if(x == reverseNumber){
            return true;
        }
        return false;
    }
    private int reverse(int x){
        int val =0;
        while(x != 0){
            int remainder = x % 10;
            if(val > Integer.MAX_VALUE || val < Integer.MIN_VALUE){
                return 0;
            }
            val = val*10 + remainder;
            x = x/10;
        }
        return val;
    }
}
