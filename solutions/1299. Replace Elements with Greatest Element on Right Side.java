class Solution {
    public int[] replaceElements(int[] arr) {
        for(int i=arr.length-1,max =-1;i>=0;--i){
            int temp = arr[i];
            arr[i]= max;
            max=Math.max(max,temp);
        }
        return arr;
        
    }
}
