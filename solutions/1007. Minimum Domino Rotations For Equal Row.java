class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int count1=0;
        int count2=0;
        int count3 =0;
        int count4 =0;
        int num1 = tops[0];
        int num2 = bottoms[0];
        int max =Integer.MAX_VALUE;
        for(int i=0;i<tops.length;i++){
            // for num1
            // count1 -> No. of swapping required to make top array as num1
            if(count1 != max){
                if(tops[i] == num1){
                    // nothing to do
                }else if(bottoms[i] == num1){
                    count1++;   // there is 1 swap possible
                }else{
                    count1 = max;
                }
            }
            // count2 -> No. of swapping required to make bottom array as num1
            if(count2 != max){
                if(bottoms[i] == num1){
                    // nothing to do
                }else if(tops[i] == num1){
                    count2++;   // there is 1 swap possible
                }else{
                    count2 = max;
                }
            }
            // for num2
            // count3 -> No. of swapping required to make bottom array as num2
            if(count3 != max){
                if(bottoms[i] == num2){
                    // nothing to do
                }else if(tops[i] == num2){
                    count3++;   // there is 1 swap possible
                }else{
                    count3 = max;
                }
            }
            // count4 -> No. of swapping required to make top array as num2
            if(count4 != max){
                if(tops[i] == num2){
                    // nothing to do
                }else if(bottoms[i] == num2){
                    count4++;   // there is 1 swap possible
                }else{
                    count4 = max;
                }
            }
            
        }
     int result = Math.min(Math.min(count1,count2),Math.min(count3,count4));
        if(result == max){
            return -1;
        }
        return result;
    }
}
