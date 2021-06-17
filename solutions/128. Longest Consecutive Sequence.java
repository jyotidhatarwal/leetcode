class Solution {
    public int longestConsecutive(int[] nums) {
        int max =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            if(map.containsKey(n) == false){
                int startPoint = n;
                int endPoint = n;
            
            if(map.containsKey(n-1) == true){
                startPoint = n - map.get(n-1);
            }
            if (map.containsKey(n+1) == true){
                endPoint = n + map.get(n+1);
            }
            int newLength = endPoint - startPoint +1;
            map.put(startPoint,newLength);
            map.put(endPoint,newLength);
            if(startPoint != n && endPoint != n){
                map.put(n,1);
            }
            max = Math.max(max,newLength);
        }
        }
        return max;
    }
}
