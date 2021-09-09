class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[]remainder = new int[60];
        int count =0;
        for(int t : time){
            count += remainder[(600-t) % 60];
            remainder[ t % 60]++;
        }
        return count;
    }
}
