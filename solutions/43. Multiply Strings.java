class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int l1 = num1.length();
        int l2 = num2.length();
        int[] result = new int[l1 + l2];
        int i = l2-1;
        int powerFactor =0;
        while(i >= 0){
            int ival = num2.charAt(i)-'0';
            i--;
            int j = l1-1;
            int k = result.length-1-powerFactor;
            int carry =0;
            while(j >=0 || carry != 0){
                int jval;
                if(j>=0){
                    jval = num1.charAt(j)-'0';
                }else{
                    jval=0;
                }
                j--;
                int product = ival*jval + carry + result[k];
                result[k] = product % 10;
                carry = product / 10;
                k--;
            }
            
            powerFactor++;
        }
        String ans = "";
        boolean flag = false;
        for(int val : result){
            if(val == 0 && flag == false){
                // these are leading zeros
                continue;
            }else{
                // first non zero found -> now this is the part of answer
                flag = true;
                ans += val;
            }
        }
        return ans;
    }
}
