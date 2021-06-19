class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        int count =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(List<Integer> row : wall){
            int prefixSum =0;
            for(int j=0;j<row.size()-1;j++){
                prefixSum += row.get(j);
                map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
                count = Math.max(count,map.get(prefixSum));
            }
        }
       
        int ans = n- count;
        return ans;
    }
}
