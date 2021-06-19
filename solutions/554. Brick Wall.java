class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int noOfRows = wall.size();
       int maxEmptySpace =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(List<Integer> row : wall){
            int prefixSum =0;
            for(int j=0;j<row.size()-1;j++){
                prefixSum += row.get(j);
                map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
               maxEmptySpace = Math.max(maxEmptySpace,map.get(prefixSum));
            }
        }
        int minBricksToCross = noOfRows - maxEmptySpace;
        return  minBricksToCross;
    }
}
