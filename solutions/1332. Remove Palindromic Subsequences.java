class Solution {
    public int removePalindromeSub(String s) {
        if(s.length() == 0){
            return 0;
        }
        if(isPalindrome(s) == true){
            return 1;
        }else{
            return 2;
        }
    }
    private boolean isPalindrome(String s){
        
        int left =0;
        int right = s.length()-1;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
