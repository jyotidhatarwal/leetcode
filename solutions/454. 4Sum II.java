class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0;
        for(int e1:A){
            for(int e2 :B){
                map.put(e1 + e2,map.getOrDefault(e1 +e2,0)+1);
            }
        }
        int target=0;
        for(int e1:C){
            for(int e2:D){
                count += map.getOrDefault(target-(e1+e2),0);
            }
        }
        return count;
    }
}
