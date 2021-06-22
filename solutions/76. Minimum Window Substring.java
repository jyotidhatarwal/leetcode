class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character,Integer> mapForT = new HashMap<>();
        for(int i=0;i<t.length();i++){
            mapForT.put(t.charAt(i),mapForT.getOrDefault(t.charAt(i),0)+1);
        }
        
        HashMap<Character,Integer> mapForS = new HashMap<>();
        
        int matchCount =0;
        int i=0;
        int j=0;
​
        String ans = "";
        while(true){
        boolean flag1 = false;
        boolean flag2 = false;
            // acquire
            while(j<s.length() && matchCount < t.length()){
                char ch  = s.charAt(j);
                mapForS.put(ch,mapForS.getOrDefault(ch,0)+1);
                if(mapForS.getOrDefault(ch,0) <= mapForT.getOrDefault(ch,0)){
                    matchCount++;
                }
                j++;
                flag1 = true;
            }
            // store answer string and release
            while(i < j && matchCount == t.length()){
                String potentialAnswer = s.substring(i,j);
                if(ans.length() == 0 || potentialAnswer.length() < ans.length()){
                    ans = potentialAnswer;
                }
                char ch = s.charAt(i);
                if(mapForS.get(ch) == 0){
                    mapForS.remove(ch);
                }else{
                    mapForS.put(ch,mapForS.get(ch)-1);
                }
                if(mapForS.getOrDefault(ch,0) < mapForT.getOrDefault(ch,0)){
                    matchCount--;
                }
                i++;
                flag2 = true;
            }
            if(flag1 == false && flag2 == false){
                break;
            }
        }
        return ans;
    }
}
