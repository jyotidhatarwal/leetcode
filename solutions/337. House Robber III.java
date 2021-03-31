/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // class HousePair{
    //     int withRobbery =0;
    //     int withoutRobbery =0;
    // }
//     public HousePair robHelp(TreeNode root){
//         if(root == null) return new HousePair();
        
//         HousePair left = robHelp(root.left);
//         HousePair right = robHelp(root.right);
//         HousePair ans = new HousePair();
        
//         ans.withRobbery = left.withoutRobbery + root.val + right.withoutRobbery;
//         ans.withoutRobbery = Math.max(left.withRobbery,left.withoutRobbery) + Math.max(right.withRobbery,right.withoutRobbery);
//         return ans;
        
//     }
   // public int rob(TreeNode root) {
    //     HousePair result = robHelp(root);
    //     return Math.max(result.withRobbery,result.withoutRobbery);
    // }
    /*   Array --> with robbery , without robbery   */
    
    public int[] robHelp(TreeNode root){
        if(root == null) return new int[2];
        int[] left = robHelp(root.left);
        int[] right = robHelp(root.right);
        int[] ans = new int[2];
        ans[0] = left[1] + root.val + right[1];
        ans[1] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        return ans;
    }
    public int rob(TreeNode root){
        int[] result = robHelp(root);
        return Math.max(result[0],result[1]);
    }
}
