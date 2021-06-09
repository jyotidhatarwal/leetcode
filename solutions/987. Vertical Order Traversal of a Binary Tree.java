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
    public class vPair{
        TreeNode node = null;
        int hl =0;
        vPair(TreeNode node,int hl){
            this.node = node;
            this.hl =hl;
        }
    }
    public void width(TreeNode node,int hl,int[] ans){
        if(node == null) return;
        ans[0] = Math.min(ans[0],hl);
        ans[1] = Math.max(ans[1],hl);
        
        width(node.left,hl-1,ans);
