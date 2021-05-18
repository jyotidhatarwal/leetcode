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
    int ans = Integer.MIN_VALUE;
    public int longestZigZag(TreeNode root) {
         help(root);
        return ans;
    }
    private int[] help(TreeNode root){
        int[] arr = new int[2];
        if(root == null){
            arr[0] = -1;
            arr[1] = -1;
            return arr;
        }
        int[] leftR = help(root.left);
        int[] rightR = help(root.right);
        int[] res = new int[2];
        res[0] = leftR[1] +1;
        res[1] = rightR[0] +1;
        ans = Math.max(ans,Math.max(res[0],res[1]));
        return res;
    }
}
