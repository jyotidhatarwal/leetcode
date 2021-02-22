class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr.length <=1){
            return true;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for(int val : arr){
            min = Math.min(val,min);
            max = Math.max(val,max);
            set.add(val);
        }
        int d = (max-min)/(arr.length-1);
        for(int i=0;i<arr.length;i++){
            int ai = min +i*d;
            if(set.contains(ai) == false){
                return false;
            }
        }
        return true;
    }
}
