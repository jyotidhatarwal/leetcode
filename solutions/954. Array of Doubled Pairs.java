class Solution {
    public boolean canReorderDoubled(int[] arr) {
        if(arr.length == 0) return true;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : arr){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        Integer[] A = new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            A[i] = arr[i];
        }
        Arrays.sort(A,(a,b) ->{
           return Math.abs(a) - Math.abs(b); 
        });
        for(int val : A){
            if(map.get(val) == 0){
                continue;
            }
            if(map.getOrDefault(2*val,0) == 0){
                return false;
            }
            map.put(val,map.get(val)-1);
            map.put(2*val,map.get(2*val)-1);
        }
        return true;
    }
}
