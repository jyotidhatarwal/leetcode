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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        dfs(root,arr);
        return arr;
    }
    private void dfs(TreeNode root,List<Integer> arr){
        if(root == null){
            return;
        }
        arr.add(root.val);
        dfs(root.left,arr);
        dfs(root.right,arr);
    }
}
