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
        val =x;
        count(root);
        if(Math.max(Math.max(left,right),n-left-right-1) > n/2){
            return true;
        }
        return false;
    }
    private int count(TreeNode root){
        if(root == null){
            return 0;
        }
        int lc = count(root.left);
        int rc = count(root.right);
        if(root.val == val){
            lc = left;
            rc = right;
        }
        return lc + rc +1;
    }
}
