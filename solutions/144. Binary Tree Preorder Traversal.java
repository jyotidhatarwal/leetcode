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
    private void preorderHelp(TreeNode root,List<Integer> ans){
        if(root == null) return;
       
        ans.add(root.val);
        preorderHelp(root.left,ans);
        preorderHelp(root.right,ans);
        
    }
    public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
        preorderHelp(root,ans);
        return ans;
        
    }
}
