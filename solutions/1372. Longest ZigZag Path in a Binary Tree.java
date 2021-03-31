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
        int forwardSlope = -1;
        int backwardSlope = -1;
        int maxLength =0;
    }
    public Pair longestZigZagHelp(TreeNode root){
        if(root == null) return new Pair();
        Pair left = longestZigZagHelp(root.left);
        Pair right = longestZigZagHelp(root.right);
        Pair ans = new Pair();
        ans.maxLength = Math.max(Math.max(left.maxLength,right.maxLength),Math.max(left.backwardSlope,right.forwardSlope)+1);
        ans.forwardSlope = left.backwardSlope +1;
        ans.backwardSlope = right.forwardSlope +1;
        return ans;
    }
    public int longestZigZag(TreeNode root) {
        Pair result = longestZigZagHelp(root);
        return result.maxLength;
        
    }
}
