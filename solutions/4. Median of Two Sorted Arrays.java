class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i=0;
        int j =0;
        int k = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                res[k] = nums1[i];
                i++;
                k++;
            }else{
                res[k] = nums2[j];
                j++;
                k++;
            }
        }
        while(i < nums1.length){
            res[k] = nums1[i];
            i++;
            k++;
        }
        while(j < nums2.length){
            res[k] = nums2[j];
            j++;
            k++;
        }
        int low = 0;
        int hi = res.length-1;
        double ans;
        
            if(res.length % 2 == 1){
                int mid = low + (hi - low)/2;
                ans = (double)(res[mid]);
            }else{
                int mid = low + (hi - low)/2;
                int  mid1 = mid +1;
                ans = (double)(((double)res[mid]+(double)res[mid1])/2);
            }
​
            
            
        return ans;
        
    }
}
