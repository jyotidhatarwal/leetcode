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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftHeight = leftCount(root);
        int rightHeight = rightCount(root);
        if(leftHeight == rightHeight){
            return (1 << leftHeight) -1;
        }
        return countNodes(root.left) + countNodes(root.right) +1;
    }
    private int leftCount(TreeNode root){
        int count=1;
        while(root.left != null){
            count++;
            root = root.left;
        }
        return count;
    }
    private int rightCount(TreeNode root){
        int count =1;
        while(root.right != null){
            count++;
            root = root.right;
        }
        return count;
    }
}
