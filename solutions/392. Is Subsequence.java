class Solution {
    public boolean isSubsequence(String s, String t) {
        int j=0;
        if(s.length() > t.length()) return false;
        if(s.isEmpty()) return true;
        for(int i=0;i<t.length();i++){
            if(j < s.length() && t.charAt(i) == s.charAt(j)){
                j++;
            }
        }
        if(j == s.length()) return true;
        return false;
    }
    public static ArrayList<String> getSubsequences(String t){
        if(t.length()==0){
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }
        char ch = t.charAt(0);
        String ros = t.substring(1);
        ArrayList<String> rr = getSubsequences(ros);
        ArrayList<String> mr = new ArrayList<>();
        for(String val:rr){
            mr.add(val);
            mr.add(ch + val);
        }
        return mr;
    }
}
