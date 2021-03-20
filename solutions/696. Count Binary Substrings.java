class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0;
        int pre =  0;
        int cur = 1;
        for (int i = 1;i < s.length();i++){
            if (s.charAt(i) != s.charAt(i-1)){
                res += Math.min(pre, cur);
                pre = cur;
                cur = 1;
            }
            else cur++;
        }
        res += Math.min(pre, cur);
        return res;
    }
}
