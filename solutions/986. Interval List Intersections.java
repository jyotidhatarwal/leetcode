class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int ptr1 =0;
        int ptr2 =0;
        while(ptr1 < firstList.length && ptr2 < secondList.length){
            int commonStartPoint = Math.max(firstList[ptr1][0],secondList[ptr2][0]);
            int commonEndPoint = Math.min(firstList[ptr1][1],secondList[ptr2][1]);
            
            // valid interval
            if(commonStartPoint <= commonEndPoint){
                int[]interval = {commonStartPoint,commonEndPoint};
                list.add(interval);
            }
            // for moving ahead 
            // move in the list whose end point is smaller as it will not contribute in making new                      interval
            if(firstList[ptr1][1] < secondList[ptr2][1]){
                ptr1++;
            }else{
                ptr2++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
