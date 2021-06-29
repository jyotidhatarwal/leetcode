class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int idx =0;
        for(int[] interval : intervals){
            // if the starting point of interval is smaller than the starting point of new Interval then                add that interval to the arrayList
            if(interval[0] < newInterval[0]){
                list.add(interval);
            }else{
                break;
            }
        }
        
        // if the starting point of new interval is greater than the end point of the previous interval             that is present in the list then add the new interval to list
        if(list.size() == 0 || newInterval[0] > list.get(list.size()-1)[1]){
            list.add(newInterval);
        }else{
            int[] prevInterval = list.get(list.size()-1);
            prevInterval[1] = Math.max(prevInterval[1],newInterval[1]);
        }
        while(idx < intervals.length){
            int[] prevInterval = list.get(list.size()-1);
            if(prevInterval[1] >= intervals[idx][0]){
                // merging will take place
                prevInterval[1] = Math.max(prevInterval[1],intervals[idx][1]);
            }else{
                list.add(intervals[idx]);
            }
            idx++;
        }
        // converting list to 2 D array
        return list.toArray(new int[list.size()][]);
    }
}
