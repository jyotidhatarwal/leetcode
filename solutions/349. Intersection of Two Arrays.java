class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
      HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])){
            ans.add(nums2[i]);
            map.remove(nums2[i]);
            }
        }
        int[] res = new int[ans.size()];
        int i=0;
        for(int ele : ans){
            res[i++] = ele;
        }
        return res;
    }
}
