class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
       
        
        HashMap<Character,String> map = new HashMap<>();
        HashMap<String,Boolean> used = new HashMap<>();
         if(words.length != pattern.length()){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch) == false){
                if(used.containsKey(words[i]) == true){
                    return false;
                }else{
                    used.put(words[i],true);
                    map.put(ch,words[i]);   
                }
            }else{
                String mappedWith = map.get(ch);
                if(mappedWith.equals(words[i]) == false){
                    return false;
                }
            }
            
        }
        return true;
    }
}
