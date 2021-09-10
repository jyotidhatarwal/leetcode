class Solution {
    public boolean checkValidString(String s) {
        int i =0;
        int j =0;
        char[] arr = s.toCharArray();
        for(char ch : arr){
            if(ch == '('){
                i += 1;
            }else{
                i += -1;
            }
            if(ch != ')'){
                j += 1;
            }else{
                j += -1;
            }
            if(j < 0){
                break;
            }
            i = Math.max(i,0);
        }
        if( i == 0){
            return true;
        }
        return false;
    }
}
