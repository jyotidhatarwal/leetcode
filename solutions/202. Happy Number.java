class Solution {
    public boolean isHappy(int n) {        
        HashMap<Integer,Integer> map = new HashMap<>();
        boolean result = false;
        while(n >=1){
            int ans = squareSum(n);
            map.put(ans,map.getOrDefault(ans,0)+1);
            if(ans == 1){
                result = true;
                break;
            }else{
                n = squareSum(n);
                if(map.get(n) > 1){
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
    private int squareSum(int n){
        int ans =0;
        while(n > 0){
            int temp = n % 10;
            ans += (temp*temp);
            n = n/10;
        }
        return ans;
    }
}
