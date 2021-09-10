class Solution {
    public boolean isAnagram(String s, String t) {
        boolean result = true;
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            if(map.getOrDefault(ch,0) > 0){
                map.put(ch,map.get(ch)-1);
            }else{
                result = false;
                break;
            }
        }
        return result;
    }
}
