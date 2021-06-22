class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()){
            return new ArrayList<>();
        }
        HashMap<Character,Integer> mapForP = new HashMap<>();
        for(int i=0;i<p.length();i++){
            mapForP.put(p.charAt(i),mapForP.getOrDefault(p.charAt(i),0)+1);
        }
        
        HashMap<Character,Integer> mapForS = new HashMap<>();
        for(int i=0;i<p.length();i++){
            mapForS.put(s.charAt(i),mapForS.getOrDefault(s.charAt(i),0)+1);
        }
        
        // for acquire and release
        int i =0;
        int j = p.length();
        List<Integer> ans = new ArrayList<>();
        
        while(j<s.length()){
            if(compare(mapForS,mapForP) == true){
                ans.add(i);
            }
            
            char acquire = s.charAt(j);
            mapForS.put(acquire,mapForS.getOrDefault(acquire,0)+1);
            
            char release =  s.charAt(i);
            if(mapForS.get(release) == 0){
                mapForS.remove(release);
            }else{
                mapForS.put(release,mapForS.get(release)-1);
            }
            i++;
            j++;   
        }
        if(compare(mapForS,mapForP) == true){
            ans.add(i);
        }
        System.out.println(s.length());
        System.out.println(p.length());
        return ans;
        
    }
    private boolean compare(HashMap<Character,Integer> mapForS,HashMap<Character,Integer> mapForP){
        for(char keyInS : mapForS.keySet()){
           int valForP = mapForP.getOrDefault(keyInS,0);
            int valForS =  mapForS.get(keyInS);
            if(valForP != valForS){
                return false;
            }
        }
        return true;
    }
}
​
​
