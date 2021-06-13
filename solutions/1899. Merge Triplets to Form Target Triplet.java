class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int x =0;
        int y = 0;
        int z =0;
        for(int i=0;i<triplets.length;i++){
            if(triplets[i][0] <= target[0] && triplets[i][1] <= target[1] && triplets[i][2] <= target[2]){
                x = Math.max(x,triplets[i][0]);
                y = Math.max(y,triplets[i][1]);
                z = Math.max(z,triplets[i][2]);
                if(x == target[0] && y == target[1] && z == target[2]){
                    return true;
                }
            }
        }
        return false;
    }
}
