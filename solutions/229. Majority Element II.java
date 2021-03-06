class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1= 0;
        int count2 =0;
        int num1 =-1;
        int num2 =-1;
        List<Integer> res = new ArrayList<>();
        int majority = (int)Math.floor(nums.length/3);
​
        for(int element : nums){
            if(element == num1){
                count1++;
            }else if(element == num2){
                count2++;
            }else if(count1 ==0){
                num1 = element;
                count1 =1;
            }else if(count2 ==0){
                num2 = element;
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }
        
         count1 =0;
         count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == num1){
                count1++;
            }else if(nums[i] == num2){
                count2++;
            }
            
        }
        if(count1 > majority){
            res.add(num1);
        }
        if(count2 > majority){
            res.add(num2);
        }
       
        return res;
    }
}
