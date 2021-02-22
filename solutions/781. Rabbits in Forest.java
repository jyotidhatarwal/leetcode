class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val:answers){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        int ans =0;
        for(int key: map.keySet()){
            int groupSize = key +1;
            int rabbitReported = map.get(key);
            int numberOfGroups  =  (int)Math.ceil(rabbitReported*1.0 / groupSize*1.0);
            ans += numberOfGroups * groupSize;
        }
        return ans;
        
    }
}
