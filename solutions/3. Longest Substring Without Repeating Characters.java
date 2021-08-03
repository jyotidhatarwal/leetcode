class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans =0;
        HashMap<Character,Integer> map = new HashMap<>();
        int i= 0;
        int j =0;
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            // acquire
            while(j < s.length()){
                flag1 = true;
                char ch = s.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.get(ch) ==2){
                    j++;
                    break;
                }else{
                    int length = j-i+1;
                    if(length > ans){
                        ans = length;
                    }
                }
                j++;
            }
            // release
            while(i < j){
                flag2 = true;
                char ch =s.charAt(i);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch) == 1){
                    i++;
                    break;
                }
                i++;
            }
            if(flag1 == false && flag2 == false){
                break;
            }
        }
        return ans;
    }
}
