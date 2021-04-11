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
    private int ans = 0;
​
    public int deepestLeavesSum(TreeNode root) {
        int max = maxDepth(root);
        calculate(root, 1, max);
        return ans;
    }
​
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
​
    private void calculate(TreeNode root, int depth, int max) {
        if (root == null) return;
        if (depth == max) {
            ans += root.val;
        } else {
            calculate(root.left, depth + 1, max);
            calculate(root.right, depth + 1, max);
        }
    } 
}
