class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : answers){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        int numberOfRabbitsInForest =0;
        for(int key : map.keySet()){
            int groupSize = key +1;
            int rabbitsReported = map.get(key);
            int numberOfGroups = (int) Math.ceil((rabbitsReported*1.0)/groupSize*1.0);
            numberOfRabbitsInForest += numberOfGroups * groupSize;
        }
        return numberOfRabbitsInForest;
    }
}
