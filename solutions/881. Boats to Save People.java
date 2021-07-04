class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left =0;
        int right = people.length-1;
        int boat =0;
        while(left <= right){
            if(people[left] + people[right] <= limit){
                boat++;
                left++;
                right--;
            }else{
                boat++;
                right--;
            }
        }
        return boat;
    }
}
