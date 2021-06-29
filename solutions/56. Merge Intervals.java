class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
           return a[0] -b[0]; 
        });
        
        List<int[]> list = new ArrayList<>();
        for(int[] interval : intervals){
            if(list.size() == 0){
                list.add(interval);
            }else{
                int[] prevInterval = list.get(list.size()-1);
                // if starting point of current interval is smaller than the ending point of prevInterval then there is overlapping of update the endpoint of previous interval with maximum end point of current interval and previous interval
                if(interval[0] <= prevInterval[1]){
                    prevInterval[1] = Math.max(interval[1],prevInterval[1]);
                }else{
                    list.add(interval);
                }
            }
        }
        // converting list to 2 d array
        return list.toArray(new int[list.size()][]);
    }
}
