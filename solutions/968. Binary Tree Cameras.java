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
 
    
    // -1 i am covered by a camera .
    // 0 i am a camera.
    // 1 means i need a camera.
class Solution {
     int cameras = 0;
    public int minCamera(TreeNode root){
        if(root == null) return 1;
        
        int leftChild = minCamera(root.left);
        int rightChild = minCamera(root.right);
        
        if(leftChild == -1 || rightChild == -1){
            cameras++;
            return 0;
        }
        if(leftChild == 0 || rightChild == 0) return 1;
        
        return -1;
    }
    public int minCameraCover(TreeNode root) {
        if(minCamera(root) == -1) cameras++;
        return cameras;
        
    }
}
