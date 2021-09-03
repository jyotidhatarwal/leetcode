class Solution {
    public String convertToTitle(int columnNumber) {
     StringBuilder sb = new StringBuilder();
        while(columnNumber > 0){
             int rem = columnNumber % 26;
            if(rem == 0){
                sb.append('Z');
                columnNumber = (int)Math.floor(columnNumber/26.0)-1;
            }else{
                sb.append((char)((rem-1)+'A'));
                columnNumber = (int)Math.floor(columnNumber/26.0);
            }
        }
        String str = sb.toString();
        return reverse(str);
    }
    private String reverse(String s){
        String str ="";
        for(int i=s.length()-1;i>=0;i--){
            str += s.charAt(i);
        }
        return str;
    }
}
