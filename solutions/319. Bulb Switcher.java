class Solution {
    public int bulbSwitch(int n) {
        int bulb =0;
        if(n == 0){
            return 0;
        }
        int i=1;
        while(i*i <= n){
            bulb++;
            i++;
        }
        return bulb;
    }
}
