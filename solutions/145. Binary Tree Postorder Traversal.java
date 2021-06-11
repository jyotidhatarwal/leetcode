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
    public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
         help(root,ans);
        return ans;
    }
    private void help(TreeNode root,List<Integer> ans){
        if(root == null) return;
        help(root.left,ans);
        help(root.right,ans);
        ans.add(root.val);
    }
    
}
