class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[n+m];
        double median = 0.0;
        int i=0;
        int j =0;
        int k=0;
        while(i < n && j < m){
            int val1 = nums1[i];
            int val2 = nums2[j];
            if(val1 < val2){
                ans[k] = val1;
                i++;
                k++;
            }else{
                ans[k] = val2;
                j++;
                k++;
            }
        }
        while(i < n){
            ans[k] = nums1[i];
            k++;
            i++;
        }
        while(j < m){
            ans[k] = nums2[j];
            j++;
            k++;
        }
        int lo =0;
        int hi = ans.length-1;
        
            int mid = lo + (hi - lo)/2;
            if(ans.length % 2 == 1){
                median = (double)ans[mid];
            }else{
                median = (double)(((double)ans[mid] + (double)ans[mid+1])/2.0);
            }
        
        return median;
    }
}
