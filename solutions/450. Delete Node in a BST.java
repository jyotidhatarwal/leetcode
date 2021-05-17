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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key > root.val){
            root.right = deleteNode(root.right,key);
        }else if(key < root.val){
            root.left = deleteNode(root.left,key);
        }else{
            root = delete(root);
        }
        return root;
    }
    private TreeNode delete(TreeNode node){
        if(node.left == null && node.right == null) return null;
        else if(node.right == null) return node.left;
        else if(node.left == null) return node.right;
        else{
            TreeNode rootp1 = node.right;
            while(rootp1.left != null){
                rootp1 = rootp1.left;
            }
            rootp1.left = node.left;
            return node.right;
        }
    }
}
