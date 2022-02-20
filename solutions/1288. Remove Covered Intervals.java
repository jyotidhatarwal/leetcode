class Solution {
    public int removeCoveredIntervals(int[][] A) {
      int res = 0, left = -1, right = -1;
        Arrays.sort(A, (a, b) -> a[0] - b[0]);
        for (int[] v : A) {
            if (v[0] > left && v[1] > right) {
                left = v[0];
                ++res;
            }
            right = Math.max(right, v[1]);
        }
        return res;
    }
     public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) ->{
            return a[0] - b[0];
        });
        List<int[]> list = new ArrayList<>();
        for(int[] interval : intervals){
            if(list.size() == 0){
                list.add(interval);
            }else{
                int[] prevInterval = list.get(list.size()-1);
                // merging takes place
                if(interval[0] <= prevInterval[1]){
                    prevInterval[1] = Math.max(interval[1],prevInterval[1]);
                }else{
                    list.add(interval);
                }
            }
            
        }
        return list.toArray(new int[list.size()][]);
    }
}
