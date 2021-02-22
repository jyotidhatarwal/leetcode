class Solution {
    public boolean canReorderDoubled(int[] arr) {
        if(arr.length ==0){
            return true;
        }
        HashMap<Integer,Integer> fmap = new HashMap<>();
        for(int val:arr){
            fmap.put(val,fmap.getOrDefault(val,0)+1);
        }
        Integer[] A = new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            A[i] = arr[i];
        }
        Arrays.sort(A,(a,b) ->{
           return Math.abs(a) - Math.abs(b); 
        });
        for(int val :A){
            if(fmap.get(val) ==0){
                continue;
            }
            if(fmap.getOrDefault(2*val,0) ==0){
                return false;
            }
            fmap.put(val,fmap.get(val)-1);
            fmap.put(2*val,fmap.get(2*val) -1);
        }
        return true;
    }
}
