class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> fmap = new HashMap<>();
        for(char ch:s.toCharArray()){
            fmap.put(ch,fmap.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(fmap.get(ch)==1){
                return i;
            }
        }
        return -1;
    }
}
