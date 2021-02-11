class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer>remainderFMap = new HashMap<>();
        for(int val:arr){
            int rem = val % k;
            int oldFrequency = remainderFMap.getOrDefault(rem,0);
            remainderFMap.put(rem,oldFrequency+1);
        }
        for(int val:arr){
            int rem = val % k;
            if(rem==0){
                int frequency = remainderFMap.get(rem);
                if(frequency % 2==1){
                    return false;
                }
            }else if(2 * rem ==k){
                int frequency = remainderFMap.get(rem);
                if(frequency %2 ==1){
                    return false;
                }
            }else{
                int frequency = remainderFMap.get(rem);
                int complementaryFrequency = remainderFMap.getOrDefault(k-rem,0);
                if(frequency != complementaryFrequency){
                    return false;
                }
            }
        }
        return true;
    }
}
