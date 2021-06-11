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
    int left,right,val;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        val = x;
        help(root);
       if(Math.max(Math.max(left,right),n-left-right-1) > n/2){
            return true;
        }
        return false;
    }
    private int help(TreeNode root){
        if(root == null) return 0;
        int l = help(root.left);
        int r = help(root.right);
        if(root.val == val){
            left = l;
            right =r;
        }
        return l+ r+1;
    }
}
