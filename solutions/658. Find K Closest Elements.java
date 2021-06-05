class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int hi = arr.length-1;
        int mid =0;
        while(low <= hi){
            mid = (low + hi) /2;
            if(arr[mid] == x){
                break;
            }else if(arr[mid] < x){
                low = mid+1;
            }else{
                hi = mid-1;
            }
        }
        int left = mid-1;
        int right = mid;
        List<Integer> list = new ArrayList<>();
        while(left >= 0 && right <= arr.length-1 && k> 0){
          if(Math.abs(arr[left]-x)  <=  Math.abs(arr[right] - x) ){
                list.add(arr[left]);
                left--;
            }else{
                list.add(arr[right]);
                right++;
            }
            k--;
        }
        while(k > 0 && left >= 0){
            list.add(arr[left]);
            left--;
            k--;
        }
        while(k > 0 && right <= arr.length-1){
            list.add(arr[right]);
            right++;
            k--;
        }
        Collections.sort(list);
        return list;
    }
}
