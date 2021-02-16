class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        char[] a = S.toLowerCase().toCharArray();
        helper(a, 0, res);
        return res;
    }
    
    void helper(char[] a, int pos, List<String> res){
        if(pos==a.length){
            res.add(new String(a));
            return;
        }
        
        helper(a, pos+1, res);
        if(Character.isLetter(a[pos])) {
            a[pos] = Character.toUpperCase(a[pos]);
            helper(a, pos+1, res);
            a[pos] = Character.toLowerCase(a[pos]);
        }
    }
}
