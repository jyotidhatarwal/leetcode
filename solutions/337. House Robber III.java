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
    class Pair{
        int withRobbery =0;
        int withoutRobbery =0;
    }
    public Pair robHelp(TreeNode root){
        if(root == null) return new Pair();
        Pair left = robHelp(root.left);
        Pair right = robHelp(root.right);
        Pair ans = new Pair();
        ans.withRobbery = left.withoutRobbery + root.val + right.withoutRobbery;
        ans.withoutRobbery = Math.max(left.withRobbery,left.withoutRobbery) + Math.max(right.withRobbery,right.withoutRobbery);
        return ans;
    }
    public int rob(TreeNode root) {
        Pair res = robHelp(root);
        return Math.max(res.withRobbery,res.withoutRobbery);
    }
}
