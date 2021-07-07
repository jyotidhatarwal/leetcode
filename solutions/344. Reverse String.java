class Solution {
    public void reverseString(char[] s) {
        char[] ans = new char[s.length];
        int k=0;
        for(int i=s.length-1;i>=0;i--){
            char ch = s[i];
            ans[k] = ch;
            k++;
        }
        for(int i=0;i<s.length;i++){
            s[i] = ans[i];
        }
    }
}
