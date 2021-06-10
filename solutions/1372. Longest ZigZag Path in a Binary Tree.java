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
    public class Pair{
        int forwardSlope = -1;
        int backwardSlope = -1;
        int maxLength =0;
    }
    private Pair help(TreeNode root){
        if(root == null) return new Pair();
        Pair left = help(root.left);
        Pair right = help(root.right);
        Pair ans = new Pair();
        ans.maxLength = Math.max(Math.max(left.maxLength,right.maxLength),Math.max(left.backwardSlope,right.forwardSlope)+1);
        ans.forwardSlope = left.backwardSlope +1;
        ans.backwardSlope = right.forwardSlope +1;
        return ans;
    }
    public int longestZigZag(TreeNode root) {
        Pair ans = help(root);
        return ans.maxLength;
    }
}
