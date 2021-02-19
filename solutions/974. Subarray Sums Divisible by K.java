class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int count=0;
        int sum =0;
        int rem =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<A.length;i++){
            sum += A[i];
            rem = sum % K;
            if(rem <0){
                rem += K;
            }
            if(map.containsKey(rem)){
                count += map.get(rem);
                map.put(rem,map.getOrDefault(rem,0)+1);
            }else{
                map.put(rem,1);
            }
        }
        return count;
    }
}
