class Solution {
    public List<Integer> partitionLabels(String S) {
        int n = S.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(S.charAt(i),i);
        }
        int prev =-1;
        int max =0;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            char ch = S.charAt(i);
            max = Math.max(max,map.get(ch));
            if(max == i){
                ans.add(max - prev);
                prev = max;
            }
        }
        return ans;
    }
}
