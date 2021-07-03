class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int lastDropLocation = -1;
        for(int[] trip : trips){
            lastDropLocation = Math.max(lastDropLocation,trip[2]);
        }
        int[] highway = new int[lastDropLocation+1];
        for(int[] trip : trips){
            // at pickup index add passenger count to highway array at pickup index
            highway[trip[1]] += trip[0];
            // at drop index subtract passenger count to highway array at drop index
            highway[trip[2]] -= trip[0];
        }
        
        // now calculate cumulative sum and if at any index find sum greater than the capacity of car           // return false
        
        boolean result = true;
        for(int i=1;i<=lastDropLocation;i++){
            highway[i] += highway[i-1];
            if(highway[i] > capacity){
                result = false;
                break;
            }
        }
        return result;
