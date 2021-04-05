class Solution {
    public boolean isIdealPermutation(int[] arr) {
        
        int len = arr.length;
        
        if(len < 3) return true;
        
        int j = len - 1;
        int i = len - 3;
        int min = arr[j];
        
        while( i >= 0 ) {
            if(arr[i] > min) return false;
             j--;
             i--;
             min = Math.min(arr[j], min);
        }
        
        return true;
     }
}
