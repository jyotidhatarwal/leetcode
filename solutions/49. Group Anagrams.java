class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer> , List<String> > bigMap = new HashMap<>();
        for(String str : strs){
            HashMap<Character,Integer> fmap = new HashMap<>();
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                fmap.put(ch,fmap.getOrDefault(ch,0)+1);
            }
            if(bigMap.containsKey(fmap) == false){
                List<String> list = new ArrayList<String>();
                list.add(str);
                bigMap.put(fmap,list);
            }else{
                List<String> list = bigMap.get(fmap);
                list.add(str);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String> val: bigMap.values()){
            result.add(val);
        }
        return result;
    }
}
